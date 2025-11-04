import java.util.Objects;
public record Book(String isbn, String title, String author, int year) implements Searchable {

    @Override
    public String toString() {
        return isbn + "-" + title + "-" + author + "-" + year;
    }

    @Override
    public String auditTag() {
        return "book:" + isbn;
    }

    @Override
    public boolean matches(String q) {
//        return isbn == q || title == q || author == q || String.valueOf(year) == q;
        return isbn.equals(q) || title.equals(q) || author.equals(q) || String.valueOf(year).equals(q);
    }
}
