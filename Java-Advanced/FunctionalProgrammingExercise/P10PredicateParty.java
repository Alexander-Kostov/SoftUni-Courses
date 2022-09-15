package JavaAdvance.FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> people = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String commands = scanner.nextLine();

        while (!commands.equals("Party!")) {
            String[] commandParts = commands.split(" ");
            String command = commandParts[0];
            Predicate<String> predicate = getPredicate(commandParts);

            switch (command) {
                case "Double":
                    List<String> newList = new ArrayList<>();
                    people.stream().filter(predicate).forEach(newList::add);
                    people.addAll(newList);

                    break;
                case "Remove":
                    people.removeIf(predicate);
                    break;
            }

            commands = scanner.nextLine();
        }

        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            Collections.sort(people);
            System.out.println(String.join(", ",people) + " are going to the party!");
        }
    }

    public static Predicate<String> getPredicate(String[] commandParts) {
        Predicate<String> predicate = null;

        String filterName = commandParts[1];
        String filterCriteria = commandParts[2];

        switch (filterName) {
            case "StartsWith":
                predicate = name -> name.startsWith(filterCriteria);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(filterCriteria);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(filterCriteria);
                break;
        }
        return predicate;
    }
}
