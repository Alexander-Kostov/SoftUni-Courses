package JavaAdvance.SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer > map = new LinkedHashMap();
        Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).forEach(n -> {
                if (map.containsKey(n)){
                    int oldCount = map.get(n);
                    oldCount++;
                    map.put(n,oldCount);
                }else {
                    map.put(n,1);
                }
        });

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.println(String.format("%.1f -> %d", entry.getKey(),entry.getValue()));
        }

    }
}
