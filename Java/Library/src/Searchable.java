public interface Searchable extends Auditable {
    boolean matches(String query);
}
