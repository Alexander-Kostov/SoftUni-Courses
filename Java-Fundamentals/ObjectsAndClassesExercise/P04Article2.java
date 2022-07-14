package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Article2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String input = scanner.nextLine();

            String[] data = input.split(", ");
            String title = data[0];
            String content = data[1];
            String author = data[2];

            Article article = new Article(title, content, author);
            articles.add(article);
        }

        String input = scanner.nextLine();


        for (Article article : articles) {
            System.out.println(article.toString());
        }

    }

    static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }


        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }
}

