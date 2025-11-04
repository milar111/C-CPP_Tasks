public class Main {
    public static void main(String[] args) {
        Book book = new Book("131312", "dracula", "Daniel Y", 2025);
        BookCopy copy = new BookCopy(book, 1);
        LibraryMember member = new LibraryMember("1", "Alex", "dawodkwa@gmail.com");

        System.out.println("book"+book+"\n");
        System.out.println("copy"+copy+"\n");
        System.out.println("Member: " +member+"\n");
        System.out.println(book.matches("dracula"));
    }
}
