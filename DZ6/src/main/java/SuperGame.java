import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class SuperGame {
    private int winningDoor;
    private Player player;
    private ArrayList<Integer> doorsToOpen;
    private ArrayList<Integer> doorsToPick;
    private ArrayList<Double> stats;

    public void setPlayer(Player player) {
        this.player = player;
    }

    private void setPrizes() {
        winningDoor = new Random().nextInt(3);
    }

    public void Play(int numberOfRounds) {
        stats = new ArrayList<>();
        for (int i = 0; i < numberOfRounds; i++) {
            doorsToOpen = new ArrayList<>(Arrays.asList(0, 1, 2));
            doorsToPick = new ArrayList<>(Arrays.asList(0, 1, 2));
            setPrizes();
            doorsToOpen.removeIf((n) -> n == winningDoor);
            int initialChoice = player.initialChoice();
            int doorOpened;
            int finalChoice = initialChoice;
            if (initialChoice == winningDoor) {
                doorOpened = doorsToOpen.get(new Random().nextInt(doorsToOpen.size()));
            } else {
                doorsToOpen.removeIf((n) -> n == initialChoice);
                doorOpened = doorsToOpen.get(0);
            }
            doorsToPick.removeIf((n) -> n == doorOpened);
            if (player.choiceAltered()) {
                doorsToPick.removeIf((n) -> n == initialChoice);
                finalChoice = doorsToPick.get(0);
            }
            stats.add(finalChoice == winningDoor ? 1.0 : 0.0);
        }
    }

    public void printStats() {
        double[] statsAsDoubleArray = stats.stream().mapToDouble(Double::doubleValue).toArray();
        double winRate = new DescriptiveStatistics(statsAsDoubleArray).getMean();
        System.out.println("Winning Percentage is: " + winRate * 100);

    }
}
