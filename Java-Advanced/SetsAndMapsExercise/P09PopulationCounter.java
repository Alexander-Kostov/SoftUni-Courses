package JavaAdvance.SetsAndMapsExercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Long>> countryData = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);
            countryData.putIfAbsent(country, new LinkedHashMap<>());
            countryData.get(country).put(city, population);

            input = scanner.nextLine();
        }

        Map<String, Long> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Long>> entry : countryData.entrySet()) {
            long sum = entry.getValue().values().stream().mapToLong(e -> e).sum();
            sortedMap.put(entry.getKey(), sum);
        }
        sortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(element -> {
            System.out.printf("%s (total population: %s)%n", element.getKey(), element.getValue());


            countryData.get(element.getKey()).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(s -> System.out.printf("=>%s: %d%n",s.getKey(),s.getValue()));

        });
    }
}
