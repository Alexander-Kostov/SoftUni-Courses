package TextProcessingExercise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");
        for (String s : input) {
           char symbol = s.charAt(0);
           symbol += 3;
            System.out.print(symbol);
        }


//        char[] input = scanner.nextLine().toCharArray();
//        StringBuilder s = new StringBuilder();
//        for (char c : input) {
//            char symbol = (char) (c + 3);
//            s.append(symbol);
//        }
//        System.out.println(s);
    }
}
