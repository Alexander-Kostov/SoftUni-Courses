package ObjectsAndClassesExercise;

import java.util.Scanner;

public class P02Articles {
    static class Article {
        String title;
        String content;
        String author;

        public Article (String title, String content, String author){
            this.title = title;
            this.content = content;
            this.author = author;
        }

       String getTitle(){
           return title;
       }
       void setTitle(String title) {
           this.title = title;
       }

       String getContent(){
           return content;
       }
       void setContent(String content){
           this.content = content;
       }

       String getAuthor(){
           return author;
       }
       void setAuthor(String author){
           this.author = author;
       }

      @Override
      public String toString(){
            return String.format("%s - %s: %s",this.title,this.content,this.author);
      }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] data = input.split(", ");
        String title = data[0];
        String content = data[1];
        String author = data[2];

        Article article = new Article(title,content,author);
        
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String [] changes = scanner.nextLine().split(": ");
            String command = changes[0];

            switch (command){
                case "Edit":
                    article.setContent(changes[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(changes[1]);

                    break;
                case "Rename":
                    article.setTitle(changes[1]);

                    break;
            }
        }

        System.out.println(article.toString());

    }
}
