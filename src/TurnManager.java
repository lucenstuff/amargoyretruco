package src;
import src.Players.CPU;
import src.Players.HumanPlayer;

public class TurnManager {
    private HumanPlayer player;
    private CPU cpu;
//    int playerRoundsWon = 0;
//    int cpuRoundsWon = 0;
//    boolean envidoPhaseDone = false;
//    boolean trucoPhaseDone = false;
//    boolean cardPlayPhaseDone = false;

    //traer quien juega primero
    //
//    public String resolveTurn(HumanPlayer player, CPU cpuPlayer){
//
//
//        //turno de truco, invocando funciones de envido / truco y jugando ambas cartas
//        //Setear en variables del jugador/cpu qué puede cantar el jugador / cpu (truco retruco envidos)
//        // según las cosas que vayan cantando
//
//        //return con un switch quien ganó / empate
//
//
//    }


    String resolveTurn(CPU cpuPlayer, HumanPlayer player, boolean isFirstTurn){
        return "cpu";
    }

    String resolveTurn( HumanPlayer player,CPU cpuPlayer, boolean isFirstTurn){
        return "player";
    }



    public void envidoPhase() {

    }

    public void executeTrucoPhase() {

    }

    public void executeCardPlayPhase() {
        // Lógica para la fase de juego de cartas
        // Aquí puedes implementar la lógica para que los jugadores jueguen sus cartas y determinar el ganador de la ronda
        // Puedes usar métodos adicionales para gestionar las reglas del juego de cartas y calcular los puntos ganados
        advanceRoundPhase();
    }
    private String getPlayerResponse() {
        // Lógica para obtener la respuesta del jugador (por ejemplo, leer la entrada del usuario)
        // Implementa la lógica necesaria para obtener la respuesta del jugador según la interfaz de entrada de tu juego
        return null;
    }

    public void handleTie() {
        //si hay empate, volver a usar el anterior playerFirst
        //si hay empate en primera, entrar en un if que asigne la ronda 2 como decisiva
        //si ganas primera y empatas segunda, ganas vos
        //contador de cuantas rondas ganadas llevas y segun eso decidir que hace el empate

        //variable de quién ganó el anterior turno para ser el primero en poner carta

        //dar vuelta el jugador mano para la siguiente ronda
    }

    public void advanceRoundPhase() {
        // Lógica para avanzar la fase de ronda
        // Aquí puedes implementar la lógica para que los jugadores jueguen sus cartas y determinar el ganador de la ronda
        // Puedes usar métodos adicionales para gestionar las reglas del juego de cartas y calcular los puntos ganados
    }

    public void defineEnvidoWinner(){
        if(player.calculateEnvidoPoints() > cpu.calculateEnvidoPoints()){
            player.setScore(+2);
        } else {
            cpu.setScore(+2);
        }
    }
    public void defineRealEnvidoWinner(){
        if(player.calculateEnvidoPoints() > cpu.calculateEnvidoPoints()){
            player.setScore(+3);
        } else {
            cpu.setScore(+3);
        }
    }
    public void defineFaltaEnvidoWinner(){
        int points = 0;
        if(player.calculateEnvidoPoints() > cpu.calculateEnvidoPoints()){
            points = 15 - cpu.getScore();
            player.setScore(+points);
        } else {
            points = 15 - player.getScore();
            cpu.setScore(+points);
        }
    }
}
