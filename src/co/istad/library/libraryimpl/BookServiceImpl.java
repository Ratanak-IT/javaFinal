package co.istad.library.libraryimpl;

import co.istad.library.database.LibraryDatabase;
import co.istad.library.model.Book;
import co.istad.library.service.BookService;
<<<<<<< HEAD

=======
import co.istad.library.util.DisplayUtil;
import co.istad.library.util.InputUtil;

import java.util.Comparator;
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
<<<<<<< HEAD
=======
    private static final int PAGE_SIZE = 5;
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    private final LibraryDatabase db;

    public BookServiceImpl(LibraryDatabase db) { this.db = db; }

    @Override
    public void addBook(Book book) { db.addBook(book); }

    @Override
    public void updateBook(Book book) {
        List<Book> books = db.getBooks();
<<<<<<< HEAD
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                return;
            }
        }
=======
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
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    }

    @Override
    public void deleteBook(int id) {
        db.getBooks().removeIf(b -> b.getId() == id);
    }

    @Override
    public List<Book> findAll() { return db.getBooks(); }

<<<<<<< HEAD
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

=======
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
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    @Override
    public Book getById(int id) {
        return db.getBooks().stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }
<<<<<<< HEAD
=======

>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
}
