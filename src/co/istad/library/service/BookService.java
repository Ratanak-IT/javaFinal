package co.istad.library.service;

import co.istad.library.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
    List<Book> findAll();
<<<<<<< HEAD
    List<Book> search(String keyword);
=======
    List<Book> searchById(int id);
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    List<Book> searchByCategory(String category);
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    Book getById(int id);
}
