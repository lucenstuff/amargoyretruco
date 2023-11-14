package src;

import src.Players.CPU;
import src.Players.HumanPlayer;

public class GUI {

    private final HumanPlayer player;

    private final CPU cpu;

    public GUI(HumanPlayer player, CPU cpu) {
        this.player = player;
        this.cpu = cpu;
    }



    public void display() {

    }

    public void printScore() {
        System.out.println("Puntos "+player.getName() +" :"+ player.getScore()+"\n");
        System.out.println("Puntos "+cpu.getName() +" :"+ cpu.getScore()+"\n");
    }

    public void displayMenu() {

    }
}
