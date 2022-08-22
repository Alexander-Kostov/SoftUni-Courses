package JavaAdvance.SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();
        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            String[] ipData = data[0].split("=");
            String ip = ipData[1];
            String message = data[1];
            String user = data[2];

            if (!users.containsKey(user)) {
                users.put(user, new LinkedHashMap());
            }

            if (users.get(user).containsKey(ip)) {
                int value = users.get(user).get(ip);
                value++;
                users.get(user).put(ip, value);
            } else {
                users.get(user).put(ip, 1);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : users.entrySet()) {
            String[] userData = entry.getKey().split("=");
            String username = userData[1];
            System.out.println(username + ":");

            int counter = 0;

            for (Map.Entry<String, Integer> secondEntry : entry.getValue().entrySet()) {
                counter++;
                System.out.printf("%s => %d", secondEntry.getKey(), secondEntry.getValue());
                if (counter == entry.getValue().size()) {
                    System.out.println(".");
                } else {
                    System.out.print(", ");
                }

            }
        }
    }
}
