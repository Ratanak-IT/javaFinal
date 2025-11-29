package co.istad.library.service;

import co.istad.library.database.LibraryDatabase;
import co.istad.library.model.User;

public class UserService {
    private final LibraryDatabase db;
<<<<<<< HEAD

    public UserService(LibraryDatabase db) { this.db = db; }

    public User login(String username, String password) {
        return db.getUsers().stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst().orElse(null);
=======
    private User currentUser; // store the logged-in user

    public UserService(LibraryDatabase db) {
        this.db = db;
    }

    public User login(String username, String password) {
        currentUser = db.getUsers().stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (currentUser != null) {
            System.out.println("✅ Login successful. Welcome, " + currentUser.getUsername() + "!");
        } else {
            System.out.println("❌ Invalid username or password.");
        }

        return currentUser;
    }

    public void logout() {
        if (currentUser != null) {
            System.out.println("👋 " + currentUser.getUsername() + " logged out successfully.");
            currentUser = null;
        } else {
            System.out.println("⚠️ No user is currently logged in.");
        }
    }

    public User getCurrentUser() {
        return currentUser;
>>>>>>> 22168d168fe6e0bf7d5e7becbb3c4b57f02443a8
    }
}
