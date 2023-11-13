package src;
import src.Players.CPU;
import src.Players.HumanPlayer;
import src.Players.Player;
import src.Cards.Deck;
import java.util.Scanner;

public class GameLoop {
    Player player = new HumanPlayer("null");
    CPU cpuPlayer = new CPU("CPU");

    boolean playerIsHand = player.isHand();
    boolean cpuIsHand = cpuPlayer.isHand();


    public void start() {
        //Start game
//        printLogo();
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
        player.setName(scanner.nextLine());

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
        player.drawCards(trucodeck);
        cpuPlayer.drawCards(trucodeck);
//        defineTurn();
        System.out.println(player.getHand());

        //Hardcodeado para probar
//        cpuPlayer.playTruco();

        //
//        if (player.isHand) {
//            System.out.println(player.getName() + " eres mano, tu turno.");
//            printPlayerHand();
//            player.playOptions();
//
//        } else {
//            System.out.println(player.getName() + " no eres mano, aguarda tu turno.");
//            endGame();
//        }
    }


    public void endGame() {
        player.setScore(15);
        // Print winner
        System.out.println("El ganador es: " + player.getName());
    }

    private void printPlayerHand(){
        // Print cards
        System.out.println();
        System.out.println(player.getName() + " tu mano es: \n" + player.getHand());
        System.out.println();
    }

    private void defineTurn(){
        int randomNumber = (int) (Math.random() * 2);
        player.isHand = randomNumber == 0;
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

