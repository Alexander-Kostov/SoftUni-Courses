package JavaAdvance.SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).
                collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).
                collect(Collectors.toCollection(LinkedHashSet::new));


        int rounds = 0;

        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()){
            rounds++;
            if (rounds == 50) {
                break;
            }

            Iterator<Integer> firstIterator = firstDeck.iterator();
            int firstCard = firstIterator.next();
            firstIterator.remove();

            Iterator<Integer> secondIterator = secondDeck.iterator();
            int secondCard = secondIterator.next();
            secondIterator.remove();

            if (firstCard > secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            }else if (secondCard > firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }

        }

        if (firstDeck.size() > secondDeck.size()){
            System.out.println("First player win!");
        }else if (secondDeck.size() > firstDeck.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }
    }
}
