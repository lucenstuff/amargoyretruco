package src.Players;

import src.Cards.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Player {
    private String name;
    private List<Card> hand;
    private int score;
    private int numCards = 3;
    public boolean isHand;

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

    public void setHand(boolean hand) {
        isHand = hand;
    }

    public List<Card> getHand() {
        return hand;
    }

    public boolean isHand() {
        return isHand;
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
        // ... (unchanged)
        return 0;
    }

    public void playEnvido() {
        // ... (unchanged)
    }

    // Truco Methods
    public void playTruco() {
        System.out.println("Cantaste truco.");
        // ... (add truco logic)
    }

    // Card Playing Methods
    public void playCard() {
        List<Card> hand = getHand();

        if (hand.isEmpty()) {
            System.out.println("No tienes cartas en la mano.");
            return;
        }

        System.out.println(", Elige la carta a jugar [1, 2, 3]");
        int cardIndex = new Scanner(System.in).nextInt();

        if (cardIndex < 1 || cardIndex > hand.size()) {
            System.out.println("Seleccionaste una carta inexistente.");
            System.out.println("Inténtalo de nuevo.");
            System.out.println();
            playCard();
            return;
        }

        Card selectedCard = hand.get(cardIndex - 1);
        System.out.println(selectedCard);
        hand.remove(cardIndex - 1);
        System.out.println("Te quedan " + hand.size() + " cartas restantes");
    }

    // General Gameplay Methods
    public void playOptions() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qué deseas hacer?");
        System.out.println("1. Envido");
        System.out.println("2. Truco");
        System.out.println("3. Jugar una carta");
        System.out.println("4. Irse al mazo");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                playEnvido();
                break;
            case 2:
                playTruco();
                break;
            case 3:
                playCard();
                break;
            case 4:
                endTurn();
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }

    public void endTurn() {
        // ... (add logic for ending the turn)
    }
}
