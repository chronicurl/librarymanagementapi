package com.library.managementapi.repository;

import com.library.managementapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Basic CRUD functionality is available.
    // findAll() will get a list of all books in the library.
}