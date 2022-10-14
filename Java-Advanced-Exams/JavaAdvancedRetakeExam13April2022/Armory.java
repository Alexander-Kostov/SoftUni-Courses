package JavaAdvancedRetakeExam13April2022;

import java.util.Arrays;
import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        int rowOfficer = -1;
        int colOfficer = -1;

        int[][] mirrorCoordinates = new int[2][2];
        int mirrorRow = 0;

        for (int i = 0; i < matrix.length; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = String.valueOf(input.charAt(j));
                if (input.charAt(j) == ('A')) {
                    rowOfficer = i;
                    colOfficer = j;
                }
                if (input.charAt(j) == ('M')) {
                    mirrorCoordinates[mirrorRow][0] = i;
                    mirrorCoordinates[mirrorRow][1] = j;
                    mirrorRow++;
                }
            }
        }

        int gold = 0;
        while (gold < 65){
            String command = scanner.nextLine();
            int oldRow = rowOfficer;
            int oldCol = colOfficer;
            switch (command){
                case "up":
                    rowOfficer--;
                    break;
                case "down":
                    rowOfficer++;
                    break;
                case"right":
                    colOfficer++;
                    break;
                case "left":
                    colOfficer--;
                    break;
            }
            matrix[oldRow][oldCol] = "-";
            if (inMatrix(rowOfficer,colOfficer,n,n)){
                if (matrix[rowOfficer][colOfficer].matches("\\d")){
                    gold += Integer.parseInt(matrix[rowOfficer][colOfficer]);
                }
                if (matrix[rowOfficer][colOfficer].equals("M")){
                    if (rowOfficer == mirrorCoordinates[0][0] && colOfficer == mirrorCoordinates[0][1]){
                        rowOfficer = mirrorCoordinates[1][0];
                        colOfficer = mirrorCoordinates[1][1];
                        matrix[mirrorCoordinates[0][0]][mirrorCoordinates[0][1]] = "-";
                    }else {
                        rowOfficer = mirrorCoordinates[0][0];
                        colOfficer = mirrorCoordinates[0][1];
                        matrix[mirrorCoordinates[1][0]][mirrorCoordinates[1][1]] = "-";
                    }
                }
                matrix[rowOfficer][colOfficer] = "A";

            }else break;
        }
            if (inMatrix(rowOfficer,colOfficer,n,n)){
                System.out.println("Very nice swords, I will come back for more!");
            }else {
                System.out.println("I do not need more swords!");
            }
            System.out.printf("The king paid %d gold coins.%n",gold);

            Arrays.stream(matrix).forEach(row -> {
                Arrays.stream(row).forEach(System.out::print);
                System.out.println();
            });

    }
    public static boolean inMatrix (int row, int col, int matrixRow, int matrixCol){
        return row >= 0 && row < matrixRow && col >= 0 && col < matrixCol;
    }
}
