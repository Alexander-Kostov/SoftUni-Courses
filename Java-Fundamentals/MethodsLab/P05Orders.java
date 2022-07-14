package MethodsLab;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0;

        printingPrice(product, quantity, price);
    }

    private static void printingPrice(String product, int quantity, double price) {
        if (product.equals("coffee")){
            price = quantity * 1.50;
        } else if (product.equals("water")) {
            price = quantity * 1.00;
        }else if (product.equals("coke")) {
            price = quantity * 1.40;
        } else if (product.equals("snacks")){
            price = quantity * 2.00;
        }

        System.out.printf("%.2f", price);
    }
}
