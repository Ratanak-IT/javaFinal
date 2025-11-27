package co.istad.library.service;

import co.istad.library.model.BorrowRecord;

import java.util.List;

public interface BorrowService {
    void borrow(BorrowRecord record);
    boolean returnBook(int borrowId);
    List<BorrowRecord> findAll();
}
