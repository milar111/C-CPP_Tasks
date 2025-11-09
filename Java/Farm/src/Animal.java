public abstract class Animal {
    protected String idTag;
    protected String name;
    protected int ageInYears;

    public Animal(String idTag, String name, int ageInYears) {
        this.idTag = idTag;
        this.name = name;
        this.ageInYears = ageInYears;
    }

    public String getIdTag() {
        return idTag;
    }

    public String getName() {
        return name;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public abstract String species();
    public abstract double dailyProduction();

    @Override
    public String toString() {
        return species() + " " + idTag + " " + name + " " + ageInYears + " " + dailyProduction();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Animal)) return false;
        Animal a = (Animal) o;
        return idTag.equals(a.idTag) && species().equals(a.species());
    }

    @Override
    public int hashCode() {
        return (idTag + species()).hashCode();
    }
}
