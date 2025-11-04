import java.util.Objects;

public abstract class Person extends Entity {
    private final String name;

    protected Person(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() { return name; }
}
