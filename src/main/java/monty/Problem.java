package monty;

import java.util.Random;

public class Problem {
    private Door[] doors;
    private Agent agent;
    private Random random;
    private Door chosenDoor, remainingDoor;

    public Problem(Agent agent, int numDoors) {
        // Check number of doors is strictly less than three
        if (numDoors < 3) throw new IllegalArgumentException("number of doors must not be less than 3");

        // Initialise random object and select correct door
        this.random = new Random();
        int correctDoor = this.random.nextInt(numDoors);

        // Initialise empty array of doors
        this.doors = new Door[numDoors];

        // Initialise each door with payoff
        for (int i = 0; i < numDoors; i++) {
            Payoff payoff = correctDoor == i ? Payoff.Something : Payoff.Nothing;
            this.doors[i] = new Door(payoff);
        }

        // Set agent as provided agent instance
        this.agent = agent;
    }

    private void selectDoor() {
        this.chosenDoor = this.doors[this.agent.getInitialDoor(this.doors.length)];
    }

    private void openDoors() {
        if (this.chosenDoor.getPayoff() == Payoff.Something) {
            // Randomly decide which door should be left closed
            int doorToLeaveClosed = this.random.nextInt(this.doors.length - 1);

            // Keep track of how many doors have been opened
            int openedDoorCounter = 0;

            // Iterate through the doors, opening certain doors
            for (Door door : this.doors) {
                // Do not open chosen door
                if (door.equals(this.chosenDoor)) continue;

                // Do not open randomly chosen door
                if (openedDoorCounter == doorToLeaveClosed) {
                    this.remainingDoor = door;
                    continue;
                }

                // Open door
                door.openDoor();
                ++openedDoorCounter;
            }
        } else {
            // Iterate through doors, opening all doors with no payoff
            for (Door door : this.doors) {
                // Do not open chosen door
                if (door.equals(this.chosenDoor)) continue;

                // Do not open door with payoff
                if (door.getPayoff() == Payoff.Something) {
                    this.remainingDoor = door;
                    continue;
                }

                // Open door
                door.openDoor();
            }
        }
    }

    private void stickOrSwitch() {
        if (this.agent.getSwitch()) {
            this.chosenDoor = this.remainingDoor;
        }
    }

    private int getPayoff() {
        return this.chosenDoor.getPayoff() == Payoff.Something ? 1 : 0;
    }

    public int run() {
        // Agent selects a door
        selectDoor();

        // Monty Hall opens remaining doors such that:
        // One door is left and all opened doors had no payoff
        openDoors();

        // Agent decides whether to stick or switch doors
        stickOrSwitch();

        // Payoff is returned
        return getPayoff();
    }
}
