package WorkingWithAbstractionExercise.P03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        Card card = new Card(CardRank.valueOf(rank), CardSuit.valueOf(suit));

        System.out.printf("Card name: %s of %s; Card power: %s%n", card.getCardRank(), card.getCardSuit(), card.calculate());
    }
}
