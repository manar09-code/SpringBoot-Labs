package com.example.bookcatalog.repository;

import com.example.bookcatalog.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByPublicationDateAfter(LocalDate date);

    List<Book> findByPageCountGreaterThan(Integer pageCount);

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Book> searchBooks(@Param("keyword") String keyword);

    @Query("SELECT b FROM Book b WHERE FUNCTION('YEAR', b.publicationDate) = :year")
    List<Book> findBooksByPublicationYear(@Param("year") int year);

    Page<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
        String title, String author, Pageable pageable);
}
