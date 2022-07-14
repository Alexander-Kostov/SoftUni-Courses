package ArraysExcercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] array = input.split(" ");

        int[] arrayAsNumbers = new int[array.length];

        for (int i = 0; i < arrayAsNumbers.length; i++) {
            arrayAsNumbers[i] = Integer.parseInt(array[i]);
        }

        for (int i = 0; i < arrayAsNumbers.length; i++) {
            for (int j = i +1; j < arrayAsNumbers.length; j++) {
                if (arrayAsNumbers[i] <= arrayAsNumbers[j]) {
                    break;
                } else if (j == arrayAsNumbers.length - 1) {
                    System.out.print(arrayAsNumbers[i] + " ");
                }
            }
        }
            System.out.print(arrayAsNumbers[arrayAsNumbers.length - 1]);
    }
}

