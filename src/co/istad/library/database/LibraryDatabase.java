package co.istad.library.database;

import co.istad.library.model.*;
<<<<<<< HEAD

=======
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
import java.util.ArrayList;
import java.util.List;

public class LibraryDatabase {

    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<BorrowRecord> borrowRecords = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    private int bookAutoId = 1;
    private int memberAutoId = 1;
    private int borrowAutoId = 1;

    public LibraryDatabase() {
        // default users
        users.add(new User("admin", "admin123", true));
        users.add(new User("user", "user123", false));
    }

    // id generators
    public int nextBookId() { return bookAutoId++; }
    public int nextMemberId() { return memberAutoId++; }
    public int nextBorrowId() { return borrowAutoId++; }

    // adders
    public void addBook(Book book) {
        book.setId(nextBookId());
        books.add(book);
    }

    public void addMember(Member member) {
        member.setId(nextMemberId());
        members.add(member);
    }

    public void addBorrowRecord(BorrowRecord record) {
        record.setId(nextBorrowId());
        borrowRecords.add(record);
    }

    // getters
    public List<Book> getBooks() { return books; }
    public List<Member> getMembers() { return members; }
    public List<BorrowRecord> getBorrowRecords() { return borrowRecords; }
    public List<User> getUsers() { return users; }
}
