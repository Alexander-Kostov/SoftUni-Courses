package TextProcessingExercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (String s : input) {
            char firstLetter = s.charAt(0);
            char lastLetter = s.charAt(s.length() - 1);
            double number = Double.parseDouble(s.substring(1, s.length() - 1));

            if (Character.isUpperCase(firstLetter)) {
                sum += number / (Character.toLowerCase(firstLetter) - 96);
            } else {
                sum += number * (Character.toLowerCase(firstLetter) - 96);
            }

            if (Character.isUpperCase(lastLetter)){
                sum -= Character.toLowerCase(lastLetter) - 96;
            }else {
                sum += Character.toLowerCase(lastLetter) - 96;
            }

        }
            System.out.printf("%.2f", sum);
    }
}
