package DataTypesAndVariablesLab;

import java.util.Scanner;

public class P02PoundToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = Double.parseDouble(scanner.nextLine());

        double poundsToDollars = pounds * 1.36;

        System.out.printf("%.3f", poundsToDollars);
    }
}
