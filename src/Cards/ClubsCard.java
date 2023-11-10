package src.Cards;

public class ClubsCard extends Card {


    public ClubsCard(Rank rank, Suit suit) {
        super(rank, suit);
    }

    @Override
    public int trucoValue() {
        switch (this.rank) {
            case UNO:
                return 13;
        }
        return super.trucoValue();
    }


}
