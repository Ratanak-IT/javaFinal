package co.istad.library.service;

import co.istad.library.database.LibraryDatabase;
import co.istad.library.model.User;

public class UserService {
    private final LibraryDatabase db;

    public UserService(LibraryDatabase db) { this.db = db; }

    public User login(String username, String password) {
        return db.getUsers().stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}
