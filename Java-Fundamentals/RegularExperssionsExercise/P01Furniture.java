package RegularExperssionsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = ">>(?<product>[A-Z]+[a-z]+|[A-Z]+)<<(?<price>[\\d]+|[\\d]+.\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> products = new ArrayList<>();

        double totalSum = 0;

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String product = matcher.group("product");
                String price = matcher.group("price");
                String quantity = matcher.group("quantity");

                totalSum += Double.parseDouble(price) * Double.parseDouble(quantity);
                products.add(product);
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String product : products) {
            System.out.println(product);
        }
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
