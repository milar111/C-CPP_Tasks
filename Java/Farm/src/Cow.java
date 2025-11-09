public class Cow extends Animal implements Prctive, Feed {
    private double litersDay;

    public Cow(String idTag, String name, int ageInYears, double litersDay) {
        super(idTag, name, ageInYears);
        this.litersDay = litersDay;
    }

    @Override
    public String species() {
        return "Cow";
    }

    @Override
    public double dailyProduction() {
        return litersDay;
    }

    @Override
    public String productUnit() {
        return "milk";
    }

    @Override
    public void feed(double kgOfFeed) {
        litersDay += kgOfFeed * 0.1;
    }
}
