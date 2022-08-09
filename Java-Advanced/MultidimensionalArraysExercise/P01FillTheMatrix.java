package JavaAdvance.MultidimensionalArraysExercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[size][size];
        int start = 1;
        if (pattern.equals("A")) {
            fillMatrixA(start, matrix);
        } else if (pattern.equals("B")) {
            fillMatrixB(start, matrix);
        }
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixB(int start, int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][col] = start;
                    start++;
                }
            } else {
                for (int i = matrix.length - 1; i >= 0; i--) {
                    matrix[i][col] = start;
                    start++;
                }
            }
        }
    }

    private static void fillMatrixA(int start, int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = start;
                start++;
            }
        }
    }
}
