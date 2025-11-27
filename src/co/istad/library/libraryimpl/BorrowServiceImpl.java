package co.istad.library.libraryimpl;

import co.istad.library.database.LibraryDatabase;
import co.istad.library.model.BorrowRecord;
import co.istad.library.model.Book;
import co.istad.library.service.BorrowService;

import java.util.List;

public class BorrowServiceImpl implements BorrowService {
    private final LibraryDatabase db;

    public BorrowServiceImpl(LibraryDatabase db) { this.db = db; }

    @Override
    public void borrow(BorrowRecord record) {
        Book book = record.getBook();
        if (book == null) {
            System.out.println("Book object is null in borrow record.");
            return;
        }
        if (book.getQty() >= record.getQty()) {
            // decrement quantity on the stored book instance
            Book stored = db.getBooks().stream()
                    .filter(b -> b.getId() == book.getId())
                    .findFirst().orElse(null);
            if (stored != null) {
                stored.setQty(stored.getQty() - record.getQty());
                db.addBorrowRecord(record);
            } else {
                System.out.println("Book not found in database.");
            }
        } else {
            System.out.println("Not enough quantity. Available: " + book.getQty());
        }
    }

    @Override
    public void returnBook(int borrowId) {
        for (BorrowRecord r : db.getBorrowRecords()) {
            if (r.getId() == borrowId && !r.isReturned()) {
                r.setReturned(true);
                Book b = db.getBooks().stream().filter(book -> book.getId() == r.getBook().getId()).findFirst().orElse(null);
                if (b != null) {
                    b.setQty(b.getQty() + r.getQty());
                }
                return;
            }
        }
        System.out.println("Borrow record not found or already returned.");
    }

    @Override
    public List<BorrowRecord> findAll() { return db.getBorrowRecords(); }
}
