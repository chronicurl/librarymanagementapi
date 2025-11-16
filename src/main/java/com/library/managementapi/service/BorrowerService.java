package com.library.managementapi.service;

import com.library.managementapi.model.Borrower;
import com.library.managementapi.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service 
public class BorrowerService {

    private final BorrowerRepository borrowerRepository;

    @Autowired 
    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    /**
     * Register a new borrower to the library
     */
    public Borrower registerNewBorrower(Borrower borrower) {
        
        if (borrowerRepository.existsByEmail(borrower.getEmail())) {
            
            throw new DuplicateResourceException("Borrower with email " + borrower.getEmail() + " already exists.");
        }
        
        return borrowerRepository.save(borrower);
    }

    /**
     * Getting a borrower based on ID. Used by LoanService.
     */
    public Borrower findBorrowerById(Long borrowerId) {
        
        return borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with ID: " + borrowerId));
    }
}