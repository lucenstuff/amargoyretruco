package src;
import src.Cards.Card;
import src.Players.Player;
import src.Cards.Deck;

import java.util.List;
import java.util.Scanner;

public class GameLoop {
    Player player1 = new Player("null");

    public void start() {
        //Start game
        printLogo();
        System.out.println("Juego Iniciado.");
        System.out.println("");
        gameLoop();
        // Initialize players and deck
        // Game loop
        System.out.println("Juego Finalizado.");
    }

    private void gameLoop(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Jugador, ingresa tu nombre: ");
        player1.setName(scanner.nextLine());

        //implementar while loop una vez el algoritmo esté listo
//        while ((player1.getScore() < 15 || player1.getScore() < 15)) {
//            // Update game logic
//        }
        defineTurn();
        gameUpdate();
    }

    private void gameUpdate() {
        // Generar mazo y mezclarlo
        Deck trucodeck = new Deck();
        trucodeck.shuffle();
        player1.drawCards(trucodeck);
        defineTurn();
        player1.isHand = true;
        if (player1.isHand) {
            System.out.println(player1.getName() + " eres mano, tu turno.");
            printPlayerHand();
            playOptions();

        } else {
            System.out.println(player1.getName() + " no eres mano, aguarda tu turno.");
            endGame();
        }
    }

    public void endGame() {
        player1.setScore(15);
        // Print winner
        System.out.println("El ganador es: " + player1.getName());
    }

    private void printPlayerHand(){
        // Print cards
        System.out.println();
        System.out.println(player1.getName() + " tu mano es: \n" + player1.getHand());
        System.out.println();
    }

    private void defineTurn(){
        int randomNumber = (int) (Math.random() * 2);
        if (randomNumber == 0) {
            player1.isHand = true;

        } else {
            player1.isHand = false;
        }
    }

    //Opciones para el jugador

    private void playOptions() {
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
    public void endTurn(){
        //Lógica para irse al mazo
    }
    //loops de juego de envido y truco

    private void playEnvido() {

        System.out.println("Cantaste envido.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una opción:");
        System.out.println("1. Envido");
        System.out.println("2. Real Envido");
        System.out.println("3. Falta Envido");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                // Lógica para el envido
                int envidoPoints = player1.calculateEnvidoPoints();
                System.out.println("Tienes " + envidoPoints + " puntos de envido.");
                break;
            case 2:
                // Lógica para el real envido (misma lógica que el envido)
                int realEnvidoPoints = player1.calculateEnvidoPoints();
                System.out.println("Tienes " + realEnvidoPoints + " puntos de envido.");
                break;
            case 3:
                // Lógica para el falta envido
                int faltaEnvidoPoints = 15 - player1.calculateEnvidoPoints(); // Suponiendo que la partida se juega hasta 15 puntos
                System.out.println("Te faltan " + faltaEnvidoPoints + " puntos para ganar el envido.");
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        // Lógica para que la AI responda al envido
        // ...
    }
    private void playTruco() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Has jugado truco.");

        playCard();

        // Lógica para que la AI responda al truco
        // ...
    }

    //Jugar carta sin cantar
    public void playCard(){
        System.out.println(player1.getName()+", Elige la carta a jugar [1,2,3]");
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
        System.out.println("Te quedan "+ hand.size() + " cartas restantes" );
    }
   public void printLogo () {
       System.out.println("                                                                                                                                                                                                        \n" +
               "      =%%#      =%%%#     .%%%%-      #%%=      #%%%%%#*-      =#@@@%+.     .+%@@%*-         #%%=    *%%*      .%%%%%%#+.   :%%%%%%%%%.-%%%%%%%%%%%  %%%%%%#+:   -%%%    *%%=    =#@@@#+      :*%@@%*.  \n" +
               "      @@@@-     +@@@@:    =@@@@-     :@@@@      %@@@@@@@@#   .%@@@@@@@@:   -@@@@@@@@*        =@@@   :@@@.      .@@@@@@@@@+  -@@@@@@@@@.=@@@@@@@@@@@  @@@@@@@@@+  -@@@    %@@=   %@@@@@@@@.   +@@@@@@@@= \n" +
               "     =@@@@#     +@@@@*    %@@@@-     #@@@@=     %@@+..-@@@=  #@@#.  +@@%  .@@@=  :@@@+        %@@+  #@@+       .@@@:..+@@@. -@@@......  ...=@@@...   @@@-..=@@@: -@@@    %@@=  *@@#.  *@@#  -@@@:  -@@@:\n" +
               "     %@@%@@:    +@@@@@   :@@@@@-    .@@%@@%     %@@=   #@@* .@@@:   .%%%  +@@%    =@@@        :@@@ :@@%        .@@@.   @@@- -@@@           =@@@      @@@:   @@@= -@@@    %@@=  @@@:   .@@@. #@@+    *@@*\n" +
               "    -@@*-@@*    +@@#@@=  *@@#@@-    *@@-*@@-    %@@=   %@@+ :@@@          #@@*    :@@@.        *@@=#@@-        .@@@.  .@@@: -@@@:::::      =@@@      @@@:   @@@- -@@@    %@@= :@@@.         @@@-    +@@%\n" +
               "    #@@- @@@.   +@@+#@#  @@+#@@-   .@@@ -@@#    %@@#++#@@@. :@@@  :=====  #@@+    .@@@.         @@@@@#         .@@@+++%@@#  -@@@@@@@@:     =@@@      @@@*++%@@%  -@@@    %@@= :@@@          @@@-    =@@%\n" +
               "   :@@@  +@@+   +@@*-@@.-@@.%@@-   +@@*  @@@:   %@@@@@@@#.  :@@@  +@@@@@. #@@+    .@@@.         =@@@@.         .@@@@@@@@+   -@@@*****.     =@@@      @@@@@@@@*   -@@@    %@@= :@@@          @@@-    =@@%\n" +
               "   *@@%**#@@@   +@@# @@+#@# %@@-   @@@#**%@@#   %@@*-%@@#   :@@@  .-=@@@. *@@*    :@@@.          %@@*          .@@@+=@@@=   -@@@           =@@@      @@@+=@@@+   -@@@    %@@= :@@@.    :::  @@@-    +@@%\n" +
               "  .@@@@@@@@@@=  +@@# +@@@@- @@@-  =@@@@@@@@@@.  %@@= :@@@-   @@@-   .@@@. =@@%    =@@%           %@@+          .@@@. +@@@.  -@@@           =@@@      @@@: =@@@.  -@@@    %@@=  @@@:   :@@@. #@@*    #@@*\n" +
               "  +@@%::::+@@@  +@@# .@@@%  @@@-  %@@+::::#@@*  %@@=  *@@%   +@@@=::+@@@.  @@@*::=@@@=           %@@+          .@@@.  %@@*  -@@@------     =@@@      @@@:  %@@#   @@@*::+@@@.  +@@%-.:#@@#  :@@@+::+@@@.\n" +
               "  @@@=     @@@- +@@#  *@@=  @@@- -@@@.    -@@@. %@@=  .@@@+   *@@@@@@@@*   .%@@@@@@@=            %@@+          .@@@.  -@@@: -@@@@@@@@@.    =@@@      @@@:  :@@@-  -@@@@@@@@=    *@@@@@@@#    -@@@@@@@@: \n" +
               " :+++      =++= -++=  :++   +++: =++=      +++: +++:   -+++    .=*##*=.      -+##*=.             =++-           +++.   =++= .+++++++++.    :+++      +++.   =+++    =**#*=.      :+*#*+:       =*##*-   \n" +
               "                                                                                                                                                                                                        \n" +
               "                                                                                                                                                                                                      ");
   }
}

