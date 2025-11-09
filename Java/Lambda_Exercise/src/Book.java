import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String title;
    private final Author author;
    private final int yearPublished;
    private final String isbn;

    public Book(String title, Author author, int yearPublished, String isbn) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return title + " " + author.firstName() + " " + author.lastName() + " " + yearPublished + isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        if (isbn != null) return isbn.equals(book.isbn);
        return yearPublished == book.yearPublished && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        if (isbn != null) return isbn.hashCode();
        return Objects.hash(title, author, yearPublished);
    }

    @Override
    public int compareTo(Book other) {
        int yearcmp = Integer.compare(this.yearPublished, other.yearPublished);
        if (yearcmp != 0) return yearcmp;
        return this.title.compareTo(other.title);
    }
}
