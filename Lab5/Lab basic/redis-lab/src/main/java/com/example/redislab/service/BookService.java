package com.example.redislab.service;

import com.example.redislab.model.Book;
import com.example.redislab.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * @Cacheable: On the FIRST call, fetches from DB and stores result in Redis.
     * On SUBSEQUENT calls with the same id, returns the cached value — no DB call.
     */
    @Cacheable(value = "books", key = "#id")
    public Book findById(Long id) {
        System.out.println(">>> Cache MISS for book ID: " + id + " — going to database");
        return bookRepository.findById(id);
    }

    /**
     * @Cacheable on the list — caches the entire book list under key "all"
     */
    @Cacheable(value = "books", key = "'all'")
    public List<Book> findAll() {
        System.out.println(">>> Cache MISS for all books — going to database");
        return bookRepository.findAll();
    }

    /**
     * @CachePut: ALWAYS executes the method AND updates the cache.
     * Use this for update operations so the cache stays fresh.
     */
    @CachePut(value = "books", key = "#book.id")
    public Book updateBook(Book book) {
        System.out.println(">>> Updating book ID: " + book.getId() + " and refreshing cache");
        return bookRepository.save(book);
    }

    /**
     * @CacheEvict: Removes the specific entry from the cache.
     * Next request for this ID will go back to the database.
     */
    @CacheEvict(value = "books", key = "#id")
    public void deleteBook(Long id) {
        System.out.println(">>> Evicting book ID: " + id + " from cache");
        bookRepository.delete(id);
    }

    /**
     * @CacheEvict with allEntries = true: Wipes everything from the "books" cache.
     */
    @CacheEvict(value = "books", allEntries = true)
    public void clearAllCaches() {
        System.out.println(">>> All books evicted from cache");
    }
}
