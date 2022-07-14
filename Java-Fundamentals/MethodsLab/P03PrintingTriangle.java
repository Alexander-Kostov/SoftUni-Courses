package MethodsLab;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            printIncreasingNumbers(i);
        }

        for (int i = number - 1; i > 0; i--) {
            printIncreasingNumbers(i);
        }



    }

    private static void printIncreasingNumbers(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print(i);
            if (i < number) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}


