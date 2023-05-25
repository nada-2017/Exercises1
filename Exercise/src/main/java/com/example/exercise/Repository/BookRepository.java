package com.example.exercise.Repository;

import com.example.exercise.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("select b from Book b where b.id=?1")
    Book getBookByID(Integer id);

    @Query("select b from Book b where b.category = ?1")
    List<Book> getBooksByCategory(String category);

    @Query("select b from Book b where b.numberOfPages > ?1")
    List<Book> getBooksByNumberOfPages(Integer pages);

    @Query("select b from Book b where b.author = ?1")
    List<Book> getBooksByAuthor(String author);

    @Query("select b from Book b where b.title = ?1")
    Book getBookByTitle(String title);
}
