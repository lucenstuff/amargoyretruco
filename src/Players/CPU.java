package src.Players;
import src.Cards.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CPU extends Player {
    public CPU(String name) {
        super(name);
    }

    @Override
    public void playEnvido() {
        System.out.println("CPU juega envido");
        //Esperar al quiero y no quiero
    }
    @Override

    public void playOptions(){
        Random random = new Random();
        int option = random.nextInt(3);
        switch (option) {
            case 0:
                playEnvido();
                break;
            case 1:
                playTruco();
                break;
            case 2:
                playCard();
                break;
            default:
                break;
        }
    }
    @Override

    public void playCard() {
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
    @Override

    public void playTruco() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CPU le juega truco" + "\n");
        System.out.println("Elige una opción:");
        System.out.println("1. Quiero");
        System.out.println("2. Quiero Retruco");
        System.out.println("3. No Quiero");

        // Wait for the player's response
        String response = scanner.nextLine();

        System.out.println();
        // Use a switch statement to handle different responses
        switch (response) {
            case "option1":
                // Quiero
                playCard();
                break;
            case "option2":
                // Quiero Retruco
                int random = new Random().nextInt(2);

                if (random == 0) {
                System.out.println("CPU: Quiero Vale 4");
                }
                break;
            case "option3":
                // No Quiero
                playCard();

                break;
            default:
                // Handle other responses
        }
        //Repartir puntos
        // Play the card after the player responds
        playCard();
    }

    @Override
    public void endTurn(){
        System.out.println("CPU se va al mazo: ");
        //Repartir puntos
    }
}