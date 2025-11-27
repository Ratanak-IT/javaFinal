package co.istad.library.libraryapp;


import co.istad.library.database.LibraryDatabase;
import co.istad.library.libraryimpl.BookServiceImpl;
import co.istad.library.libraryimpl.BorrowServiceImpl;
import co.istad.library.libraryimpl.MemberServiceImpl;
import co.istad.library.service.BookService;
import co.istad.library.service.BorrowService;
import co.istad.library.service.MemberService;
import co.istad.library.service.UserService;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryDatabase db=new LibraryDatabase();
        UserService userService=new UserService(db);
        BookService bookService = new BookServiceImpl(db);
        MemberService memberService = new MemberServiceImpl(db);
        BorrowService borrowService = new BorrowServiceImpl(db);
        LibraryAppRunner runner=new LibraryAppRunner(userService, bookService, memberService, borrowService);
        runner.run();
    }

}
