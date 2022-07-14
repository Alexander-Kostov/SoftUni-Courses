package MapsLambdaAndStreamAPILab;

import java.text.DecimalFormat;
import java.util.*;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<Double,Integer> numberOccurrences = new TreeMap<>();

        for (double num : numbers) {
            if (!numberOccurrences.containsKey(num)){
                numberOccurrences.put(num,1);
            }else {
                int currentCount = numberOccurrences.get(num);
                numberOccurrences.put(num,currentCount + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : numberOccurrences.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
