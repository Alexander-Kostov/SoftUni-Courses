package ArraysExcercise;

import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String [] firstArray = new String[n];
        String [] secondArray = new String[n];
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if ( i % 2 != 0) {
            firstArray [i - 1] = input [0];
            secondArray[i - 1] = input [1];
            } else {
                firstArray [i - 1] = input [1];
                secondArray[i - 1] = input [0];
            }
        }

        for (String s : firstArray) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : secondArray) {
            System.out.print(s + " ");
        }
    }
}