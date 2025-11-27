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
        boolean found = false;
        for (int i = 0; i <= books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                found = true;
                System.out.println("Book updated successfully.");
                break;
            }
        }
        if (!found) {
            // ID not found add as new book
            db.getBooks().add(book);
            System.out.println("Book ID not found, added as new book.");
        }
    }

    @Override
    public void deleteBook(int id) {
        db.getBooks().removeIf(b -> b.getId() == id);
    }

    @Override
    public List<Book> findAll() { return db.getBooks(); }

    public List<Book> searchById(int id) {
        return db.getBooks().stream()
                .filter(b -> b.getId() == id)
                .collect(Collectors.toList());
    }

    // Search by title
    public List<Book> searchByTitle(String title) {
        String t = title == null ? "" : title.toLowerCase();
        return db.getBooks().stream()
                .filter(b -> b.getTitle().toLowerCase().contains(t))
                .collect(Collectors.toList());
    }

    // Search by author
    public List<Book> searchByAuthor(String author) {
        String a = author == null ? "" : author.toLowerCase();
        return db.getBooks().stream()
                .filter(b -> b.getAuthor() != null && b.getAuthor().toLowerCase().contains(a))
                .collect(Collectors.toList());
    }

    // Search by category
    public List<Book> searchByCategory(String category) {
        String c = category == null ? "" : category.toLowerCase();
        return db.getBooks().stream()
                .filter(b -> b.getCategory() != null && b.getCategory().toLowerCase().contains(c))
                .collect(Collectors.toList());
    }
    @Override
    public Book getById(int id) {
        return db.getBooks().stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }
}
