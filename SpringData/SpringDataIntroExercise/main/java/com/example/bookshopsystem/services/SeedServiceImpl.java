package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.*;
import com.example.bookshopsystem.repositories.AuthorRepository;
import com.example.bookshopsystem.repositories.BookRepository;
import com.example.bookshopsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService{
    private static final String RESOURCE_PATH = "src\\main\\resources\\files";
    private static final String AUTHORS_FILE_PATH = RESOURCE_PATH + "\\authors.txt";
    private static final String CATEGORIES_FILE_PATH = RESOURCE_PATH + "\\categories.txt";
    private static final String BOOKS_FILE_PATH = RESOURCE_PATH + "\\books.txt";

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public void seedAuthors() throws IOException {

        Files.readAllLines(Path.of(AUTHORS_FILE_PATH)).stream()
                .filter(a -> !a.isBlank()).
                map(a -> a.split("\\s+"))
                .map(names -> new Author(names[0], names[1]))
                .forEach(authorRepository::save);
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH)).stream().
                filter(c -> !c.isBlank()).map(Category::new).
                forEach(categoryRepository::save);
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(BOOKS_FILE_PATH)).stream().
                filter(c -> !c.isBlank()).map(this::getBookObject).
                forEach(bookRepository::save);
    }

    private Book getBookObject(String line) {
        String[] bookInfo = line.split("\\s+");

        int editionTypeIndex = Integer.parseInt(bookInfo[0]);
        EditionType editionType = EditionType.values()[editionTypeIndex];

        LocalDate publicationDate = LocalDate.parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

        int copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);

        int ageRestrictionIndex = Integer.parseInt(bookInfo[4]);
        AgeRestriction ageRestriction = AgeRestriction.values()[ageRestrictionIndex];

        String title = Arrays.stream(bookInfo).skip(5).collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();
        return new Book(title, editionType, price, copies, publicationDate, author, categories, ageRestriction);
    }
}
