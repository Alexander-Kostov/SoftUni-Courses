package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean hasWinner = false;
        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("shards",0);
        items.put("fragments",0);
        items.put("motes",0);

        String winner = "";

        while (!hasWinner){
        String [] data = scanner.nextLine().split(" ");

            for (int i = 0; i < data.length - 1; i+= 2) {
                int quantity = Integer.parseInt(data[i]);
                String material = data[i + 1].toLowerCase();
                items.putIfAbsent(material, 0);
                items.put(material,items.get(material) + quantity);

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")){
                    if (items.get(material) >= 250) {
                        hasWinner = true;
                        winner = material;
                        items.put(material, items.get(material) - 250);
                        break;
                    }
                }
            }



        }

        switch (winner) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }

        items.forEach((k,v) -> System.out.printf("%s: %d%n",k,v));
    }
}
