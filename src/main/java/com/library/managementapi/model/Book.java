package com.library.managementapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity 
@Table(name = "books")
public class Book {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Unique ID for EACH copy
    private Long id;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title; 

    @Column(nullable = false)
    private String author;


}