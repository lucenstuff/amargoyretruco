package src.Players;

import src.Cards.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Player {
    public int lastPlaydTrucoValue = 0;

    public int playerResponse = 0;

    public int getPlayerResponse() {
        return playerResponse;
    }

    private boolean trucoChant = false;

    private boolean reTrucoChant = false;

    private boolean valeCuatroChant = false;

    public boolean isTrucoChant() {
        return trucoChant;
    }

    public boolean isReTrucoChant() {
        return reTrucoChant;
    }

    public void setReTrucoChant(boolean reTrucoChant) {
        this.reTrucoChant = reTrucoChant;
    }

    public boolean isValeCuatroChant() {
        return valeCuatroChant;
    }

    public void setValeCuatroChant(boolean valeCuatroChant) {
        this.valeCuatroChant = valeCuatroChant;
    }

    private boolean isHand = false;

    public boolean getIsHand() {
        return isHand;
    }

    public void setIsHand(boolean isHand) {
        this.isHand = isHand;
    }

    public boolean getTrucoChant() {
        return trucoChant;
    }

    public void setTrucoChant(boolean trucoChant) {
        this.trucoChant = trucoChant;
    }

    public void setPlayerResponse(int playerResponse) {
        this.playerResponse = playerResponse;
    }

    public int getLastPlaydTrucoValue() {
        return lastPlaydTrucoValue;
    }

    public void setLastPlaydTrucoValue(int lastPlaydTrucoValue) {
        this.lastPlaydTrucoValue = lastPlaydTrucoValue;
    }

    private String name;
    private List<Card> hand;
    private int score;
    private int numCards = 3;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumCards() {
        return numCards;
    }

    public List<Card> getHand() {
        return hand;
    }


    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    // Gameplay Methods
    public void drawCard(Deck deck) {
        if (hand.size() >= numCards) {
            System.out.println("Max number of cards drawn");
            return;
        }
        Card card = deck.drawCard();
        if (card != null) {
            hand.add(card);
        } else {
            System.out.println("Deck is empty");
        }
    }

    public void drawCards(Deck deck) {
        for (int i = 0; i < numCards; i++) {
            Card card = deck.drawCard();
            if (card != null) {
                hand.add(card);
            } else {
                System.out.println("Deck is empty");
            }
        }
        deck.removeCard(hand);
    }

    public void updateScore(int points) {
        score += points;
    }

    // Envido Methods
    public int calculateEnvidoPoints() {
        int envidoPoints = 0;
        boolean hasThreeSameSuit = false;

        if (hand.size() >= 3) {
            Card card1 = hand.get(0);
            Card card2 = hand.get(1);
            Card card3 = hand.get(2);

            // Check if all three cards have the same suit
            if (card1.getSuit().equals(card2.getSuit()) && card2.getSuit().equals(card3.getSuit())) {
                hasThreeSameSuit = true;
            }
        }

        if (hasThreeSameSuit) {
            int maxEnvidoValue = hand.get(0).envidoValue();
            int secondMaxEnvidoValue = 0;
            for (int i = 1; i < hand.size(); i++) {
                int currentEnvidoValue = hand.get(i).envidoValue();
                if (currentEnvidoValue > maxEnvidoValue) {
                    secondMaxEnvidoValue = maxEnvidoValue;
                    maxEnvidoValue = currentEnvidoValue;
                } else if (currentEnvidoValue > secondMaxEnvidoValue) {
                    secondMaxEnvidoValue = currentEnvidoValue;
                }
            }
            envidoPoints = 20 + maxEnvidoValue + secondMaxEnvidoValue;
        } else {
            for (int i = 0; i < hand.size(); i++) {
                Card card1 = hand.get(i);
                for (int j = i + 1; j < hand.size(); j++) {
                    Card card2 = hand.get(j);
                    if (card1.getSuit().equals(card2.getSuit())) {
                        envidoPoints += 20 + (card1.envidoValue() + card2.envidoValue());
                    }
                }
            }

            if (envidoPoints == 0) {
                int maxEnvidoValue = 0;
                for (Card card : hand) {
                    int currentEnvidoValue = card.envidoValue();
                    if (currentEnvidoValue > maxEnvidoValue) {
                        maxEnvidoValue = currentEnvidoValue;
                    }
                }
                envidoPoints = maxEnvidoValue;
            }
        }

        System.out.println("Envido Points: " + envidoPoints);
        return envidoPoints;
    }
    // Truco Methods
    public void playTruco() {

    }

    public boolean respondToTruco() {
        boolean playerAcceptsTruco = false;
        Scanner scanner = new Scanner(System.in);
        String playerResponse = scanner.nextLine();
        if (playerResponse.equalsIgnoreCase("S")) {
            playerAcceptsTruco = true;
        } else if (playerResponse.equalsIgnoreCase("N")) {
            playerAcceptsTruco = false;
        }
        return playerAcceptsTruco;
    }

    // Card Playing Methods
    public Card playCard() {
        return null;
    }

    public abstract void playEnvido();

    // General Gameplay Methods
    public void playOptions() {

    }

    public void endTurn() {
        // ... (add logic for ending the turn)
    }
}
