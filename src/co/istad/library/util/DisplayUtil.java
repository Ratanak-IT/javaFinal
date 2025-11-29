package co.istad.library.util;

import co.istad.library.model.Book;
import co.istad.library.model.Member;
import co.istad.library.model.BorrowRecord;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class DisplayUtil {

    // Print list of books as a table
    public static void printBooks(List<Book> books) {
        Table table = new Table(6, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("ID"); table.addCell("Title"); table.addCell("Author");
        table.addCell("Category"); table.addCell("Qty"); table.addCell("Available");
        for (Book b : books) {
            table.addCell(String.valueOf(b.getId()));
            table.addCell(b.getTitle());
            table.addCell(b.getAuthor());
            table.addCell(b.getCategory());
            table.addCell(String.valueOf(b.getQty()));
            table.addCell(String.valueOf(b.isStatus()));
        }
        System.out.println(table.render());
    }
    public final static String ADMINMENU= """
<<<<<<< HEAD
        ==== Admin Menu ====
         1. Add Book
         2. List/Paginate Books
         3. Search Book
         4. Update Book
         5. Delete Book
         6. Borrow Book
         7. Return Book
         8. Manage Members
         9. View Borrow Records & Availability
         10.Export data
         11. Logout
         0. exit system
    """;
    public final static String USERMENU= """
        ==== Admin Menu ====
         1. List/Paginate Books
         3. Search Book
         6. Borrow Book
         7. Return Book
         9. View Borrow Records & Availability
=======
        ||============= Admin Menu =============||
        || 1. Add Book                          ||
        || 2. List/Paginate Books               ||
        || 3. Search Book                       ||
        || 4. Update Book                       ||
        || 5. Delete Book                       ||
        || 6. Borrow Book                       ||
        || 7. Return Book                       ||
        || 8. Manage Members                    ||
        || 9. View Borrow Records & Availability||
        || 10. Export data                      ||
        || 11. Logout                           ||
        || 0. exit system                       ||
        ||======================================||
    """;
    public final static String USERMENU= """
        ==== User Menu ====
         1. List/Paginate Books
         2. Search Book
         3. Borrow Book
         4. Return Book
         5. Export data
         6. Logout
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
         0. Exit
    """;
    public final static String LOGINMENU= """
        ==== Login Menu ====
         1. Login
         2. exit
    """;
    public final static String PAGEMENU= """
         [1]. Next page
         [2]. Back page
         [0]. Back to menu
    """;
    public final static String EXPORTMENU= """
<<<<<<< HEAD
         Export Data
=======
          === Export Data ===
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
         [1]. Export Books
         [2]. Export Members
         [3]. Export Borrow Records
         [0]. Back to Main Menu
    """;
<<<<<<< HEAD
=======
    public final static String ManageMembers= """
         === Manage Members ===
          1. Add Member
          2. Update Member
          3. Delete Member
          4. List Members
          0. Back to Main Menu
    """;
        public final static String SEARCHMENU= """
         === Search Menu ===
         1. ID
         2. Title
         3. Author
         4. Category
         0. Back to Main Menu
    """;

>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8


    public static void printMembers(List<Member> members) {
        Table table = new Table(3, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("ID"); table.addCell("Name"); table.addCell("Email");
        for (Member m : members) {
            table.addCell(String.valueOf(m.getId()));
            table.addCell(m.getName());
            table.addCell(m.getEmail());
        }
        System.out.println(table.render());
    }

    public static void printBorrowRecords(List<BorrowRecord> records) {
        Table table = new Table(7, BorderStyle.UNICODE_ROUND_BOX_WIDE);
<<<<<<< HEAD
        table.addCell("ID"); table.addCell("Member"); table.addCell("Book");
=======
        table.addCell("Borrow ID"); table.addCell("Member"); table.addCell("Book");
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
        table.addCell("Qty"); table.addCell("Borrow"); table.addCell("Due"); table.addCell("Returned");
        for (BorrowRecord r : records) {
            table.addCell(String.valueOf(r.getId()));
            table.addCell(r.getMember().getName());
            table.addCell(r.getBook().getTitle());
            table.addCell(String.valueOf(r.getQty()));
            table.addCell(r.getBorrowDate().toString());
            table.addCell(r.getDueDate().toString());
            table.addCell(String.valueOf(r.isReturned()));
        }
        System.out.println(table.render());
    }

    // Convenience: print a page of books
    public static void printBooksPage(List<Book> books, int pageIndex, int pageSize) {
        int total = books.size();
        int from = pageIndex * pageSize;
        int to = Math.min(from + pageSize, total);
        if (from >= total || from < 0) {
            System.out.println("No books in this page.");
            return;
        }
        System.out.printf("Showing books %d to %d of %d (page %d)\n", from + 1, to, total, pageIndex + 1);
        printBooks(books.subList(from, to));
    }

}
