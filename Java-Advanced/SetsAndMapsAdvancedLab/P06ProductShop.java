package JavaAdvance.SetsAndMapsAdvancedLab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String,Double>> shops = new TreeMap<>();


        String input = scanner.nextLine();

        while (!input.equals("Revision")){
            String[] data = input.split(", ");
            String store = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            shops.putIfAbsent(store,new LinkedHashMap<>());
            shops.get(store).put(product,price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> stringMapEntry : shops.entrySet()) {
            System.out.println(stringMapEntry.getKey() + "->");
            for (Map.Entry<String, Double> stringDoubleEntry : stringMapEntry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f\n",stringDoubleEntry.getKey(),stringDoubleEntry.getValue());
            }
        }
    }
}
