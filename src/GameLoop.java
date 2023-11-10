package src;
import src.Cards.Card;
import src.Players.Player;
import src.Cards.Deck;
import java.util.List;
import java.util.Scanner;

public class GameLoop {
    private boolean isRunning;
    boolean player1EnvidoChant = false;
    boolean player1TrucoChant = false;

    Player player1 = new Player("null");
    Player player2 = new Player("null");

    public void start() {
        //Start game
        isRunning = true;
        System.out.println("Juego Iniciado.");
        gameLoop();
        // Initialize players and deck
        // Game loop
        System.out.println("Juego Finalizado.");
    }

    private void gameLoop(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Jugador, ingresa tu nombre: ");
        player1.setName(scanner.nextLine());
        while (isRunning && (player1.getScore() < 15 || player1.getScore() < 15)) {
            // Update game logic
            gameUpdate();
        }
    }

    private void gameUpdate() {
        // generate a deck
        Deck trucodeck = new Deck();
        trucodeck.shuffle();

        //Each player draws 3 cards
        player1.drawCards(trucodeck);
        //player2.drawCards(trucodeck);

        //cpu draws cards

        //Phase 1 starts

        // Print cards
        System.out.println();
        System.out.println(player1.getName() + " tu mano es: \n" + player1.getHand());
        System.out.println();

        //Define which player is hand and which is foot
        //first is random

        player1.isHand = true;

        if (player1.isHand == true){

            //player1 plays
            switch (playOptions()){
                case 1:
                    playEnvido();
                    break;
                case 2:
                    playTruco();
                    break;
                case 3:

                    break;
            }
        }
//        else
//           //Wait for the other player to play
//
//        playCard();
    }


    private int playOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Qué deseas hacer?");
        System.out.println("1. Envido");
        System.out.println("2. Truco");
        System.out.println("3. Al Mazo");
        return scanner.nextInt();
    }

    private void playTruco(){
        player1TrucoChant = true;
        int TrucoCounter = 1;
        //wait for other player to respond to truco
        // if player respond yes
        playCard();
    }

    private void reTruco(){

    }

    private void playEnvido(){
        Scanner scanner = new Scanner(System.in);
        player1.calculateEnvidoPoints();
        player1EnvidoChant = true;
    }

//    private void wonEnvido(){
//        player1envidoPoints = player1.calculateEnvidoPoints();
//        cpu.calculateEnvidoPoints(); = cpu.calculateEnvidoPoints();
//        if (player1envidoPoints > cpu.envidoPoints){
//            System.out.println("Jugador gana");}
    //Añadir puntos correspondiente al nivel de envido
//        }else{
//            System.out.println("CPU gana");
    //Añadir puntos correspondiente al nivel de envido
//        }
//    }

    public void playCard(){
        System.out.println(player1.getName()+", Elige la carta a jugar? [1,2,3]");
         List<Card> hand = player1.getHand();

        int cardIndex = new Scanner(System.in).nextInt();

        if (hand.size() < cardIndex) {
            System.out.println("Seleccionaste una carta inexistente.");
            System.out.println("Intentalo de nuevo.");
            System.out.println();
            playCard();
        }
        Card SelectedCard1 = hand.get(cardIndex-1);
        System.out.println(SelectedCard1);
        hand.remove(cardIndex-1);
        System.out.println("Te quedan  :" + hand.size() + " cartas.");
    }

    private void updateScore(){
        player1.setScore(15);
    }

}