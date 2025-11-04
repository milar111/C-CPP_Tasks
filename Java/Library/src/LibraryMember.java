public final class LibraryMember extends Person {
    private final String email;

    public LibraryMember(String id, String name, String email) {
        super(id, name);//person
        this.email = email;
    }

    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "id=" + getId() + "name=" + getName() + "email=" + email;
    }

}
