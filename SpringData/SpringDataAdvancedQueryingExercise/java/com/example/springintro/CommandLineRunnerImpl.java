package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
//        11
//        String title = scanner.nextLine();
//        BookSummary summary = this.bookService.getInformationForTitle(title);
//
//        System.out.println(summary.getTitle() + " " + summary.getEditionType() + " " +
//                summary.getAgeRestriction() + " " + summary.getPrice());

//        10
//        this.authorService.getWithTotalCopies().forEach(a ->
//                System.out.printf("%s %s - %s%n", a.getFirstName(), a.getLastName(), a.getTotalCopies()));
//        09
//        int length = Integer.parseInt(scanner.nextLine());
//        int count = this.bookService.countBooksWithTitleLongerThan(length);
//        System.out.printf("There are %d books with longer title than %d symbols%n", count, length);

//        08
//        String search = scanner.nextLine();
//        this.bookService.findByAuthorLastNameStartingWith(search).forEach(b -> System.out.printf("%s (%s %s)%n",
//                b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));

//        07
//        String search = scanner.nextLine();
//        this.bookService.findAllTitlesContaining(search).forEach(System.out::println);

//        06
//        String endsWith = scanner.nextLine();
//        this.authorService.findByFirstNameEndingWith(endsWith).forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));

//        String ageRestriction = scanner.nextLine();
//        05
//        String date = scanner.nextLine();
//        this.bookService.findBooksReleasedBefore(date).forEach(b ->
//        System.out.printf("%s %s %.2f%n", b.getTitle(), b.getEditionType(), b.getPrice()));

//        04
//        int year = Integer.parseInt(scanner.nextLine());
//        this.bookService.findNotReleasedIn(year).forEach(b -> System.out.println(b.getTitle()));

//        03
//        this.bookService.findAllTitlesWithPriceLessThanOrGreaterThan(5, 40).forEach(b ->
//                System.out.println(b.getTitle() + " " + b.getPrice()));
//        02
//        this.bookService.findAllTitlesByEditionAndCopies(EditionType.GOLD, 5000).forEach(System.out::println);

//        01
//        this.bookService.findAllTitlesByAgeRestriction(ageRestriction).forEach(System.out::println);
//        seedData();

        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //   printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
