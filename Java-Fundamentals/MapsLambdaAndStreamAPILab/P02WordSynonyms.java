package MapsLambdaAndStreamAPILab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String firstWord = scanner.nextLine();
            String synonym = scanner.nextLine();

            words.putIfAbsent(firstWord, new ArrayList<>());
            words.get(firstWord).add(synonym);

        }

        for (Map.Entry<String, ArrayList<String>> entry : words.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(entry.getValue().get(i));
                if (i != entry.getValue().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
