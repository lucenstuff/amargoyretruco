package src.Cards;

public class CoinsCard extends Card {


    public CoinsCard(Rank rank, Suit suit) {
        super(rank, suit);
    }

    @Override
    public int trucoValue() {
        switch (this.rank) {
            case SEVEN:
                return 11;
        }
        return super.trucoValue();
    }

}
