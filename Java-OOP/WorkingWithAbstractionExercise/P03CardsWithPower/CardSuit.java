package WorkingWithAbstractionExercise.P03CardsWithPower;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    int suitPower;

    CardSuit (int suitPower){
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return suitPower;
    }
}
