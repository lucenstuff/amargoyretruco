package src.Players;

import src.Cards.Deck;

public class Cpu extends Player {

    public Cpu(String name) {
        super(name);
    }

    @Override
    public void drawCard(Deck deck) {
        // Add AI logic for drawing cards
        // For example, you can choose a random card from the deck
        // and add it to the hand
    }

    @Override
    public int playCard() {
        // Add AI logic for playing a card
        // For example, you can choose a random card from the hand
        // and return its index
        return 0;
    }

    @Override
    public int chooseOption() {
        // Add AI logic for choosing an option
        // For example, you can choose a random option
        // and return its index
        return 0;
    }
}