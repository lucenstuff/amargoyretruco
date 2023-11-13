package src;
import src.Cards.Card;
import src.Players.CPU;
import src.Players.HumanPlayer;
import src.Players.Player;
import src.Cards.Deck;

import java.util.List;
import java.util.Scanner;

public class GameLoop {
    Player player1 = new HumanPlayer("null");
    CPU cpu = new CPU("CPU");

    public void start() {
        //Start game
        printLogo();
        System.out.println("Juego Iniciado.");
        System.out.println();
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
        gameUpdate();

    }

    private void gameUpdate() {

        // Generar mazo y mezclarlo
        Deck trucodeck = new Deck();
        trucodeck.shuffle();
        player1.drawCards(trucodeck);
        cpu.drawCards(trucodeck);
        defineTurn();

        //Hardcodeado para probar
        cpu.isHand = true;
        cpu.playTruco();
        //
        if (player1.isHand) {
            System.out.println(player1.getName() + " eres mano, tu turno.");
            printPlayerHand();
            Player.playOptions();

        } else {
            System.out.println(player1.getName() + " no eres mano, aguarda tu turno.");
            endGame();
        }
    }

    public static void CPUplaysCard() {
        CPU.playCard();
    }

    public void endGame() {
        player1.setScore(15);
        // Print winner
        System.out.println("El ganador es: " + player1.getName());
    }

    private void printPlayerHand(){
        // Print cards
        System.out.println();
        System.out.println(player1.getName() + " tu mano es: \n" + Player.getHand());
        System.out.println();
    }

    private void defineTurn(){
        int randomNumber = (int) (Math.random() * 2);
        player1.isHand = randomNumber == 0;
    }

    //Opciones para el jugador


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

