package JavaAdvancedExam25June2022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        List<String> commands = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        int housesNum = 0;
        int numCommands = commands.size();

        int rowDillinger = -1;
        int colDillinger = -1;

        for (int i = 0; i < n; i++) {
            List<String> rawInput = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            StringBuilder input = new StringBuilder();
            for (String s : rawInput) {
                input.append(s);
            }

            for (int j = 0; j < input.length(); j++) {
                String symbol = String.valueOf(input.charAt(j));

                if (symbol.equals("D")) {
                    rowDillinger = i;
                    colDillinger = j;
                }

                if (symbol.equals("$")) {
                    housesNum += 1;
                }

                matrix[i][j] = symbol;
            }
        }

        int i = 0;
        int totalSum = 0;
        boolean caught = false;

        while (numCommands > 0) {
            if (caught) {
                break;
            }
            numCommands--;
            String currentCommand = commands.get(i);
            i++;

            switch (currentCommand) {
                case "up":
                    if (!inMatrix(rowDillinger - 1, colDillinger, matrix)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        int oldRow = rowDillinger;
                        rowDillinger -= 1;
                        if (matrix[rowDillinger][colDillinger].equals("$")) {
                            int robbedSum = colDillinger * rowDillinger;
                            totalSum += robbedSum;
                            matrix[oldRow][colDillinger] = "+";
                            matrix[rowDillinger][colDillinger] = "D";
                            System.out.println("You successfully stole " + robbedSum + "$.");

                        } else if (matrix[rowDillinger][colDillinger].equals("P")) {
                            System.out.println("You got caught with " + totalSum + "$," + " and you are going to jail.");
                            matrix[rowDillinger][colDillinger] = "#";
                            matrix[oldRow][colDillinger] = "+";
                            caught = true;
                            break;
                        } else {
                            matrix[rowDillinger][colDillinger] = "D";
                            matrix[oldRow][colDillinger] = "+";
                        }
                    }

                    break;
                case "down":
                    if (!inMatrix(rowDillinger + 1, colDillinger, matrix)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        int oldRow = rowDillinger;
                        rowDillinger += 1;
                        if (matrix[rowDillinger][colDillinger].equals("$")) {
                            int robbedSum = colDillinger * rowDillinger;
                            totalSum += robbedSum;
                            matrix[oldRow][colDillinger] = "+";
                            matrix[rowDillinger][colDillinger] = "D";
                            System.out.println("You successfully stole " + robbedSum + "$.");

                        } else if (matrix[rowDillinger][colDillinger].equals("P")) {
                            System.out.println("You got caught with " + totalSum + "$," + " and you are going to jail.");
                            matrix[rowDillinger][colDillinger] = "#";
                            matrix[oldRow][colDillinger] = "+";
                            caught = true;
                            break;
                        } else {
                            matrix[rowDillinger][colDillinger] = "D";
                            matrix[oldRow][colDillinger] = "+";
                        }
                    }

                    break;
                case "right":
                    if (!inMatrix(rowDillinger, colDillinger + 1, matrix)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        int oldCol = colDillinger;
                        colDillinger += 1;
                        if (matrix[rowDillinger][colDillinger].equals("$")) {
                            int robbedSum = colDillinger * rowDillinger;
                            totalSum += robbedSum;
                            matrix[rowDillinger][oldCol] = "+";
                            matrix[rowDillinger][colDillinger] = "D";
                            System.out.println("You successfully stole " + robbedSum + "$.");

                        } else if (matrix[rowDillinger][colDillinger].equals("P")) {
                            System.out.println("You got caught with " + totalSum + "$," + " and you are going to jail.");
                            matrix[rowDillinger][colDillinger] = "#";
                            matrix[rowDillinger][oldCol] = "+";
                            caught = true;
                            break;
                        } else {
                            matrix[rowDillinger][colDillinger] = "D";
                            matrix[rowDillinger][oldCol] = "+";
                        }
                    }

                    break;
                case "left":
                    if (!inMatrix(rowDillinger, colDillinger - 1, matrix)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        int oldCol = colDillinger;
                        colDillinger -= 1;
                        if (matrix[rowDillinger][colDillinger].equals("$")) {
                            int robbedSum = colDillinger * rowDillinger;
                            totalSum += robbedSum;
                            matrix[rowDillinger][oldCol] = "+";
                            matrix[rowDillinger][colDillinger] = "D";
                            System.out.println("You successfully stole " + robbedSum + "$.");

                        } else if (matrix[rowDillinger][colDillinger].equals("P")) {
                            System.out.println("You got caught with " + totalSum + "$," + " and you are going to jail.");
                            matrix[rowDillinger][colDillinger] = "#";
                            matrix[rowDillinger][oldCol] = "+";
                            caught = true;
                            break;
                        } else {
                            matrix[rowDillinger][colDillinger] = "D";
                            matrix[rowDillinger][oldCol] = "+";
                        }

                    }
                    break;
            }
        }
        if (!caught) {
            System.out.println("Your last theft has finished successfully with " + totalSum + "$ in your pocket.");
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }

    }

    public static boolean inMatrix(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }


}
