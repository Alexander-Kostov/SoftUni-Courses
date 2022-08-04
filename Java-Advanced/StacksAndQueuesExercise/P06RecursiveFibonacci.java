package JavaAdvance.StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        fibonacci.push(0l);
        fibonacci.push(1l);

        for (int i = 1; i <= num; i++) {
            long num1 = fibonacci.pop();
            long num2 = fibonacci.pop();

            fibonacci.push(num1);
            fibonacci.push(num1 + num2);
        }

        System.out.println(fibonacci.pop());
    }
}
