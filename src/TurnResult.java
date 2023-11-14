package src;
public class TurnResult {
    private trucoRoundState state;
//    winner weiner
    public void setState(trucoRoundState state) {
        this.state = state;
    }

    public trucoRoundState getState() {
        return state;
    }
}
