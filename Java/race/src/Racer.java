import java.util.ArrayList;
import java.util.List;

public class Racer {
    private String name;
    private double avgSpeed;
    private List<Double> sectorTimes;

    public Racer(String name, double avgSpeed) {
        this.name = name;
        this.avgSpeed = avgSpeed;
        this.sectorTimes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public List<Double> getSectorTimes() {
        return sectorTimes;
    }

    public double getTotalTime() {
        return sectorTimes.stream().mapToDouble(Double::doubleValue).sum();
    }

    public void addSectorTime(double time) {
        sectorTimes.add(time);
    }
}
