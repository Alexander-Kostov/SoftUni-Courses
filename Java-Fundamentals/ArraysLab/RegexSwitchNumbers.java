package ArraysLab;

import java.util.Scanner;

public class RegexSwitchNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String [] numbersAsString = input.split("\\s+");

        int [] numbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            numbers [i] = Integer.parseInt(numbersAsString[i]);
        }

        for (int i = 0; i < numbers.length / 2; i++) {
            int otherIndex = numbers.length - 1 - i;
            int currentNumber = numbers [i];
            numbers [i] = numbers[otherIndex];
            numbers [otherIndex] = currentNumber;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }
    }
}
