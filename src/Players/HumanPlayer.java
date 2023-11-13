package src.Players;
import src.Cards.Card;
import java.util.List;
import java.util.Scanner;


public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void playOptions() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qué deseas hacer?");
        System.out.println("1. Jugar Envido");
        System.out.println("2. Jugar Truco");
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

    @Override
    public void playEnvido() {
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

    @Override
    public void playTruco() {
        System.out.println("Cantaste Truco.");

        // ... (add truco logic)
    }

    @Override
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
        this.lastPlaydTrucoValue = selectedCard.trucoValue();
        hand.remove(cardIndex - 1);
        System.out.println("Te quedan " + hand.size() + " cartas restantes");
    }
}
