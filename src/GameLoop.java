package src;
import src.Players.CPU;
import src.Players.HumanPlayer;
import src.Players.Player;
import src.Cards.Deck;
import java.util.Random;
import java.util.Scanner;

public class GameLoop {
    Player player = new HumanPlayer("null");
    CPU cpuPlayer = new CPU("CPU");
    boolean playerIsHand = false;
    boolean cpuIsHand = false;
    boolean cpuTrucoChant = cpuPlayer.getCpuTrucoChant();
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
        cpuIsHand = true;
        printScore();
//        defineTurn();

        //FASE 1

        System.out.println(player.getName() + " tu mano es: \n" + player.getHand() + "\n");

        if (playerIsHand) {
            player.playOptions();
        } else {
            cpuPlayer.playTruco();
        }
        Scanner scanner = new Scanner(System.in);
        int response = scanner.nextInt();


        //Si no se quiere truco terminar ronda
        //FASE2
        //FASE3
    }

    public void defineTrucoWinner(){
        if (player.lastPlaydTrucoValue > cpuPlayer.lastPlaydTrucoValue){
            (player).setScore(+2);
            System.out.println(player.getName() + " gana el truco");
        } else {
            (cpuPlayer).setScore(+2);
        }
    }


    public void defineEnvidoWinner(){
        if(player.calculateEnvidoPoints() > cpuPlayer.calculateEnvidoPoints()){
            player.setScore(+2);
        } else {
            cpuPlayer.setScore(+2);
        }
    }
    public void defineRealEnvidoWinner(){
        if(player.calculateEnvidoPoints() > cpuPlayer.calculateEnvidoPoints()){
            player.setScore(+3);
        } else {
            cpuPlayer.setScore(+3);
        }
    }
    public void defineFaltaEnvidoWinner(){
        int points = 0;
        if(player.calculateEnvidoPoints() > cpuPlayer.calculateEnvidoPoints()){
            points = 15 - cpuPlayer.getScore();
            player.setScore(+points);
        } else {
            points = 15 - player.getScore();
            cpuPlayer.setScore(+points);
        }
    }
    public void printScore() {
        System.out.println("Puntos "+player.getName() +" :"+ player.getScore()+"\n");
        System.out.println("Puntos "+cpuPlayer.getName() +" :"+ cpuPlayer.getScore()+"\n");
    }
    private void defineTurn(){
        int random = new Random().nextInt(2);
        if (random == 0){
            playerIsHand = true;
            cpuIsHand = false;
        } else {
            cpuIsHand = true;
            playerIsHand = false;
        }
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

