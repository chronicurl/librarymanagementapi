package com.library.managementapi.repository;

import com.library.managementapi.model.Book;
import com.library.managementapi.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    // Find active loans for a specific book.
    Optional<Loan> findByBookAndReturnDateIsNull(Book book);

    // Find active loans for a specific borrower and book.
    Optional<Loan> findByBorrowerIdAndBookIdAndReturnDateIsNull(Long borrowerId, Long bookId);
}