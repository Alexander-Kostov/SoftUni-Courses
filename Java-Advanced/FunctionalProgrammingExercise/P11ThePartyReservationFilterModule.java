package JavaAdvance.FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> filters = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("Print")) {
            String filter = input.substring(input.indexOf(";") + 1);
            char elementToAddOrRemove = input.charAt(0);

            if (elementToAddOrRemove == 'A') {
                filters.add(filter);
            } else {
                filters.remove(filter);
            }
            input = scanner.nextLine();
        }

        filters.forEach(f -> {
            String[] data = f.split(";");
            String filterType = data[0];
            String filterParameter = data[1];
            Predicate<String> criteria = getFilterCriteria(filterType, filterParameter);
            guests.removeIf(criteria);
        });

        System.out.println(String.join(" ", guests));

    }

    private static Predicate<String> getFilterCriteria(String filterType, String filterParameter) {
        Map<String, Predicate<String>> filterCriteriaMap = new HashMap<>();
        filterCriteriaMap.put("Starts with", s -> s.startsWith(filterParameter));
        filterCriteriaMap.put("Ends with", s -> s.endsWith(filterParameter));
        filterCriteriaMap.put("Length", s -> s.length() == Integer.parseInt(filterParameter));
        filterCriteriaMap.put("Contains", s -> s.contains(filterParameter));
        return filterCriteriaMap.get(filterType);
    }
}
