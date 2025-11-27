package co.istad.library.model;

import java.time.LocalDate;

public class BorrowRecord {
    private int id;
    private Member member;
    private Book book;
    private int qty;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private boolean returned;

    public BorrowRecord() {}

    public BorrowRecord(Member member, Book book, int qty, LocalDate borrowDate, LocalDate dueDate) {
        this.member = member;
        this.book = book;
        this.qty = qty;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returned = false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Member getMember() { return member; }
    public Book getBook() { return book; }
    public int getQty() { return qty; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isReturned() { return returned; }
    public void setReturned(boolean returned) { this.returned = returned; }

    @Override
    public String toString() {
        return String.format("ID:%d | Member:%s | Book:%s | Qty:%d | Borrow:%s | Due:%s | Returned:%s",
                id, member.getName(), book.getTitle(), qty, borrowDate, dueDate, returned);
    }
}
