package JavaAdvance.DefiningClassesExercise.P06PokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] data = input.split(" ");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName);
            trainer.getPokemons().add(pokemon);

            if (trainerMap.containsKey(trainerName)) {
                trainerMap.get(trainerName).getPokemons().add(pokemon);
            } else {
                trainerMap.put(trainerName, trainer);
            }

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if (command.equals("Fire")) {
                tournamentFight(trainerMap, command);
            } else if (command.equals("Electricity")) {
                tournamentFight(trainerMap, command);
            } else if (command.equals("Water")) {
                tournamentFight(trainerMap,command);
            }
            command = scanner.nextLine();
        }

        Map<String, Trainer> sorted = new LinkedHashMap<>();


        trainerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((Comparator.comparingInt(Trainer::getBadges)).reversed()))
                .forEach(e -> sorted.put(e.getKey(), e.getValue()));
        if (!sorted.isEmpty()) {
            sorted.forEach((key, value) -> System.out.println(key + " " + value.getBadges() + " " + value.pokemons.size()));
        }
    }

    private static void tournamentFight(Map<String, Trainer> trainerMap, String command) {
        for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
            if (entry.getValue().hasPokemon(command)) {
                entry.getValue().addBadge();
            } else {
                entry.getValue().getDamage();
            }
        }
    }
}
