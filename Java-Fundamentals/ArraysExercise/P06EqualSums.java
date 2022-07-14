package ArraysExcercise;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] array = input.split(" ");

        int[] arr = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();

//        1 2 3 3
        boolean isFound = false;

        for (int i = 0; i < arr.length; i++) {

            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }

            if (rightSum == leftSum) {
                System.out.println(i);
                isFound = true;
                break;
            }
        }
            if (!isFound) {
                System.out.println("no");
            }
    }
}
