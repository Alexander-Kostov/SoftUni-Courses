package TextProcessingExercise;

import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      StringBuilder sb = new StringBuilder(scanner.nextLine());

        for (int i = 0; i < sb.length() - 1; i++) {
            char symbol = sb.charAt(i);
            if (symbol == sb.charAt(i + 1)){
                sb.deleteCharAt(i + 1);
                i--;
            }
        }
        System.out.println(sb);

    }
}
