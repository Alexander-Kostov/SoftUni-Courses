package JavaAdvance.StacksAndQueuesExercise;

import java.util.Scanner;

public class FibonacciArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long [] fibonacci = new long[n + 2];
        fibonacci[1] = 1;
        for (int i = 2; i <= n + 1; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        System.out.println(fibonacci[fibonacci.length - 1]);

    }
}
