package src.Players;
import src.Cards.*;
import java.util.List;
import java.util.Random;

public class CPU extends Player {
    public CPU(String name) {
        super(name);
    }

    int lastPlayedTrucoValue;

    @Override
    public void playEnvido() {
        System.out.println("CPU juega envido");
        boolean cpuAcceptsEnvido = respondToEnvido();

        if (cpuAcceptsEnvido) {
            // La CPU acepta el Envido, puedes implementar la lógica adicional aquí
        } else {
            // La CPU no acepta el Envido, puedes implementar la lógica adicional aquí
        }
    }

    public boolean respondToEnvido() {
        boolean cpuAcceptsEnvido = generateBooleanResponse();
        System.out.println("La CPU responde al canto de Envido: " + (cpuAcceptsEnvido ? "Quiero" : "No Quiero"));
        return cpuAcceptsEnvido;
    }

    public boolean respondToTruco() {
        boolean cpuAcceptsTruco = generateBooleanResponse();
        System.out.println("La CPU responde al canto de Truco: " + (cpuAcceptsTruco ? "Quiero" : "No Quiero"));
        return cpuAcceptsTruco;
    }


    @Override
    public void playOptions() {
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
    public Card playCard() {
        List<Card> hand = this.getHand();
        System.out.println(this.getHand());

        if (hand.isEmpty()) {
            System.out.println("CPU No tiene cartas en la mano.");
            return null;
        }

        Random random = new Random();
        int cardIndex = random.nextInt(hand.size());

        Card selectedCard = hand.get(cardIndex);
        System.out.println(selectedCard);
        this.lastPlayedTrucoValue = selectedCard.trucoValue();
        System.out.println(selectedCard.trucoValue());
        hand.remove(cardIndex - 1);
        System.out.println("A la CPU le quedan " + hand.size() + " cartas restantes");
        return selectedCard;
    }

    @Override
    public void playTruco() {
        System.out.println("La CPU le canta truco.");
        System.out.println("Qué deseas hacer?");
        System.out.println("1. Quiero");
        System.out.println("2. No Quiero");
//        Scanner playerResponse = new Scanner(System.in);
//
//        switch (playerResponse) {
//            case 1:
//                System.out.println("CPU juega: ");
//                this.playCard();
//                break;
//            case 2:
//
//                break;
//            default:
//                break;
//        }

    }

    public boolean generateBooleanResponse(){
       Random nextBoolean = new Random();
        return nextBoolean.nextBoolean();
    }


    @Override
    public void endTurn(){
        System.out.println("CPU se va al mazo: ");
        //Repartir puntos
    }

    //COMENTARIO RANDOM

}