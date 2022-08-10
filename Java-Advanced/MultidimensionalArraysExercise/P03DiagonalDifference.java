package JavaAdvance.MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int primarySum = 0;
        int secondarySum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    primarySum += matrix[row][col];
                }
            }
        }

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = 0; col < matrix[row].length; col++) {
                secondarySum += matrix[row][col];
                row--;
                if (row < 0){
                    break;
                }
            }
        }
        System.out.println(Math.abs(primarySum - secondarySum));
    }
}
