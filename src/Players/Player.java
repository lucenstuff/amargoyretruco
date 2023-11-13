package src.Players;

import src.Cards.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Player {
    private String name;

    public boolean isHand;

    public void setName(String name) {
        this.name = name;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumCards() {
        return numCards;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    private static List<Card> hand;
    private int score;
    int numCards = 3;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public void drawCard(Deck deck) {
        if (hand.size() >= 3) {
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
    public String getName() {
        return this.name;
    }

    public void updateScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }


    public static List<Card> getHand() {
        return hand;
    }

    public void drawCards(Deck deck){
        for (int i = 0; i < 3; i++) {
            Card card = deck.drawCard();
            if (card != null){
                hand.add(card);
            }else {
                System.out.println("Deck is empty");
            }
        }
        deck.removeCard(hand);
    }

    public static int calculateEnvidoPoints() {
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
                for (int i = 0; i < hand.size(); i++) {
                    int currentEnvidoValue = hand.get(i).envidoValue();
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
                HumanPlayer.playEnvido();
                break;
            case 2:
                HumanPlayer.playTruco();
                break;
            case 3:
                HumanPlayer.playCard();
                break;
            case 4:
                endTurn();
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }
    public void endTurn(){
        //Lógica para irse al mazo
    }

    public static void playEnvido() {
        System.out.println("Cantaste envido.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una opción:");
        System.out.println("1. Envido");
        System.out.println("2. Real Envido");
        System.out.println("3. Falta Envido");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                int envidoPoints = calculateEnvidoPoints();
                System.out.println("Tienes " + envidoPoints + " puntos de envido.");
                break;
            case 2:
                int realEnvidoPoints = calculateEnvidoPoints();
                System.out.println("Tienes " + realEnvidoPoints + " puntos de envido.");
                break;
            case 3:
                int faltaEnvidoPoints = 15 - calculateEnvidoPoints();
                System.out.println("Te faltan " + faltaEnvidoPoints + " puntos para ganar el envido.");
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }

    public static void playTruco() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Has jugado truco.");
        // Logic to respond to the truco
        // ...
    }

    public static void playCard() {
        List<Card> hand = getHand();

        if (hand.isEmpty()) {
            System.out.println("No tienes cartas en la mano.");
            return;
        }

        System.out.println(", Elige la carta a jugar [1,2,3]");
        int cardIndex = new Scanner(System.in).nextInt();

        if (cardIndex < 1 || cardIndex > hand.size()) {
            System.out.println("Seleccionaste una carta inexistente.");
            System.out.println("Intentalo de nuevo.");
            System.out.println();
            playCard();
            return;
        }

        Card selectedCard = hand.get(cardIndex - 1);
        System.out.println(selectedCard);
        hand.remove(cardIndex - 1);
        System.out.println("Te quedan " + hand.size() + " cartas restantes");
    }


}