package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P07VendingMachineAnotherWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double allMoney = 0.0;
        double productPrice = 0.0;

        while (!input.equals("Start")) {
            double insertedMoney = Double.parseDouble(input);

            if (insertedMoney == 0.1 || insertedMoney == 0.2 || insertedMoney == 0.5 || insertedMoney == 1 || insertedMoney == 2) {
                allMoney += insertedMoney;
            } else {
                System.out.printf("Cannot accept %.2f%n", insertedMoney);
            }
            input = scanner.nextLine();
        }
        String secondInput = scanner.nextLine();

        while (!secondInput.equals("End")) {
            String product = secondInput;
            switch (product) {
                case "Nuts":
                    productPrice = 2.0;
                    break;
                case "Water":
                    productPrice = 0.7;
                    break;
                case "Crisps":
                    productPrice = 1.5;
                    break;
                case "Soda":
                    productPrice = 0.8;
                    break;
                case "Coke":
                    productPrice = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    secondInput = scanner.nextLine();
                    continue;
            }
            if (allMoney < productPrice) {
                System.out.println("Sorry, not enough money");
                secondInput = scanner.nextLine();
                continue;
            } else {
                System.out.printf("Purchased %s%n", product);
            }
            allMoney -= productPrice;
            secondInput = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", allMoney);
    }
}
