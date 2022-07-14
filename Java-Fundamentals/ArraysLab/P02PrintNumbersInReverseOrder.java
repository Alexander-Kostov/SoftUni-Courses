package ArraysLab;

import java.util.Scanner;

public class P02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int [] reversedNumbers = new int[number];

        for (int i = 0; i < number; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            reversedNumbers [i] = currentNumber;
        }

        for (int i = reversedNumbers.length - 1; i >= 0 ; i--) {
            System.out.print(reversedNumbers[i] + " ");
        }
    }
}
