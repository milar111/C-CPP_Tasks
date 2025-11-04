import java.util.*;

public class Main{
    public class void main(String[] args){
        System.out.println("Hello, World!");
    }
}

public class Game {

    public enum Color {
        RED('R'), BLUE('B'), GREEN('G'), YELLOW('Y');

        public char label;
        Color(char label) { this.label = label; }

        public static Color random(Random rnd) {
            Color[] vals = values();
            return vals[rnd.nextInt(vals.length)];
        }
    }

    public static class Cell {
        protected final Color color;
        public Cell(Color color) { this.color = color; }
        public Color getColor() { return color; }
        public void onSwapped(Game game, int x, int y, Random rnd) {}
        public char representation() {
            if (color == null) return '-';
            return color.label;
        }
        public boolean isEmpty() { return color == null; }
    }

    public static class EmptyCell extends Cell {
        public EmptyCell() { super(null); }
        @Override public char representation() { return '.'; }
    }
}