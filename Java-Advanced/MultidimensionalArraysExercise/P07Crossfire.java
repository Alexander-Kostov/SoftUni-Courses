package JavaAdvance.MultidimensionalArraysExercise;

import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] data = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        int start = 1;
        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = start;
                start++;
            }
        }

        String commands = scanner.nextLine();

        while (!commands.equals("Nuke it from orbit")){
            String [] coordinates = commands.split("\\s+");
            int row = Integer.parseInt(coordinates[0]);
            int col = Integer.parseInt(coordinates[1]);
            int radius = Integer.parseInt(coordinates[2]);



            commands = scanner.nextLine();
        }
    }
}
