package src;
import src.Players.CPU;
import src.Players.HumanPlayer;

import java.util.Random;

import static java.lang.System.nanoTime;

public class RoundManager {
    private final HumanPlayer player;
    private final CPU cpu;
    private final TurnManager turnManager;
    boolean playerFirst = false;
    boolean isFirstTurn = true;

    public boolean isPlayerFirst() {
        return playerFirst;
    }

    public void setPlayerFirst(boolean playerFirst) {
        this.playerFirst = playerFirst;
    }

    /*
    1. Nuevo Turno - Envido - Jugar callado - cantar truco - termina al jugar carta o irse al mazo
    ¿Se puede cantar envido? - Si. si es el primer turno.
    2. Jugar callado - Cantar Truco - Termina al jugar carta o irse al mazo
    3. Depende de quien gana la anterior ronda Jugar callado - Cantar Truco - Termina al jugar carta o irse al mazo/ Si jugador gana 2 rondas termina, a partir 2da ronda.
     */
    private trucoRoundState currentState = trucoRoundState.NOCHANT;

    public HumanPlayer getPlayer() {
        return player;
    }

    public CPU getCpu() {
        return cpu;
    }

    public RoundManager(HumanPlayer player, CPU cpu, TurnManager turnManager) {
        this.player = player;
        this.cpu = cpu;
        this.turnManager = turnManager;
        this.playerFirst = player.getIsHand();
    }

    public void roundHandler() {
        String turnResult = sendTurn();
    }
    /*
    Resultados posibles:
    Gana jugador
    Gana cpu
    empatan
    Hubo envido
     */

    public String sendTurn() {
        if (this.playerFirst) {
            return turnManager.resolveTurn(player, cpu, isFirstTurn);

        } else {
            return turnManager.resolveTurn(cpu, player, isFirstTurn);
        }
    }

    public void defineFirstHand() {
        long seed = System.nanoTime();
        Random random = new Random(seed);
        double auxnumber = random.nextDouble();
        boolean randomBoolValue = auxnumber < 0.5;
        System.out.println(randomBoolValue);
        player.setIsHand(randomBoolValue);
        cpu.setIsHand(!randomBoolValue);
        this.playerFirst = player.getIsHand();
    }
}
