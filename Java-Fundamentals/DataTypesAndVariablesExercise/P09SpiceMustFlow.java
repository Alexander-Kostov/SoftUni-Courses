package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int spices = 0;

        if (startingYield >= 100) {

            for (int i = startingYield; i >= 100; i -= 10) {
                days++;

                spices += i - 26;

            }
            spices -= 26;
        }
        System.out.println(days);
        System.out.println(spices);


    }
}
