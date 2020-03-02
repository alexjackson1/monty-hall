package monty;

public class Simulation {
    public static void run(Agent agent, int numRuns, int numDoors) {
        int totalPayoff = 0;
        for (int i = 0; i < numRuns; i++) {
            Problem problem = new Problem(agent, numDoors);
            totalPayoff += problem.run();
        }

        float probability = (float) totalPayoff / (float) numRuns;

        System.out.println("Iterations:  " + numRuns);
        System.out.println("Successful:  " + totalPayoff);
        System.out.printf("Probability: %.2f\n", probability);
    }

    public static void main(String[] args) {
        int runs = 100000;
        int doors = 3;

        System.out.println("Random Agent ===");
        run(new RandomAgent(), runs, doors);
        System.out.print("\n");

        System.out.println("Sticking Agent ===");
        run(new StickingAgent(), runs, doors);
        System.out.print("\n");

        System.out.println("Switching Agent ===");
        run(new SwitchingAgent(), runs, doors);
    }
}
