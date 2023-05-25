package com.example.exercise.Repository;

import com.example.exercise.Model.Librarian;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    @Query("select l from Librarian l where l.id = ?1")
    Librarian getLibrarianById(Integer id);

    @Query("select l from Librarian l where l.username = ?1 and l.password = ?2")
    Librarian login(String username, String password);

    @Query("select l from Librarian l where l.email = ?1")
    Librarian getLibrarianByEmail(String email);
}
