package com.library.managementapi.service;

import com.library.managementapi.model.Book;
import com.library.managementapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class BookService {

    private final BookRepository bookRepository;

    // Dependency Injection (DI) for Repository
    @Autowired 
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Register a new book to the library
     */
    public Book registerNewBook(Book book) {

        return bookRepository.save(book);
    }

    /**
     * Get a list of all books in the library
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Getting one book based on ID. Used by LoanService.
     */
    public Book findBookById(Long bookId) {
        
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + bookId));
    }
}