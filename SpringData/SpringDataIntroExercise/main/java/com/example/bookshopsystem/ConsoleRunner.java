package com.example.bookshopsystem;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.repositories.AuthorRepository;
import com.example.bookshopsystem.repositories.BookRepository;
import com.example.bookshopsystem.services.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedAuthors();
//        this.seedService.seedCategories();
//        this.seedService.seedAll();

//        this.p01_books_after_2000();

//        this.p02_AllAuthorsWithBooksBefore1990();

//        this.p03_AllAuthorsOrderedByBookCount();

        this.p04_AllBooksFromGeorgePowell();
    }

    private void p04_AllBooksFromGeorgePowell() {
        Author author = authorRepository.findByFirstNameAndLastName("George", "Powell");

        List<Book> books = bookRepository.findByAuthorOrderByReleaseDateDescTitleAsc(author);

        books.forEach(b -> System.out.printf("Title: %s, release date: %s, copies %d%n", b.getTitle(), b.getReleaseDate(), b.getCopies()));
        System.out.printf("Book count: %d%n", books.size());
    }
    private void p03_AllAuthorsOrderedByBookCount() {
        List<Author> authors = this.authorRepository.findAll();

        authors.stream().
                sorted((l,r) -> r.getBooks().size() - l.getBooks().size()).
                forEach(author -> System.out.printf("%s %s -> %d%n", author.getFirstName(), author.getLastName(), author.getBooks().size()));

    }

    private void p02_AllAuthorsWithBooksBefore1990() {
        LocalDate year1990 = LocalDate.of(1990, 1, 1);

        List<Author> authors = this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990);

        authors.forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    private void p01_books_after_2000() {

        LocalDate yearAfter = LocalDate.of(2000, 1, 1);

        List<Book> bookList = this.bookRepository.findByReleaseDateAfter(yearAfter);

        bookList.forEach(book -> System.out.println(book.getReleaseDate() + " " + book.getTitle()));
    }
}
