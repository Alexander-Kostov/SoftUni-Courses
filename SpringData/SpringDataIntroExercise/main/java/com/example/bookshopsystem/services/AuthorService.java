package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    Author getRandomAuthor();
}
