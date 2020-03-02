package monty;

public class Door {
    private Payoff payoff;
    private boolean open;

    public Door(Payoff payoff) {
        this.payoff = payoff;
        this.open = false;
    }

    public Payoff getPayoff() {
        return this.payoff;
    }

    public void openDoor() {
        this.open = true;
    }

    public boolean isOpen() {
        return this.open;
    }
}
