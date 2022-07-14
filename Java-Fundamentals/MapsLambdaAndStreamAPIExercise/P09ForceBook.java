package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> forceUsers = new LinkedHashMap<>();
        while (!input.equals("Lumpawaroo")) {

            if (input.contains("|")){
                String[] data = input.split("\\s+\\|\\s+");
                String side = data[0];
                String user = data[1];

                forceUsers.putIfAbsent(side,new ArrayList<>());

                boolean noMatch = forceUsers.entrySet().stream().noneMatch(entry -> entry.getValue().contains(user));

                if (noMatch) {
                    forceUsers.get(side).add(user);
                }

            }else if (input.contains("->")){
               String [] data = input.split("\\s+->\\s+");
                String username = data[0];
                String side = data[1];

                forceUsers.forEach((k, v) -> v.remove(username));
                forceUsers.putIfAbsent(side, new ArrayList<>());
                forceUsers.get(side).add(username);
                System.out.printf("%s joins the %s side!%n", username, side);
            }


            input = scanner.nextLine();
        }
        forceUsers.forEach((k, v) -> {
            if (v.size() != 0) {
                System.out.printf("Side: %s, Members: %d%n", k, v.size());
                v.forEach(user -> System.out.printf("! %s%n", user));
            }
        });



    }
}
