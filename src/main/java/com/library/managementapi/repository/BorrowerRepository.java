package com.library.managementapi.repository;

import com.library.managementapi.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    // Spring Data JPA will automatically provide:
    // save(), findById(), findAll(), deleteById(), dll.
    
    // Add this function for unique email validation in the Service layer.
    boolean existsByEmail(String email);
}