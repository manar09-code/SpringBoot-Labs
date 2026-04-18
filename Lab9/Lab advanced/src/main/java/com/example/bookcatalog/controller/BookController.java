package com.example.bookcatalog.controller;

import com.example.bookcatalog.model.Book;
import com.example.bookcatalog.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

private final BookRepository repo;

public BookController(BookRepository repo){
this.repo=repo;
}

@GetMapping
public List<Book> all(){ return repo.findAll(); }

@PostMapping
public Book create(@RequestBody Book b){ return repo.save(b); }
}
