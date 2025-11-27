package co.istad.library.util;

import co.istad.library.model.Book;
import co.istad.library.model.BorrowRecord;
import co.istad.library.model.Member;
import co.istad.library.service.BookService;
import co.istad.library.service.MemberService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ImportUtil {

    private static final String DATA_FOLDER = "src/data/";

    public static List<Book> importBooksFromCSV(String fileName) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FOLDER + fileName))) {
            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 6) continue;
                Book b = new Book(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                b.setId(Integer.parseInt(parts[0]));
                b.setStatus(Boolean.parseBoolean(parts[5]));
                books.add(b);
            }
        } catch (Exception e) {
            System.out.println("No books CSV found or failed to read: " + e.getMessage());
        }
        return books;
    }

    public static List<Member> importMembersFromCSV(String fileName) {
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FOLDER + fileName))) {
            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3) continue;
                Member m = new Member(parts[1], parts[2]);
                m.setId(Integer.parseInt(parts[0]));
                members.add(m);
            }
        } catch (Exception e) {
            System.out.println("No members CSV found or failed to read: " + e.getMessage());
        }
        return members;
    }

    public static List<BorrowRecord> importBorrowRecordsFromCSV(String fileName, MemberService memberService, BookService bookService) {
        List<BorrowRecord> records = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE;

        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FOLDER + fileName))) {
            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 7) continue;

                int id = Integer.parseInt(parts[0]);
                int memberId = Integer.parseInt(parts[1]);
                int bookId = Integer.parseInt(parts[2]);
                int qty = Integer.parseInt(parts[3]);
                LocalDate borrowDate = LocalDate.parse(parts[4], fmt);
                LocalDate dueDate = LocalDate.parse(parts[5], fmt);
                boolean returned = Boolean.parseBoolean(parts[6]);

                Member member = memberService.getById(memberId);
                Book book = bookService.getById(bookId);
                if (member == null || book == null) continue;

                BorrowRecord r = new BorrowRecord(member, book, qty, borrowDate, dueDate);
                r.setId(id);
                r.setReturned(returned);
                records.add(r);
            }
        } catch (Exception e) {
            System.out.println("No borrow records CSV found or failed to read: " + e.getMessage());
        }
        return records;
    }
}
