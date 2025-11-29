package co.istad.library.libraryapp;
import co.istad.library.model.*;
import co.istad.library.service.*;
import co.istad.library.util.DisplayUtil;
import co.istad.library.util.ExportUtil;
import co.istad.library.util.ImportUtil;
import co.istad.library.util.InputUtil;

import java.time.LocalDate;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryAppRunner {
    private static final int PAGE_SIZE = 5;

    private final UserService userService;
    private final BookService bookService;
    private final MemberService memberService;
    private final BorrowService borrowService;

    public LibraryAppRunner(UserService userService,
                            BookService bookService,
                            MemberService memberService,
                            BorrowService borrowService) {
        this.userService = userService;
        this.bookService = bookService;
        this.memberService = memberService;
        this.borrowService = borrowService;
        //load data from csv
       loadData();
    }
    private void loadData() {
        // Load books
        List<Book> books = ImportUtil.importBooksFromCSV("books.csv");
        for (Book b : books) {
            bookService.addBook(b);
        }

        // Load members
        List<Member> members = ImportUtil.importMembersFromCSV("members.csv");
        for (Member m : members) {
            memberService.addMember(m);
        }

        // Load borrow records
        List<BorrowRecord> records = ImportUtil.importBorrowRecordsFromCSV("borrow_records.csv", memberService, bookService);
        for (BorrowRecord r : records) {
            borrowService.borrow(r);
        }
    }
    public void run() {
<<<<<<< HEAD
        User currentUser;

=======
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
        while (true) {
            System.out.println(DisplayUtil.LOGINMENU);
            int opt = InputUtil.readInt("Enter option: ");

            switch (opt) {
                case 1 -> {
                    // Login loop
<<<<<<< HEAD
                    while (true) {
                        String username = InputUtil.readString("Username: ");
                        String password = InputUtil.readString("Password: ");
                        currentUser = userService.login(username, password);
                        if (currentUser != null) {
                            System.out.println("Welcome " + currentUser.getUsername() +
                                    (currentUser.isAdmin() ? " (Admin)" : " (User)"));
                            break;
                        }
                        System.out.println("Invalid credentials. Try again.");
                    }

=======
                    while (userService.getCurrentUser() == null) {
                        String username = InputUtil.readString("Username: ");
                        String password = InputUtil.readString("Password: ");
                        userService.login(username, password);
                    }

                    User currentUser = userService.getCurrentUser();
                    System.out.println("Welcome " + currentUser.getUsername() +
                            (currentUser.isAdmin() ? " (Admin)" : " (User)"));

>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
                    // Menu loop
                    int option;
                    do {
                        if (currentUser.isAdmin()) {
                            System.out.println(DisplayUtil.ADMINMENU);
                        } else {
                            System.out.println(DisplayUtil.USERMENU);
                        }

                        option = InputUtil.readInt("Option: ");

                        if (currentUser.isAdmin()) {
                            switch (option) {
                                case 1 -> addBookFlow(currentUser);
                                case 2 -> listBooksFlow();
                                case 3 -> searchBookFlow();
                                case 4 -> updateBookFlow(currentUser);
                                case 5 -> deleteBookFlow(currentUser);
                                case 6 -> borrowBookFlow();
                                case 7 -> returnBookFlow();
                                case 8 -> manageMembersFlow(currentUser);
                                case 9 -> viewBorrowRecordsFlow();
<<<<<<< HEAD
                                case 10-> exportDataMenu();
                                case 11 -> System.out.println("Logging out...");
=======
                                case 10 -> exportDataMenu();
                                case 11 -> {
                                    userService.logout(); // <-- call logout here
                                    break; // exit menu loop
                                }
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
                                case 0 -> {
                                    System.out.println("Exit System successfully");
                                    System.exit(0);
                                }
                                default -> System.out.println("Invalid option.");
                            }
                        } else {
                            switch (option) {
                                case 1 -> listBooksFlow();
                                case 2 -> searchBookFlow();
                                case 3 -> borrowBookFlow();
                                case 4 -> returnBookFlow();
<<<<<<< HEAD
                                case 0 -> System.out.println("Logging out...");
=======
                                case 5 -> exportDataMenu();
                                case 6 -> {
                                    userService.logout(); // logout for normal user
                                    break; // exit menu loop
                                }
                                case 0 -> {
                                    System.out.println("Exit System successfully");
                                    System.exit(0);
                                }
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
                                default -> System.out.println("Invalid option.");
                            }
                        }

<<<<<<< HEAD
                    } while (option != 0);
=======
                    } while (userService.getCurrentUser() != null); // loop until user logs out
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
                }
                case 2 -> {
                    System.out.println("Exiting program.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
<<<<<<< HEAD

=======
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    // ---------- flows ----------

    private void addBookFlow(User user) {
        if (!user.isAdmin()) {
            System.out.println("Permission denied — admin only.");
            return;
        }
<<<<<<< HEAD
        String title = InputUtil.readString("Title: ");
        String author = InputUtil.readString("Author: ");
        String category = InputUtil.readString("Category: ");
=======
        String title;
        while (true) {
            title = InputUtil.readString("Title : ").trim();
            if (title.length() >= 4) {
                break;
            } else {
                System.out.println("Title must be at least 4 letters. Try again.");
            }
        }
        String author;
        while (true) {
            author = InputUtil.readString("Author : ").trim();
            if (author.length() >= 5 && author.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Author must be at least 5 letters and contain letters only. Try again.");
            }
        }
        String category;
        while (true) {
            category = InputUtil.readString("Category : ").trim();
            if (category.length() >= 5 && category.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Category must be at least 5 letters and contain letters only. Try again.");
            }
        }
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
        int qty = InputUtil.readInt("Qty: ");
        Book book = new Book(title, author, category, qty);
        bookService.addBook(book);
        System.out.println("Book added with ID: " + book.getId());
<<<<<<< HEAD
=======

>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    }

    private void listBooksFlow() {
        List<Book> books = bookService.findAll();
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

<<<<<<< HEAD
        books = books.stream().sorted(Comparator.comparingInt(Book::getId)).collect(Collectors.toList());
=======
        books = books.stream().sorted(Comparator.comparingInt(Book::getId).reversed()).collect(Collectors.toList());
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
        int pageIndex = 0;
        while (true) {
            DisplayUtil.printBooksPage(books, pageIndex, PAGE_SIZE);
            System.out.println(DisplayUtil.PAGEMENU);
            int opt = InputUtil.readInt("Choose: ");
            if (opt == 1) {
                if ((pageIndex + 1) * PAGE_SIZE >= books.size()) {
                    System.out.println("No next page.");
                } else pageIndex++;
            } else if (opt == 2) {
                if (pageIndex == 0) {
                    System.out.println("No previous page.");
                } else pageIndex--;
            } else if (opt == 0) {
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private void searchBookFlow() {
<<<<<<< HEAD
        String keyword = InputUtil.readString("Search (id/title/author/category): ");
        List<Book> results = bookService.search(keyword);
        if (results.isEmpty()) {
            System.out.println("No results found for: " + keyword);
            return;
        }
        DisplayUtil.printBooks(results);
=======
        System.out.println(DisplayUtil.SEARCHMENU);
        int choice = InputUtil.readInt("Enter choice : ");

        List<Book> results = new ArrayList<>();

        switch (choice) {
            case 1:
                int id = InputUtil.readInt("Enter ID: ");
                results = bookService.searchById(id);
                break;
            case 2:
                String title = InputUtil.readString("Enter Title: ");
                results = bookService.searchByTitle(title);
                break;
            case 3:
                String author = InputUtil.readString("Enter Author: ");
                results = bookService.searchByAuthor(author);
                break;
            case 4:
                String category = InputUtil.readString("Enter Category: ");
                results = bookService.searchByCategory(category);
                break;
            case 0: {}
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            DisplayUtil.printBooks(results);
        }
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    }

    private void updateBookFlow(User user) {
        if (!user.isAdmin()) {
            System.out.println("Permission denied — admin only.");
            return;
        }
<<<<<<< HEAD
=======

>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
        int id = InputUtil.readInt("Book ID to update: ");
        Book book = bookService.getById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
<<<<<<< HEAD
        System.out.println("Leave blank to keep current value.");
        String newTitle = InputUtil.readString("New title (" + book.getTitle() + "): ");
        String newAuthor = InputUtil.readString("New author (" + book.getAuthor() + "): ");
        String newCategory = InputUtil.readString("New category (" + book.getCategory() + "): ");
        String qtyStr = InputUtil.readString("New qty (" + book.getQty() + "): ");
        String statusStr = InputUtil.readString("Status true/false (" + book.isStatus() + "): ");

        if (!newTitle.isEmpty()) book.setTitle(newTitle);
        if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);
        if (!newCategory.isEmpty()) book.setCategory(newCategory);
        if (!qtyStr.isEmpty()) {
            try {
                book.setQty(Integer.parseInt(qtyStr));
            } catch (NumberFormatException e) {
                System.out.println("Invalid qty input — keeping previous value.");
            }
        }
        if (!statusStr.isEmpty()) book.setStatus(Boolean.parseBoolean(statusStr));
        bookService.updateBook(book);
        System.out.println("Book updated.");
    }

=======

        System.out.println("Leave blank to keep current value.");

        // Title
        while (true) {
            String newTitle = InputUtil.readString("New title (" + book.getTitle() + "): ").trim();
            if (newTitle.isEmpty()) break; // keep old
            if (newTitle.length() >= 4) {
                book.setTitle(newTitle);
                break;
            } else {
                System.out.println("Title must be at least 4 letters.");
            }
        }

        // Author
        while (true) {
            String newAuthor = InputUtil.readString("New author (" + book.getAuthor() + "): ").trim();
            if (newAuthor.isEmpty()) break;
            if (newAuthor.length() >= 5 && newAuthor.matches("[a-zA-Z ]+")) {
                book.setAuthor(newAuthor);
                break;
            } else {
                System.out.println("Author must be at least 5 letters, letters only.");
            }
        }

        // Category
        while (true) {
            String newCategory = InputUtil.readString("New category (" + book.getCategory() + "): ").trim();
            if (newCategory.isEmpty()) break;
            if (newCategory.length() >= 5 && newCategory.matches("[a-zA-Z ]+")) {
                book.setCategory(newCategory);
                break;
            } else {
                System.out.println("Category must be at least 5 letters, letters only.");
            }
        }

        // Quantity
        while (true) {
            String qtyStr = InputUtil.readString("New qty (" + book.getQty() + "): ").trim();
            if (qtyStr.isEmpty()) break;
            try {
                book.setQty(Integer.parseInt(qtyStr));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Qty must be a number.");
            }
        }
        book.setStatus(book.getQty() > 0);
        bookService.updateBook(book);
    }


>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    private void deleteBookFlow(User user) {
        if (!user.isAdmin()) {
            System.out.println("Permission denied — admin only.");
            return;
        }
        int id = InputUtil.readInt("Book ID to delete: ");
        Book b = bookService.getById(id);
        if (b == null) {
            System.out.println("Book not found.");
            return;
        }
        bookService.deleteBook(id);
        System.out.println("Book deleted.");
    }

    private void borrowBookFlow() {
        if (memberService.findAll().isEmpty()) {
            System.out.println("No members. Admin must add members first.");
            return;
        }
        int memberId = InputUtil.readInt("Member ID: ");
        Member member = memberService.getById(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        int bookId = InputUtil.readInt("Book ID: ");
        Book book = bookService.getById(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        int qty = InputUtil.readInt("Qty to borrow: ");
        if (qty <= 0) {
            System.out.println("Qty must be > 0.");
            return;
        }
        if (book.getQty() < qty) {
            System.out.println("Not enough copies. Available: " + book.getQty());
            return;
        }
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(7);
        BorrowRecord rec = new BorrowRecord(member, book, qty, borrowDate, dueDate);
        borrowService.borrow(rec);
        System.out.println("Borrow successful. Borrow ID: " + rec.getId() + " Due date: " + rec.getDueDate());
    }

    private void returnBookFlow() {
        int borrowId = InputUtil.readInt("Borrow ID to return: ");
<<<<<<< HEAD
        borrowService.returnBook(borrowId);
        System.out.println("Return processed (if borrow ID existed).");
=======
        boolean success = borrowService.returnBook(borrowId);
        if (success) {
            System.out.println("Return successfully.");
        } else {
            System.out.println("Borrow ID not found.");
        }
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    }

    private void manageMembersFlow(User user) {
        if (!user.isAdmin()) {
            System.out.println("Permission denied — admin only.");
            return;
        }
        int opt;
        do {
<<<<<<< HEAD
            System.out.println("\n=== Manage Members ===");
            System.out.println("1. Add Member");
            System.out.println("2. Update Member");
            System.out.println("3. Delete Member");
            System.out.println("4. List Members");
            System.out.println("0. Back to Main Menu");
            opt = InputUtil.readInt("Select: ");
            switch (opt) {
                case 1 -> {
                    String name = InputUtil.readString("Member name: ");
                    String email = InputUtil.readString("Member email: ");
=======
            System.out.println(DisplayUtil.ManageMembers);
            opt = InputUtil.readInt("Select: ");
            switch (opt) {
                case 1 -> {
                    String name;
                    while (true) {
                        name = InputUtil.readString("Member name : ").trim();
                        if (name.length() >= 4) {
                            break;
                        } else {
                            System.out.println("Name must be at least 6 letters. Try again.");
                        }
                    }

                    String email;
                    while (true) {
                        email = InputUtil.readString("Member email : ").trim();
                        if (email.equals(email.toLowerCase()) && email.endsWith("@gmail.com")) {
                            break;
                        } else {
                            System.out.println("Email must be all lowercase and end with @gmail.com. Try again.");
                        }
                    }
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
                    Member m = new Member(name, email);
                    memberService.addMember(m);
                    System.out.println("Member added. ID: " + m.getId());
                }
                case 2 -> {
                    int id = InputUtil.readInt("Member ID to update: ");
                    Member mem = memberService.getById(id);
                    if (mem == null) {
<<<<<<< HEAD
                        System.out.println("Member not found.");
                        break;
                    }
                    String newName = InputUtil.readString("New name (" + mem.getName() + "): ");
                    String newEmail = InputUtil.readString("New email (" + mem.getEmail() + "): ");
                    if (!newName.isEmpty()) mem.setName(newName);
                    if (!newEmail.isEmpty()) mem.setEmail(newEmail);
                    memberService.updateMember(mem);
                    System.out.println("Member updated.");
                }
                case 3 -> {
                    int id = InputUtil.readInt("Member ID to delete: ");
                    memberService.deleteMember(id);
                    System.out.println("Member deleted if existed.");
=======
                        System.out.println("❌ Member not found.");
                        break;
                    }

                    // Update Name
                    while (true) {
                        String newName = InputUtil.readString("New name (" + mem.getName() + ") or Enter to skip: ");
                        if (newName.isEmpty()) break; // skip update
                        if (newName.length() >= 4) {
                            mem.setName(newName);
                            break;
                        }
                        System.out.println("⚠ Name must be at least 4 characters. Try again.");
                    }

                    // Update Email
                    while (true) {
                        String newEmail = InputUtil.readString("New email (" + mem.getEmail() + ") or Enter to skip: ");
                        if (newEmail.isEmpty()) break; // skip update
                        if (newEmail.length()>=16&&newEmail.endsWith("@gmail.com") &&newEmail.equals(newEmail.toLowerCase())) {
                            mem.setEmail(newEmail);
                            break;
                        }
                        System.out.println("⚠ Email must be at least 6 characters. Try again.");
                    }

                    memberService.updateMember(mem);
                    System.out.println("✔ Member updated successfully.");
                }

                case 3 -> {
                    int id = InputUtil.readInt("Member ID to delete: ");
                    boolean deleted = memberService.deleteMember(id);

                    if (deleted) {
                        System.out.println("Member deleted successfully.");
                    } else {
                        System.out.println("Member ID not found.");
                    }
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
                }
                case 4 -> DisplayUtil.printMembers(memberService.findAll());
                case 0 -> {}
                default -> System.out.println("Invalid option.");
            }
        } while (opt != 0);
    }

    private void viewBorrowRecordsFlow() {
        DisplayUtil.printBorrowRecords(borrowService.findAll());
        int totalAvailable = bookService.findAll().stream().mapToInt(Book::getQty).sum();
        int totalBorrowed = borrowService.findAll().stream().filter(r -> !r.isReturned())
                .mapToInt(r -> r.getQty()).sum();
        System.out.println("\nAvailability Summary:");
        System.out.println("Total available copies (sum qty of books): " + totalAvailable);
        System.out.println("Total borrowed copies (active borrows): " + totalBorrowed);
    }
    //Export data
    private void exportDataMenu() {
        int opt;
        do {
<<<<<<< HEAD
            System.out.println("\n=== Export Data ===");
            System.out.println("1. Export Books");
            System.out.println("2. Export Members");
            System.out.println("3. Export Borrow Records");
            System.out.println("0. Back to Main Menu");
=======
            System.out.println(DisplayUtil.EXPORTMENU);
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
            opt = InputUtil.readInt("Select: ");

            switch (opt) {
                case 1 -> ExportUtil.exportBooksToCSV(bookService.findAll(), "books.csv");
                case 2 -> ExportUtil.exportMembersToCSV(memberService.findAll(), "members.csv");
                case 3 -> ExportUtil.exportBorrowRecordsToCSV(borrowService.findAll(), "borrow_records.csv");
                case 0 -> {}
                default -> System.out.println("Invalid option.");
            }
        } while (opt != 0);
    }

}
