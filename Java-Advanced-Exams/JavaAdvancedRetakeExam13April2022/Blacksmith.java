package JavaAdvancedRetakeExam13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(firstLine.split(" ")).map(Integer::parseInt).forEach(e -> steelQueue.offer(e));
        Arrays.stream(secondLine.split(" ")).map(Integer::parseInt).forEach(e -> carbonStack.push(e));
        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();

            if (steel + carbon == 70) {
                swords.put("Gladius", swords.get("Gladius") + 1);
            } else if (steel + carbon == 80) {
                swords.put("Shamshir", swords.get("Shamshir") + 1);
            } else if (steel + carbon == 90) {
                swords.put("Katana", swords.get("Katana") + 1);
            } else if (steel + carbon == 110) {
                swords.put("Sabre", swords.get("Sabre") + 1);
            }else {
                carbonStack.push(carbon + 5);
            }
        }

        int sum = swords.values().stream().mapToInt(Integer::intValue).sum();
        if (sum != 0){
            System.out.printf("You have forged %d swords.%n", sum);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        }else {
            System.out.println("Steel left: " + steelQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        }else {
            System.out.println("Carbon left: " + carbonStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        swords.entrySet().stream().filter(s -> s.getValue() != 0).forEach(s -> System.out.println(s.getKey() + ": " + s.getValue()));

    }
}
