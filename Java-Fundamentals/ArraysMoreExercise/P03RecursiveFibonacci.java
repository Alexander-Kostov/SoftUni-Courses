package ArraysMoreExercise;

import java.util.Scanner;

public class P03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int position = Integer.parseInt(scanner.nextLine());
        int[] fibonacciSequence = new int[50];

        fibonacciSequence[0] = 1;
        fibonacciSequence[1] = 1;


        if (position > 2) {
            for (int i = 2; i < position; i++) {
                fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];

            }
        }
        System.out.println(fibonacciSequence[position - 1]);
    }
}
