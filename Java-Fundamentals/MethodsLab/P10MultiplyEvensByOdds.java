package MethodsLab;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int number = Integer.parseInt(input);

        System.out.println(getMultipleOfEvensAndOdds(number));


    }

    private static int getMultipleOfEvensAndOdds(int number) {
        int evenSum = getSumOfEvenDigits(number);
        int oddSum = getSumOfOddDigits(number);

        return evenSum * oddSum;
    }

    private static int getSumOfEvenDigits(int number) {

        int evenSum = 0;

        while (number != 0){
            int digit = number % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            number /= 10;
        }
        return evenSum;
    }

    private static int getSumOfOddDigits(int number) {
        int oddSum = 0;

       while (number != 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                oddSum += digit;
            }
            number /= 10;
        }
        return oddSum;
    }
}
