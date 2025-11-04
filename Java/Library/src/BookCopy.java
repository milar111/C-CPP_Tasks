import java.util.Objects;

public final class BookCopy {
    private final Book book;
    private final int copy;

    public BookCopy(Book book, int copy) {
        this.book = book;
        this.copy = copy;
    }

    public Book book() { return book; }
    public int copy() { return copy; }
    public String isbn() { return book.isbn(); }

    @Override
    public String toString() {
        return "Copy #%d - [%s]".formatted(copy, book);
    }

//    @Override
//    public boolean equals(Object o) {
//        BookCopy other = (BookCopy) o;
//        return this.copy == other.copy && this.book.isbn().equals(other.book.isbn());
//    }


    @Override
    public int hashCode() {
        return 0;
    }
}
