package co.istad.library.util;

import co.istad.library.model.Book;
import co.istad.library.model.BorrowRecord;
import co.istad.library.model.Member;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExportUtil {

    private static final String DATA_FOLDER = "src/data/";

    public static void exportBooksToCSV(List<Book> books, String fileName) {
        try (FileWriter writer = new FileWriter(DATA_FOLDER + fileName)) {
            writer.write("id,title,author,category,qty,status\n");
            for (Book b : books) {
                writer.write(String.format("%d,%s,%s,%s,%d,%b\n",
                        b.getId(),
                        b.getTitle(),
                        b.getAuthor(),
                        b.getCategory(),
                        b.getQty(),
                        b.isStatus()));
            }
            System.out.println("Books exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting books: " + e.getMessage());
        }
    }

    public static void exportMembersToCSV(List<Member> members, String fileName) {
        try (FileWriter writer = new FileWriter(DATA_FOLDER + fileName)) {
            writer.write("id,name,email\n");
            for (Member m : members) {
                writer.write(String.format("%d,%s,%s\n",
                        m.getId(),
                        m.getName(),
                        m.getEmail()));
            }
            System.out.println("Members exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting members: " + e.getMessage());
        }
    }

    public static void exportBorrowRecordsToCSV(List<BorrowRecord> records, String fileName) {
        try (FileWriter writer = new FileWriter(DATA_FOLDER + fileName)) {
            writer.write("id,memberId,bookId,qty,borrowDate,dueDate,returned\n");
            DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE;
            for (BorrowRecord r : records) {
                writer.write(String.format("%d,%d,%d,%d,%s,%s,%b\n",
                        r.getId(),
                        r.getMember().getId(),
                        r.getBook().getId(),
                        r.getQty(),
                        r.getBorrowDate().format(fmt),
                        r.getDueDate().format(fmt),
                        r.isReturned()));
            }
            System.out.println("Borrow records exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting borrow records: " + e.getMessage());
        }
    }
}
