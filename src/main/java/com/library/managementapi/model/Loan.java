package com.library.managementapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "loans") 
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ManyToOne Relationship: Many loans can refer to one Borrower.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id", nullable = false)
    private Borrower borrower;

    // One-to-One Relationship: One book (Book ID) can only be borrowed once at any one time. 
	// ManyToOne because a Book can be borrowed multiple times (but at different points in time). 
	// Ensure the referenced book is not currently borrowed (returnDate=NULL).
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private LocalDate loanDate; 

    private LocalDate returnDate;

    
}