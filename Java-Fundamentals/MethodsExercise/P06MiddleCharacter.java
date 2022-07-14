package MethodsExercise;

import java.util.Scanner;

public class P06MiddleCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printingMiddleCharacters(input);
    }

    private static void printingMiddleCharacters(String input) {
        if (input.length() % 2 == 0){
            System.out.print(input.charAt(input.length() / 2 - 1));
        }
        System.out.print(input.charAt(input.length() / 2));
    }
}
