package RegularExperssionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SoftuniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*?<(?<product>\\w+)>[^|$%.]*?\\|(?<quantity>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.?\\d+)\\$";
        Pattern pattern = Pattern.compile(regex);

        String line = scanner.nextLine();
        double totalPrice = 0;
        while (!line.equals("end of shift")){
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));

                double currentPrice = quantity * price;
                totalPrice += currentPrice;
                System.out.printf("%s: %s - %.2f\n",name,product,currentPrice);
            }

            line = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalPrice);
    }
}
