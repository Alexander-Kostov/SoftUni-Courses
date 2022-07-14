package ObjectsAndClassesLab;

import java.util.Random;
import java.util.Scanner;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();

        String [] words = line.split(" ");

        Random random = new Random();

        for (int i = 0; i < words.length; i++) {
            int randomIndex = random.nextInt(words.length);

            String a = words[randomIndex];
            String b = words[i];

            words[randomIndex] = b;
            words[i] = a;

        }
        for (String s : words) {
            System.out.println(s);
        }

    }


}
