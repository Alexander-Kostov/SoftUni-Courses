package InterfacesAndAbstractionExercise.P04FoodShortage;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyerMap = new HashMap<>();

        for (int i = 0; i < people; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];

            Buyer buyer = null;

            if (data.length == 3) {
                buyer = new Rebel(name);
            } else {
                buyer = new Citizen(name);
            }
            buyerMap.put(name, buyer);
        }

        String buyer = scanner.nextLine();

        while (!buyer.equals("End")) {
            Buyer currentBuyer = buyerMap.get(buyer);

            if (currentBuyer != null){
                currentBuyer.buyFood();
            }

            buyer = scanner.nextLine();
        }

        int sum = buyerMap.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(sum);

    }
}
