package JavaAdvance.MultidimensionalArraysLab;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 8;

        char[][] matrix = new char[n][];

        for (int i = 0; i < 8; i++) {
            matrix[i] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    // right
                    boolean right = right(matrix, row, col);
                    boolean left = left(matrix,row,col);
                    boolean up = up(matrix,row,col);
                    boolean down = down(matrix,row,col);
                    boolean leftDownDiagonal = leftDownDiagonal(matrix,row,col);
                    boolean rightDownDiagonal = rightDownDiagonal(matrix,row,col);
                    boolean upLeftDiagonal = upLeftDiagonal(matrix,row,col);
                    boolean upRightDiagonal = upRightDiagonal(matrix,row,col);

                    if (right && left && up && down && leftDownDiagonal && rightDownDiagonal && upLeftDiagonal && upRightDiagonal){
                        System.out.println(row + " " + col);
                    }

                }
            }
        }
    }
    public static boolean upRightDiagonal(char [][] matrix, int row, int col){
        boolean isUp = false;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length){
            row--;
            col++;
            if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length && matrix[row][col] == 'q'){
                return false;
            }
        }
        return true;
    }
    public static boolean upLeftDiagonal(char[][] matrix, int row, int col){
        boolean isUp = false;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length){
            row--;
            col--;
            if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length && matrix[row][col] == 'q'){
                return false;
            }
        }
        return true;
    }
    public static boolean rightDownDiagonal(char[][] matrix, int row, int col){
        boolean isD = false;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length){
            row++;
            col++;
            if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length && matrix[row][col] == 'q'){
                return false;
            }
        }
        return true;
    }
    public static boolean leftDownDiagonal (char[][] matrix, int row, int col){
        boolean isD = false;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length){
            row++;
            col--;
            if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length && matrix[row][col] == 'q'){
                return false;
            }
        }
        return true;
    }
    public static boolean down (char[][]matrix, int row, int col){
        boolean isUp = false;

        for (int i = row; i <matrix.length; i++) {
            if (i + 1 < matrix.length){
                if (matrix[i + 1][col] == 'q'){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean up (char[][] matrix, int row, int col){
        boolean isUp = false;

        for (int i = row; i >= 0; i--) {
            if (i - 1 >= 0){
                if (matrix[i -1][col] == 'q'){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean left (char[][] matrix, int row, int col){
        boolean isLeft = false;

        for (int i = col; i >= 0; i--) {
            if (i - 1 >= 0){
                if (matrix[row][i - 1] == 'q'){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean right (char [][] matrix, int row, int col){
        boolean isRight = false;

        for (int i = col; i <matrix[row].length ; i++) {
            if (i + 1 < matrix[row].length){
                if (matrix[row][i + 1] == 'q'){
                    return false;
                }
            }
        }
        return true;
    }
}
