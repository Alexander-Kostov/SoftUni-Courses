package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String coinsInserted = scanner.nextLine();

        int count01 = 0;
        int count02 = 0;
        int count05 = 0;
        int count1 = 0;
        int count2 = 0;

        while (!coinsInserted.equals("Start")) {
            if (coinsInserted.equals("0.1") || (coinsInserted.equals("0.10"))) {
                count01++;
            } else if (coinsInserted.equals("0.2") || (coinsInserted.equals("0.20"))) {
                count02++;
            } else if (coinsInserted.equals("0.5") || (coinsInserted.equals("0.50"))) {
                count05++;
            } else if (coinsInserted.equals("1")) {
                count1++;
            } else if (coinsInserted.equals("2")) {
                count2++;
            } else {
                double wrongCoin = Double.parseDouble(coinsInserted);
                System.out.printf("Cannot accept %.2f%n", wrongCoin);
            }

            coinsInserted = scanner.nextLine();
        }

        double coin01 = count01 * 0.1;
        double coin02 = count02 * 0.2;
        double coin05 = count05 * 0.5;
        double coin1 = count1;
        double coin2 = count2 * 2;

        double coinSum = coin01 + coin02 + coin05 + coin1 + coin2;

        String product = scanner.nextLine();
        while (!product.equals("End")) {
            switch (product) {
                case "Nuts":
                    if (coinSum >= 2.0){
                        System.out.println("Purchased Nuts");
                        coinSum -= 2.0;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (coinSum >= 0.7) {
                        System.out.println("Purchased Water");
                        coinSum -= 0.7;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (coinSum >= 1.5){
                        System.out.println("Purchased Crisps");
                        coinSum -= 1.5;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (coinSum >= 0.8){
                        System.out.println("Purchased Soda");
                        coinSum -= 0.8;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (coinSum >= 1.0){
                        System.out.println("Purchased Coke");
                        coinSum -= 1.0;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;

            }

            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", coinSum);

    }
}
