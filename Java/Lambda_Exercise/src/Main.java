import java.util.*;

public class Main {
    public static void main(String[] args) {
        Author a1 = new Author("A1", "B1", 1980);
        Author a2 = new Author("A2", "B2", 1975);
        Author a3 = new Author("A3", "B1", 1990);

        Book b1 = new Book("T1", a1, 2000, "ISBN1");
        Book b2 = new Book("T2", a2, 1995, "ISBN2");
        Book b3 = new Book("T3", a2, 2010, "ISBN3");
        Book b4 = new Book("T4", a3, 2000, null);

        List<Book> books = new ArrayList<>(List.of(b1, b2, b3, b4));

        System.out.println(b1);
        System.out.println("b1 equals b2: " + b1.equals(b2));
        System.out.println("\nsortedYT:");
        Collections.sort(books);
        books.forEach(System.out::println);

        Comparator<Book> byAuthorThenTitle = Comparator.comparing((Book b) -> b.getAuthor().lastName()).thenComparing(b -> b.getAuthor().firstName()).thenComparing(Book::getTitle);////

        System.out.println("\nsortedAT:");
        books.stream().sorted(byAuthorThenTitle).forEach(System.out::println);

        Comparator<Book> byTitleLengthThenAlpha = Comparator.comparingInt((Book b) -> b.getTitle().length()).thenComparing(Book::getTitle);

        System.out.println("\nsortedLT");
        books.stream().sorted(byTitleLengthThenAlpha).forEach(System.out::println);

        Formater formatter = b -> String.format("%s by %s %s %d %s", b.getTitle(), b.getAuthor().lastName(), b.getAuthor().firstName(), b.getYearPublished(), b.getIsbn());
        System.out.println("\nformated:");
        books.stream().map(formatter::format).forEach(System.out::println);
    }
}