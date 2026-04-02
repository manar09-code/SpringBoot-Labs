package com.example.redislab.repository;

import com.example.redislab.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    private final Map<Long, Book> bookStore = new HashMap<>();

    @PostConstruct
    public void init() {
        bookStore.put(1L, new Book(1L, "To Kill a Mockingbird",   "Harper Lee",          "978-0061120084", 14.99));
        bookStore.put(2L, new Book(2L, "1984",                    "George Orwell",        "978-0451524935", 12.99));
        bookStore.put(3L, new Book(3L, "The Great Gatsby",        "F. Scott Fitzgerald",  "978-0743273565", 11.99));
        bookStore.put(4L, new Book(4L, "Pride and Prejudice",     "Jane Austen",          "978-0141439518",  9.99));
        bookStore.put(5L, new Book(5L, "The Catcher in the Rye",  "J.D. Salinger",        "978-0316769488", 10.99));
    }

    public Book findById(Long id) {
        // Simulate database latency
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(">>> Fetching book ID: " + id + " from DATABASE (slow)");
        return bookStore.get(id);
    }

    public List<Book> findAll() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(">>> Fetching ALL books from DATABASE (slow)");
        return new ArrayList<>(bookStore.values());
    }

    public Book save(Book book) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        bookStore.put(book.getId(), book);
        System.out.println(">>> Saved book ID: " + book.getId() + " to DATABASE");
        return book;
    }

    public void delete(Long id) {
        bookStore.remove(id);
        System.out.println(">>> Deleted book ID: " + id + " from DATABASE");
    }
}
