package MethodsExercise;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        while (!text.equals("END")) {

            printingPalindromeSymbol(text);

            text = scanner.nextLine();
        }


    }

    private static void printingPalindromeSymbol(String text) {
        String reversed = "";
        for (int i = text.length(); i > 0; i--) {
            char symbol = text.charAt(i - 1);
            reversed += symbol;

        }
        if (reversed.equals(text)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
