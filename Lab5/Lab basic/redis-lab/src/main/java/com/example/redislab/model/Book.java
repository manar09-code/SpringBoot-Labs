package com.example.redislab.model;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private double price;

    // Default constructor (required for JSON deserialization)
    public Book() {}

    public Book(Long id, String title, String author, String isbn, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author +
               "', isbn='" + isbn + "', price=" + price + '}';
    }
}
