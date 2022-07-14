package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftuniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String, String> database = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String [] data = scanner.nextLine().split(" ");

            String command = data[0];
            String name = data[1];


            switch (command) {
                case "register":
                if (database.containsKey(name)){
                    System.out.printf("ERROR: already registered with plate number %s\n",data[2]);
                } else {
                    database.put(name,data[2]);
                    System.out.printf("%s registered %s successfully\n", name,data[2]);
                }
                    break;
                case "unregister":
                if (database.containsKey(name)){
                    database.remove(name);
                    System.out.printf("%s unregistered successfully\n", name);
                } else {
                    System.out.printf("ERROR: user %s not found\n",name);
                }
                    break;
            }
        }

        database.forEach((k,v) -> System.out.printf("%s => %s\n",k,v));
    }
}
