package JavaAdvance.MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] data = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        int number = Integer.parseInt(scanner.nextLine());

        ArrayList<String> output = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number){
                    output.add(row + " " + col);
                }
            }
        }

        if (output.isEmpty()){
            System.out.println("not found");
        }else {
            for (String s : output) {
                System.out.println(s);
            }
        }


    }
}
