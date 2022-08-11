package JavaAdvance.MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotationInput = scanner.nextLine();

        String input = scanner.nextLine();
        int maxLength = Integer.MIN_VALUE;
        List<String> words = new ArrayList<>();

        while (!input.equals("END")){
            int currentLength = input.length();

            if (currentLength > maxLength){
                maxLength = currentLength;
            }
            words.add(input);

            input = scanner.nextLine();
        }

        int rows = words.size();
        int cols = maxLength;
        
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String currentWord = words.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()){
                    char currentSymbol = currentWord.charAt(col);
                    matrix[row][col] = currentSymbol;
                }else {
                    matrix[row][col] = ' ';
                }
            }

        }
        int angle = Integer.parseInt(rotationInput.split("[()]")[1]);
        int degrees = angle % 360;

        printMatrix(matrix,degrees,rows,cols);

    }

    private static void printMatrix(char[][] matrix, int degrees, int rows, int cols) {
        switch (degrees) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0;row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }

                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }

                break;
        }
    }
}
