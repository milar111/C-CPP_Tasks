import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Simulation {
    private List<Racer> racers;
    private int sectors;
    private Random rand;

    public Simulation(int sectors) {
        this.racers = new ArrayList<>();
        this.sectors = sectors;
        this.rand = new Random();
    }

    public void addRacer(Racer racer) {
        racers.add(racer);
    }

    public void startSimulation() {
        for (int sector = 1; sector <= sectors; sector++) {
            for (Racer r : racers) {
                double randomFactor = rand.nextDouble() * 0.45 + 0.75;
                double time = r.getAvgSpeed() / randomFactor;
                r.addSectorTime(time);
            }

            racers.sort(Comparator.comparingDouble(Racer::getTotalTime));
        }

        for (Racer r : racers) {
            System.out.printf("%s - %.2f%n",r.getName(), r.getTotalTime());
        }
    }
}
