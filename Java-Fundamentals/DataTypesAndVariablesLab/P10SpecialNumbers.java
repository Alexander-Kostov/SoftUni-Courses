package DataTypesAndVariablesLab;

import java.util.Scanner;

public class P10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++) {
            int number = i;
            int sum = 0;

            while (number > 0){
                int digit = number % 10;
                sum += digit;
                number /= 10;
            }
            boolean x = sum == 5 || sum == 7 || sum == 11;
            if (x){
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }


    }

}
