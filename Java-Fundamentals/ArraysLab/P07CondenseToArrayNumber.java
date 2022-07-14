package ArraysLab;

import java.util.Scanner;

public class P07CondenseToArrayNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        String[] lineAsNumbers = line.split(" ");

        int [] numbers = new int[lineAsNumbers.length];

        for (int i = 0; i < lineAsNumbers.length; i++) {
            numbers [i] = Integer.parseInt(lineAsNumbers[i]);
        }

        while (numbers.length > 1){
            int[] condensed = new int[numbers.length - 1];
            for (int i = 0; i < numbers.length - 1; i++) {
                condensed [i] = numbers[i] + numbers [i + 1];
            }
            numbers = condensed;
        }
        System.out.println(numbers[0]);
    }
}
