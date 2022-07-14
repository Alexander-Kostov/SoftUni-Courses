package ArraysLab;

import java.util.Scanner;

public class P05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputAsNumbers = input.split(" ");

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < inputAsNumbers.length; i++) {
            int currentNum = Integer.parseInt(inputAsNumbers[i]);
            if (currentNum % 2 == 0) {
                evenSum += currentNum;
            } else {
                oddSum += currentNum;
            }
        }

        System.out.println(evenSum - oddSum);
    }
}
