package monty;

import java.util.Random;

public class StickingAgent implements Agent {
    private Random random = new Random();

    @Override
    public int getInitialDoor(int numDoors) {
        return this.random.nextInt(numDoors);
    }

    @Override
    public boolean getSwitch() {
        return false;
    }
}
