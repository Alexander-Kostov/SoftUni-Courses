package JavaAdvance.SetsAndMapsAdvancedLab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String,Map<String, List<String>>> map = new LinkedHashMap<>();

        while (number-- > 0){
            String [] data = scanner.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countryWithCities = map.get(continent);
            countryWithCities.putIfAbsent(country,new ArrayList<>());
            countryWithCities.get(country).add(city);
        }

        map.entrySet().forEach(e-> {
            System.out.println(e.getKey() + ":");
            Map<String, List<String>> countryWithCities = e.getValue();

            countryWithCities.entrySet().forEach(entry -> {
                System.out.println("  " + entry.getKey() + " -> " + String.join(", ", entry.getValue()));
            });
        });
    }
}
