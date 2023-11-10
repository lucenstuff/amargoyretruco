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
        UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, SOTA, CABALLO, REY
    }

    public enum Suit {
        ORO, BASTO, ESPADAS, COPAS
    }

    public int trucoValue() {
        switch (this.rank) {
            case UNO:
                return 8;
            case DOS:
                return 9;
            case TRES:
                return 10;
            case CUATRO:
                return 1;
            case CINCO:
                return 2;
            case SEIS:
                return 3;
            case SIETE:
                return 4;
            case SOTA:
                return 5;
            case CABALLO:
                return 6;
            case REY:
                return 7;
        }
        return trucoValue();
    }

    public int envidoValue() {
        switch (this.rank) {
            case UNO:
                return 1;
            case DOS:
                return 2;
            case TRES:
                return 3;
            case CUATRO:
                return 4;
            case CINCO:
                return 5;
            case SEIS:
                return 6;
            case SIETE:
                return 7;
            case SOTA:
            case CABALLO:
            case REY:
                return 0;
        }
        return envidoValue();
    }



    @Override
    public String toString() {
        return "\n" + rank + " DE " + suit;
    }

}