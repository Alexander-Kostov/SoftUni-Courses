package JavaAdvance.MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P011ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int r = rows - 1;
        int c = cols - 1;

        for (int i = 0; i < rows + cols - 1; i++) {
            printMatrix (r,c,matrix);
            System.out.println();
            c--;
        }

    }

    private static void printMatrix(int r, int c, int[][] matrix) {
        while (r >= 0 && c < matrix[0].length){
            if (validIndex(r, matrix.length) && validIndex(c,matrix[0].length)){
                System.out.print(matrix[r][c] + " ");
            }
            r--;
            c++;
        }
    }
    public static boolean validIndex (int rowOrCol, int length){
        return rowOrCol >= 0 && rowOrCol < length;
    }
}
