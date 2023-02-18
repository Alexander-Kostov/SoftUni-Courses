package com.example.demo.model.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    @DateTimeFormat(pattern = "dd.MMMM.yyyy HH:mm")
    private LocalDateTime neededBefore;

    @ManyToOne
    private Category category;


}
