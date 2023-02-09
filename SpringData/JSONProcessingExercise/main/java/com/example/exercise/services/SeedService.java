package com.example.exercise.services;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public interface SeedService {

    void seedUsers() throws IOException;

    void seedProducts() throws IOException;

    void seedCategories() throws IOException;

    default void seedAll() throws IOException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
