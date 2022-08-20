package JavaAdvance.SetsAndMapsExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character,Integer> characters = new TreeMap<>();


        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (characters.containsKey(symbol)){
                int oldValue = characters.get(symbol);
                oldValue++;
                characters.put(symbol,oldValue);
            }else {
                characters.put(symbol,1);
            }
        }

        for (var entry : characters.entrySet()) {
            System.out.printf("%s: %d time/s\n",entry.getKey(),entry.getValue());
        }
    }
}
