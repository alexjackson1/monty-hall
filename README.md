# Monty Hall Problem Simulation
I was first introduced to the [Monty Hall Problem](https://en.wikipedia.org/wiki/Monty_Hall_problem) in an Agent and Multi-Agent Systems lecture on probability and game theory.
I remember thinking that, intuitively, the solution to the problem made no sense.
The player initially has a 1 in 3 chance of selecting the car (or non-zero payoff), once a door is removed the player is offered a 1 in 2 chance to guess again.
Surely the player would be no better off by switching than sticking.
After more recently coming across this problem in an episode of [Brooklyn 99](https://www.youtube.com/watch?v=AD6eJlbFa2I), and reviewing the mathematical proof of the 'probability concentration' effect, I decided the only way I could be sure the solution was correct was to write my own simulation.
This repository contains a simple (and by no means original) simulation of the Monty Hall problem written in Java and built with Gradle.

## Running the Simulation
To run the simulation (with 10,000 runs and 3 doors) simply install Gradle and execute `gradle run`.
To adjust the number of runs or the number of doors edit the values in the `main` method of the `Simulation` class.
