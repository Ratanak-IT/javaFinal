package co.istad.library.service;

import co.istad.library.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
    List<Book> findAll();
    List<Book> search(String keyword);
    Book getById(int id);
}
