package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemon = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;

        while (pokemon.size() > 0) {
            int removingIndex = Integer.parseInt(scanner.nextLine());
            if (removingIndex < 0) {
                int lastElement = pokemon.get(pokemon.size() - 1);
                int removedValue = pokemon.get(0);
                sum += removedValue;
                pokemon.remove(0);
                pokemon.add(0, lastElement);

                for (int i = 0; i < pokemon.size(); i++) {
                    if (pokemon.get(i) <= removedValue) {
                        pokemon.set(i, pokemon.get(i) + removedValue);
                    } else {
                        pokemon.set(i, pokemon.get(i) - removedValue);
                    }
                }

            } else if (removingIndex >= pokemon.size()) {
                int copyElement = pokemon.get(0);
                int removedValue = pokemon.get(pokemon.size() - 1);
                sum += removedValue;
                pokemon.remove(pokemon.size() - 1);
                pokemon.add(copyElement);

                for (int i = 0; i < pokemon.size(); i++) {
                    if (pokemon.get(i) <= removedValue) {
                        pokemon.set(i, pokemon.get(i) + removedValue);
                    } else {
                        pokemon.set(i, pokemon.get(i) - removedValue);
                    }
                }



            } else {

                int removedValue = pokemon.get(removingIndex);
                sum += pokemon.get(removingIndex);
                pokemon.remove(removingIndex);
                for (int i = 0; i < pokemon.size(); i++) {
                    if (pokemon.get(i) <= removedValue) {
                        pokemon.set(i, pokemon.get(i) + removedValue);
                    } else {
                        pokemon.set(i, pokemon.get(i) - removedValue);
                    }
                }

            }
        }

        System.out.println(sum);
    }
}
