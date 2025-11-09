import java.util.List;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();
        farm.addAnimal(new Cow("C101", "Bessie", 5, 14.2));
        farm.addAnimal(new Cow("C102", "MooMoo", 4, 12.3));
        farm.addAnimal(new Chicken("H201", "Clucky", 2, 2));
        farm.addAnimal(new Chicken("H202", "Nugget", 1, 1));
        farm.removeAnimal("H202");
        farm.addAnimal(new Chicken("H202", "Nugget", 1, 1));

        SelectA selector = new SelectA() {
            public boolean test(Animal a) {
                return a.dailyProduction() > 10;
            }
        };
        List<Animal> selected = farm.select(selector);
        System.out.println(">10:");
        for (Animal a : selected) {
            System.out.println(a);
        }
        farm.feedAll(1.0);
        farm.recordDailyProduction();
        farm.printDailyReport();
    }
}
