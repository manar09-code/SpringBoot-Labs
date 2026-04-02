package com.example.redislab.controller;

import com.example.redislab.model.Book;
import com.example.redislab.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * GET /api/books/{id}
     * First call: ~1000ms (fetched from "database")
     * Repeat call: ~1-5ms (served from Redis cache)
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id) {
        long start = System.currentTimeMillis();
        Book book = bookService.findById(id);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("==> Response time: " + elapsed + " ms");

        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Map.of(
            "book", book,
            "responseTimeMs", elapsed,
            "servedFromCache", elapsed < 100
        ));
    }

    /**
     * GET /api/books
     * Returns all books (also cached)
     */
    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        long start = System.currentTimeMillis();
        List<Book> books = bookService.findAll();
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("==> Response time (all books): " + elapsed + " ms");

        return ResponseEntity.ok(Map.of(
            "books", books,
            "count", books.size(),
            "responseTimeMs", elapsed,
            "servedFromCache", elapsed < 100
        ));
    }

    /**
     * PUT /api/books/{id}
     * Updates book and refreshes its cache entry (@CachePut)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    /**
     * DELETE /api/books/{id}
     * Removes book from cache (@CacheEvict)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book " + id + " deleted and evicted from cache");
    }

    /**
     * DELETE /api/books/cache
     * Wipes the entire books cache (@CacheEvict allEntries = true)
     */
    @DeleteMapping("/cache")
    public ResponseEntity<String> clearCache() {
        bookService.clearAllCaches();
        return ResponseEntity.ok("All books cache cleared");
    }
}
