package src.Cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    public List<Card> cards = new ArrayList<>();

    public Deck() {
        cards = new ArrayList<>();

        for (Card.Rank rank : Card.Rank.values()) {
            Card cupsCard = new CupsCard(rank, Card.Suit.CUPS);
            Card swordsCard = new SwordsCard(rank, Card.Suit.SWORDS);
            Card coinsCard = new CoinsCard(rank, Card.Suit.COINS);
            Card clubsCard = new ClubsCard(rank, Card.Suit.CLUBS);

            cards.add(cupsCard);
            cards.add(swordsCard);
            cards.add(coinsCard);
            cards.add(clubsCard);
        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Random random = new Random(seed);
        Collections.shuffle(cards, random);
    }

    public String getCardsToString() {
        StringBuilder sb = new StringBuilder();
        for(Card card: cards){
            sb.append(card.toString());
        }
        return sb.toString();
    }

    public String getAllCardsAsString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }

    public void printShuffledCards() {
        shuffle();
        System.out.println("Shuffled cards:");
        System.out.println(getAllCardsAsString());
    }
    public int getNumberOfCards() {
        return cards.size();
    }
    public void printNumberOfCards() {
        System.out.println("Number of cards: " + getNumberOfCards());
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public void removeCard(List<Card> cardstoRemove){
        cards.remove(cardstoRemove);
    }

    public Card[] getCards() {
        return cards.toArray(new Card[0]);
    }
}
