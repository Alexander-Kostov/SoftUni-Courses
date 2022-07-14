package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();

        Map <String,Integer> resourceQuantity = new LinkedHashMap<>();

        while (!resource.equals("stop")){
        int secondInput = Integer.parseInt(scanner.nextLine());

        if (!resourceQuantity.containsKey(resource)){
            resourceQuantity.put(resource,secondInput);
        } else {
            resourceQuantity.put(resource, resourceQuantity.get(resource) + secondInput);
        }

            resource = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourceQuantity.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(),entry.getValue());
        }
    }
}
