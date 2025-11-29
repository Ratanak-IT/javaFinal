package co.istad.library.service;

import co.istad.library.model.BorrowRecord;

import java.util.List;

public interface BorrowService {
    void borrow(BorrowRecord record);
<<<<<<< HEAD
    void returnBook(int borrowId);
=======
    boolean returnBook(int borrowId);
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    List<BorrowRecord> findAll();
}
