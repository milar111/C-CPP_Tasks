public class Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation(3);

        sim.addRacer(new Racer("Iwan", 200));
        sim.addRacer(new Racer("George", 180));
        sim.addRacer(new Racer("Alex", 220));

        sim.startSimulation();
    }
}
