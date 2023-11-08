package src.Cards;

public abstract class Card {

    protected Rank rank;
    protected Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuit() {
        if(suit instanceof Suit){
            return ((Suit) suit).toString();
        }
        return null;
    }


    public enum Rank {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, SOTA, HORSE, KING
    }

    public enum Suit {
        COINS, CLUBS, SWORDS, CUPS
    }

    public int trucoValue() {
        switch (this.rank) {
            case ONE:
                return 8;
            case TWO:
                return 9;
            case THREE:
                return 10;
            case FOUR:
                return 1;
            case FIVE:
                return 2;
            case SIX:
                return 3;
            case SEVEN:
                return 4;
            case SOTA:
                return 5;
            case HORSE:
                return 6;
            case KING:
                return 7;
        }
        return trucoValue();
    }

    public int envidoValue() {
        switch (this.rank) {
            case ONE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case SOTA:
            case HORSE:
            case KING:
                return 0;
        }
        return envidoValue();
    }



    @Override
    public String toString() {
        return "\n" + rank + " of " + suit;
    }

}