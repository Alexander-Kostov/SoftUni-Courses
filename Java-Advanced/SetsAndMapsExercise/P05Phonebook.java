package JavaAdvance.SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];

            if (phonebook.containsKey(name)) {
                phonebook.put(name, number);
            } else {
                phonebook.put(name, number);
            }


            input = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("stop")) {
            if (phonebook.containsKey(command)) {
                System.out.println(command + " -> " + phonebook.get(command));
            } else {
                System.out.println("Contact " + command + " does not exist.");
                ;
            }

            command = scanner.nextLine();
        }
    }
}
