package MethodsExercise;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            if (sumDivisibleByEight(i) && (hasOneOdd(i))) {
                System.out.println(i);
            }
        }

    }

    public static boolean sumDivisibleByEight(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum % 8 == 0;
    }

    public static boolean hasOneOdd(int num) {
        while (num > 0) {
            if ((num % 10) % 2 != 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}
