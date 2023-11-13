package src.Players;
import src.Cards.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CPU extends Player {

    int playerResponse = 0;
    public CPU(String name) {
        super(name);
    }

    int lastPlayedTrucoValue;
    boolean cpuTrucoChant = false;

    public boolean getCpuTrucoChant() {
        return cpuTrucoChant;
    }

    public void setCpuTrucoChant(boolean cpuTrucoChant) {
        this.cpuTrucoChant = cpuTrucoChant;
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


    public boolean isCpuTrucoChant() {
        return cpuTrucoChant;
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
        lastPlayedTrucoValue = selectedCard.trucoValue();
    }
    @Override

    public void playTruco() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CPU le juega truco" + "\n");
        cpuTrucoChant = true;
        Scanner trucoResponse = new Scanner(System.in);
        // Wait for the player's response
        System.out.println("Elige una opción:");
        System.out.println("1. Quiero");
        System.out.println("2. Quiero retruco");
        System.out.println("3. No Quiero");

        int playerResponse = scanner.nextInt();

        //Obtener respuesta del jugador
        switch (playerResponse) {

            case 0:
                //Quiero
                break;
            case 1:
                //Esperar respuesta de cpu

                break;
            case 2:
                //No quiero
                //End Turn
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }



    @Override
    public void endTurn(){
        System.out.println("CPU se va al mazo: ");
        //Repartir puntos
    }
}