package com.library.managementapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data 
@NoArgsConstructor // Creates a constructor with no arguments
@AllArgsConstructor // Creates a constructor with all arguments


@Entity
@Table(name = "borrowers") // Defines the table name in the database
public class Borrower {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private Long id;

    @Column(nullable = false) // Ensures the name field cannot be null
    private String name;

    @Column(nullable = false, unique = true) // Ensures email is required and UNIQUE
    private String email;

}