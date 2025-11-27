package co.istad.library.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private int qty;
    private boolean status = true; // available flag

    public Book() {}

    public Book(String title, String author, String category, int qty) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.qty = qty;
        this.status = qty > 0;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; this.status = qty > 0; }

    public boolean isStatus() { return qty > 0 && status; }
    public void setStatus(boolean status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("ID:%d | Title:%s | Author:%s | Category:%s | Qty:%d | Available:%s",
                id, title, author, category, qty, isStatus());
    }
}
