package JavaAdvance.MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = arr[col];
            }
        }

        int biggestSum = Integer.MIN_VALUE;
        int [][] biggestMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {

                int currentSum = matrix[row][col] +
                                 matrix[row][col + 1] +
                                 matrix[row + 1][col] +
                                 matrix[row + 1][col + 1];

                if (currentSum > biggestSum){
                    biggestSum = currentSum;
                    biggestMatrix = new int[][]{
                            {matrix[row][col],matrix[row][col + 1]},
                            {matrix[row + 1][col],matrix[row + 1][col + 1] }
                    };
                }

            }
        }

        for (int row = 0; row < biggestMatrix.length; row++) {
            for (int col = 0; col < biggestMatrix[row].length; col++) {
                System.out.print(biggestMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(biggestSum);
    }
}
