package JavaAdvance.SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,String> emailBook = new LinkedHashMap<>();

        while (!input.equals("stop")){
            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")){
                emailBook.put(input,email);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> e : emailBook.entrySet()) {
            System.out.printf("%s -> %s%n",e.getKey(),e.getValue());
        }
    }
}
