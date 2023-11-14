package src.Players;
import src.Cards.Card;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);

    }
    Player cpuPlayer = new CPU("CPU");

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
    public Card playCard() {
        List<Card> hand = getHand();

        int cardIndex = new Scanner(System.in).nextInt();

        if (cardIndex < 1 || cardIndex > hand.size()) {
            playCard();
            return null;
        }

        Card selectedCard = hand.get(cardIndex - 1);
        System.out.println(selectedCard);
        this.lastPlaydTrucoValue = selectedCard.trucoValue();
        hand.remove(cardIndex - 1);
        System.out.println("Te quedan " + hand.size() + " cartas restantes");
        return selectedCard;
    }

    public void playTruco() {
        System.out.println("Cantaste truco.");
    }

}
