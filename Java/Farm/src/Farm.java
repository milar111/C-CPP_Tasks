import java.util.*;

public class Farm {
    private Map<String, Animal> animal = new HashMap<>();
    private Map<String, Double> dayProduction = new HashMap<>();
    private Set<String> present = new HashSet<>();

    public boolean addAnimal(Animal a) {
        for (Animal an : animal.values()) {
            if (an.equals(a)) return false;
        }
        animal.put(a.getIdTag(), a);
        present.add(a.species());
        return true;
    }

    public Animal removeAnimal(String idTag) {
        Animal removed = animal.remove(idTag);
        if (removed != null) {
            updateSpecies();
        }
        return removed;
    }

    private void updateSpecies() {
        present.clear();
        for (Animal a : animal.values()) {
            present.add(a.species());
        }
    }

    public List<Animal> listAnimals() {
        List<Animal> list = new ArrayList<>(animal.values());
        Collections.sort(list, new Comparator<Animal>() {
            public int compare(Animal a1, Animal a2) {
                int s = a1.species().compareTo(a2.species());
                if (s != 0) return s;
                return a1.getName().compareTo(a2.getName());
            }
        });
        return list;
    }

    public List<Animal> select(SelectA selector) {
        List<Animal> result = new ArrayList<>();
        for (Animal a : animal.values()) {
            if (selector.test(a)) result.add(a);
        }
        return result;
    }

    public void recordDailyProduction() {
        dayProduction.clear();
        for (Animal a : animal.values()) {
            if (a instanceof Prctive) {
                dayProduction.put(a.getIdTag(), ((Prctive)a).dailyProduction());
            }
        }
    }

    public void feedAll(double kgPerAnimal) {
        for (Animal a : animal.values()) {
            if (a instanceof Feed) {
                ((Feed)a).feed(kgPerAnimal);
            }
        }
    }

    public void printDailyReport() {

        double total = 0;
        for (Animal a : listAnimals()) {
            if (a instanceof Prctive) {
                Prctive p = (Prctive)a;
                double prod = p.dailyProduction();
                total += prod;
                System.out.printf("%s\t%s\t%s\t%.2f %s%n", a.species(), a.getIdTag(), a.getName(), prod, p.productUnit());
            }
        }

        System.out.println();
        System.out.println(present);
        System.out.printf("production: %.2f%n", total);
    }
}
