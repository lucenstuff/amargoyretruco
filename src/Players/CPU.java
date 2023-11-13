package src.Players;

import src.Cards.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CPU extends Player {
    public CPU(String name) {
        super(name);
    }

    public static void playEnvido() {
        //Lógica envido IA
    }
    public static void playCard() {
        List<Card> hand = getHand();

        if (hand.isEmpty()) {
            return;
        }

        Random random = new Random();
        int cardIndex = random.nextInt(hand.size());

        Card selectedCard = hand.get(cardIndex);
        System.out.println();
        System.out.println("CPU juega: " + selectedCard);
        System.out.println();
        hand.remove(cardIndex);
    }

    public static void playTruco() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CPU le juega truco");
        // Esperar a que el jugador conteste
        // ...
    }
}