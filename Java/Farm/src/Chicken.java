public class Chicken extends Animal implements Prctive, Feed {
    private int eggsPerDay;

    public Chicken(String idTag, String name, int ageInYears, int eggsPerDay) {
        super(idTag, name, ageInYears);
        this.eggsPerDay = eggsPerDay;
    }

    @Override
    public String species() {
        return "chicken";
    }

    @Override
    public double dailyProduction() {
        return eggsPerDay;
    }

    @Override
    public String productUnit() {
        return "eggs";
    }

    @Override
    public void feed(double kgOfFeed) {
        eggsPerDay += (int)(kgOfFeed);
    }
}
