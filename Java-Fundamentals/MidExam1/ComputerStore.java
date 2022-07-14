package MidExam1;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double specialPrice = 0;
        double specialPriceWithoutTax = 0;
        double regularPrice = 0;
        double regularPriceWithoutTax = 0;
        double taxes = 0;
        boolean isSpecial = false;
        boolean isRegular = false;

        double sum = 0;
        while (true) {
            String input = scanner.nextLine();
            if (!input.equals("special")){
                if (!input.equals("regular")){
                    double itemPrice = Double.parseDouble(input);
                    if (itemPrice < 0) {
                        System.out.println("Invalid price!");
                        continue;
                    }
                    sum += itemPrice;
                }
            }

            if (input.equals("special")) {
                specialPriceWithoutTax = sum;
                taxes = sum - sum * 0.80;
                specialPrice = (taxes + specialPriceWithoutTax) * 0.90;
                isSpecial = true;

                break;
            }

            if (input.equals("regular")) {
                regularPriceWithoutTax = sum;
                taxes = sum - sum * 0.80;
                regularPrice = regularPriceWithoutTax + taxes;
                isRegular = true;
                break;
            }

        }
        if (isSpecial && specialPrice > 0) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", specialPriceWithoutTax);
            System.out.printf("Taxes: %.2f$\n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", specialPrice);
        } else if (isRegular && regularPrice > 0) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", regularPriceWithoutTax);
            System.out.printf("Taxes: %.2f$\n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", regularPrice);
        } else {
            System.out.println("Invalid order!");
        }
    }
}
