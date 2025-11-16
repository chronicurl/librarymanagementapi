package com.library.managementapi.service;

import com.library.managementapi.model.Book;
import com.library.managementapi.model.Borrower;
import com.library.managementapi.model.Loan;
import com.library.managementapi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookService bookService;
    private final BorrowerService borrowerService;

    // Dependency Injection
    @Autowired
    public LoanService(LoanRepository loanRepository, BookService bookService, BorrowerService borrowerService) {
        this.loanRepository = loanRepository;
        this.bookService = bookService;
        this.borrowerService = borrowerService;
    }

    /**
     * Borrow a book with a particular book id 
     */
    public Loan borrowBook(Long borrowerId, Long bookId) {
        
        Borrower borrower = borrowerService.findBorrowerById(borrowerId);
        Book book = bookService.findBookById(bookId);

        // Check if the book is currently borrowed.
        if (loanRepository.findByBookAndReturnDateIsNull(book).isPresent()) {
            // If the result exists, it means the book is currently borrowed.
            throw new DuplicateResourceException("Book with ID " + bookId + " is currently borrowed and unavailable.");
        }

        // Create a new Loan transaction.
        Loan newLoan = new Loan();
        newLoan.setBorrower(borrower);
        newLoan.setBook(book);
        newLoan.setLoanDate(LocalDate.now());

        return loanRepository.save(newLoan);
    }

    /**
     * Return a borrowed book 
     */
    public Loan returnBook(Long borrowerId, Long bookId) {
        
        borrowerService.findBorrowerById(borrowerId);
        bookService.findBookById(bookId);

        // Find active loans (returnDate IS NULL) for this borrower and book.
        Loan activeLoan = loanRepository.findByBorrowerIdAndBookIdAndReturnDateIsNull(borrowerId, bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book ID " + bookId + " is not currently borrowed by Borrower ID " + borrowerId + "."));

        // Update the Loan transaction.
        activeLoan.setReturnDate(LocalDate.now());

        return loanRepository.save(activeLoan);
    }
}