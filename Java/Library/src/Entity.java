import java.util.Objects;

public abstract class Entity {
    private final String id;

    protected Entity(String id) {
        this.id = id;
    }

    public String getId() { return id; }
}
