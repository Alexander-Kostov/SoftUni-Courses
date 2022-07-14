package ArraysLab;

import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String [] inputAsNumbers = input.split(" ");

        int [] numbers = new int[inputAsNumbers.length];
        int sum = 0;

        for (int i = 0; i < inputAsNumbers.length; i++) {
            numbers [i] = Integer.parseInt(inputAsNumbers[i]);
            if (numbers[i] % 2 == 0) {
                sum += numbers[i];
            }
        }
        System.out.println(sum);
    }
}
