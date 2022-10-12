package JavaAdvancedExam25June2022;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> milkList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
        List<Double> cacaoList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());


        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();

        for (Double aDouble : milkList) {
            milkQueue.offer(aDouble);
        }

        for (Double aDouble : cacaoList) {
            cacaoStack.push(aDouble);
        }

        Map<String, Integer> table = new TreeMap<>();
        table.put("Milk Chocolate", 0);
        table.put("Dark Chocolate", 0);
        table.put("Baking Chocolate", 0);

        boolean bakingReady = false;
        boolean darkReady = false;
        boolean milkReady = false;

        boolean taskDone = false;
        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()){
            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();

            double resultPercentage = cacao / (milk + cacao);


            if (bakingReady && darkReady && milkReady){
                taskDone = true;
            }

            if (resultPercentage == 1){
                table.put("Baking Chocolate", table.get("Baking Chocolate") + 1);
                bakingReady = true;
            }else if (resultPercentage == 0.5){
                table.put("Dark Chocolate",table.get("Dark Chocolate") + 1);
                darkReady = true;
            }else  if (resultPercentage == 0.3){
                table.put("Milk Chocolate", table.get("Milk Chocolate") + 1);
                milkReady = true;
            }else {
                milk += 10;
                milkQueue.addLast(milk);
            }
        }

        if (taskDone) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            table.entrySet().stream().filter(entry -> entry.getValue() >= 1).forEach(e -> {
                System.out.printf("# %s --> %d",e.getKey(),e.getValue());
                System.out.println();
            });
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            table.entrySet().stream().filter(entry -> entry.getValue() >= 1).forEach(e -> {
                System.out.printf("# %s --> %d",e.getKey(),e.getValue());
                System.out.println();
            });
        }
    }
}
