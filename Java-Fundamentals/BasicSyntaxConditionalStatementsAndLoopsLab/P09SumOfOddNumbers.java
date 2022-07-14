package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class P09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int countNum = 0;

        for (int i = 1; i < 100 ; i+= 2) {
            countNum++;
            sum += i;
            System.out.println(i);

            if (countNum == n) {
                System.out.printf("Sum: %d", sum);
                break;
            }
        }

    }
}
