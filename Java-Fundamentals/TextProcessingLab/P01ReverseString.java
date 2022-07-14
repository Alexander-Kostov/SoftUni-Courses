package TextProcessingLab;

import java.util.Scanner;

public class P01ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        while (!word.equals("end")){
            String newWord = "";
            for (int i = word.length() - 1; i >= 0 ; i--) {
                newWord += word.charAt(i);
            }
            System.out.println(word + " = " + newWord);

            word = scanner.nextLine();
        }

    }
}
