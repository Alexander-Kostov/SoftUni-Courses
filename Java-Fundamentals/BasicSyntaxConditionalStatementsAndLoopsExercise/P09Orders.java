package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int order = Integer.parseInt(scanner.nextLine());
        double total = 0;
        double priceForTheCurrentCoffee = 0;
        for (int i = 0; i < order; i++) {

            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            priceForTheCurrentCoffee = pricePerCapsule * days * capsulesCount;
            total += priceForTheCurrentCoffee;
            System.out.printf("The price for the coffee is: $%.2f%n", priceForTheCurrentCoffee);
        }
        System.out.printf("Total: $%.2f", total);

    }
}
