package IteratorsAndComparators;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private int year;
    String title;
    List<String> authors;

    public Book (String title, int year, String... authors){
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book other) {
        int result = this.title.compareTo(other.title);

        if (result == 0){
            result = Integer.compare(this.year,other.year);
        }

        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "year=" + year +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                '}';
    }
}
