package WorkingWithAbstractionExercise.P03CardsWithPower;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int calculate (){
        return cardRank.getRankPower() + cardSuit.getSuitPower();
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }
}
