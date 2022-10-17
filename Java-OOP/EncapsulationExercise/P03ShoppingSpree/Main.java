package EncapsulationExercise.P03ShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] peopleInput = scanner.nextLine().split(";");

        for (String personData : peopleInput) {
            String[] personParts = personData.split("=");
            String name = personParts[0];
            double money = Double.parseDouble(personParts[1]);
            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] productInput = scanner.nextLine().split(";");
        for (String productData : productInput) {
            String[] productParts = productData.split("=");
            String productName = productParts[0];
            double productPrice = Double.parseDouble(productParts[1]);

            try {
                Product product = new Product(productName, productPrice);
                products.put(productName, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] commandParts = command.split("\\s+");
            String personName = commandParts[0];
            String productName = commandParts[1];

            try {
                people.get(personName).buyProduct(products.get(productName));
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }


            command = scanner.nextLine();
        }


         people.values().forEach(System.out::println);

    }
}
