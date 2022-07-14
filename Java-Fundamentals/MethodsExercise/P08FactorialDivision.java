package MethodsExercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.02f",firstFactorial(firstNum) / secondFactorial(secondNum));

    }

    private static double secondFactorial(int secondNum) {
        double result = 1;
        for (int i = secondNum; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    private static double firstFactorial(int firstNum) {
        double result = 1;

        for (int i = firstNum; i >= 1; i--) {
            result *= i;
        }

        return result;
    }
}
