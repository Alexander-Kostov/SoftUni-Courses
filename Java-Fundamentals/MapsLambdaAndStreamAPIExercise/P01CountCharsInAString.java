package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");

        Map<Character, Integer> characterCounts = new LinkedHashMap<>();

        for (String s : line) {
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (!characterCounts.containsKey(currentChar)) {
                    characterCounts.put(currentChar, 1);
                } else {
                    characterCounts.put(currentChar,characterCounts.get(currentChar) + 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : characterCounts.entrySet()) {
            System.out.print(entry.getKey() + " -> " + entry.getValue() + "\n");
        }
    }
}
