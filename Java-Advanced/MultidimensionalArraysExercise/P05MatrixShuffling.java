package JavaAdvance.MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String [][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        String command = scanner.nextLine();

        while (!command.equals("END")){
            String [] data = command.split("\\s+");
            if (data[0].equals("swap") && data.length == 5){
                
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);

                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);
                if (checkIndex(row1,rows) && checkIndex(col1,cols)
                   && checkIndex(row2,rows) && checkIndex(col2,cols)){
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;

                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                }else {
                    System.out.println("Invalid input!");
                }

            }else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }

    }
    public static boolean checkIndex (int i, int length){
        return i >= 0 && i < length;
    }

}
