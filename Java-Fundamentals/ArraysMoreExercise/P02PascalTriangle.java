package ArraysMoreExercise;

import java.util.Scanner;

public class P02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int no = Integer.parseInt(scanner.nextLine());

        int number = 1;

        for (int i = 0; i < no; i++) {
            number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
