package co.istad.library.libraryimpl;

import co.istad.library.database.LibraryDatabase;
import co.istad.library.model.Book;
import co.istad.library.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private final LibraryDatabase db;

    public BookServiceImpl(LibraryDatabase db) { this.db = db; }

    @Override
    public void addBook(Book book) { db.addBook(book); }

    @Override
    public void updateBook(Book book) {
        List<Book> books = db.getBooks();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                return;
            }
        }
    }

    @Override
    public void deleteBook(int id) {
        db.getBooks().removeIf(b -> b.getId() == id);
    }

    @Override
    public List<Book> findAll() { return db.getBooks(); }

    @Override
    public List<Book> search(String keyword) {
        String k = keyword == null ? "" : keyword.toLowerCase();
        return db.getBooks().stream()
                .filter(b -> String.valueOf(b.getId()).contains(k)
                        || b.getTitle().toLowerCase().contains(k)
                        || (b.getAuthor() != null && b.getAuthor().toLowerCase().contains(k))
                        || (b.getCategory() != null && b.getCategory().toLowerCase().contains(k)))
                .collect(Collectors.toList());
    }

    @Override
    public Book getById(int id) {
        return db.getBooks().stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }
}
