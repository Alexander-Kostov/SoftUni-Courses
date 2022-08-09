package JavaAdvance.MultidimensionalArraysExercise;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] data = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        String [][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char start = (char) ('a' + row);
                char middle = (char) (start + col);
                matrix[row][col] = "" + start + middle + start;
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
