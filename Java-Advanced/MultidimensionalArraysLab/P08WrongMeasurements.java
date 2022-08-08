package JavaAdvance.MultidimensionalArraysLab;

import java.net.Inet4Address;
import java.util.*;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 80/100

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];
        for (int row = 0; row < n; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        String[] data = scanner.nextLine().split(" ");

        int row = Integer.parseInt(data[0]);
        int col = Integer.parseInt(data[1]);

        int wrongValue = matrix[row][col];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int sum = 0;
                if (matrix[r][c] == wrongValue) {
                    queue.add(r);
                    queue.add(c);

                    if (c - 1 >= 0) {
                        if (matrix[r][c - 1] != wrongValue) {
                            sum += matrix[r][c - 1];
                        }
                    }
                    if (c + 1 < matrix[r].length) {
                        if (matrix[r][c + 1] != wrongValue) {
                            sum += matrix[r][c + 1];
                        }
                    }
                    if (r - 1 >= 0) {
                        if (matrix[r - 1][c] != wrongValue) {
                            sum += matrix[r - 1][c];

                        }
                    }
                    if (r + 1 < matrix.length) {
                        if (matrix[r + 1][c] != wrongValue) {
                            sum += matrix[r + 1][c];
                        }
                    }
                    numbers.add(sum);
                }

            }
        }

        while (!queue.isEmpty()){
            int row1 = queue.poll();
            int col1 = queue.poll();

            int currentNumber = numbers.poll();

            matrix[row1][col1] = currentNumber;

        }

        for (int row2 = 0; row2 < matrix.length; row2++) {
            for (int col2 = 0; col2 < matrix[row2].length; col2++) {
                System.out.print(matrix[row2][col2] + " ");
            }
            System.out.println();
        }

    }
}
