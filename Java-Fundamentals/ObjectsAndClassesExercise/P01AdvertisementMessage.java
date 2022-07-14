package ObjectsAndClassesExercise;

import java.util.Random;
import java.util.Scanner;

public class P01AdvertisementMessage {
    static class Messages {
        String [] phrases = {"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String [] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String [] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String [] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random random = new Random();

        void printMessage(int number){
            for (int i = 0; i < number; i++) {
            System.out.printf("%s %s %s - %s\n", this.phrases[random.nextInt(this.phrases.length)],this.events[random.nextInt(this.events.length)],
                    this.authors[random.nextInt(this.authors.length)],this.cities[random.nextInt(this.cities.length)]);
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Messages message = new Messages();
        message.printMessage(number);


    }
}
