package src;
import src.Cards.Card;
import src.Players.HumanPlayer;
import src.Players.Player;
import src.Cards.Deck;

import java.util.List;
import java.util.Scanner;

public class GameLoop {
    Player player1 = new HumanPlayer("null");

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
        //Hardcodeado para probar
        player1.isHand = true;
        //
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
    //loops de juego de envido y truco



    //Jugar carta sin cantar

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

