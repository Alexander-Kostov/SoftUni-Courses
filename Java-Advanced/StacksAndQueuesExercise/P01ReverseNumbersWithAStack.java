package JavaAdvance.StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        for (int number : numbers) {
            arrayDeque.push(number);
        }
        System.out.println(arrayDeque.toString().replaceAll("[\\[,\\]]",""));
    }
}
