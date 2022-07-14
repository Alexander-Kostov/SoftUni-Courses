package MethodsLab;

import java.util.Scanner;

public class P01SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printNumbers();
    }

    private static void printNumbers() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n > 0) {
            System.out.println("The number " + n + " is positive.");
        } else if (n == 0){
            System.out.println("The number " + n + " is zero.");
        } else {
            System.out.println("The number " + n + " is negative.");
        }
    }
}
