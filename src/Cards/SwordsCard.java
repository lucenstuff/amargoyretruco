package src.Cards;
public class SwordsCard extends Card {
    public SwordsCard(Rank rank, Suit suit) {
        super(rank, suit);
    }

    @Override
    public int trucoValue() {
        switch (this.rank) {
            case ONE:
                return 14;
            case SEVEN:
                return 12;
        }
        return super.trucoValue();
    }

}
