import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyListIterator<T> implements ListIterator<T> {
    private Node<T> next;
    private Node<T> lastReturned;
    private int nextIndex;
    private final MyList<T> list;

    public MyListIterator(MyList<T> list, int index) {
        this.list = list;
        if (index == list.size()) {
            next = null;
        }else {
            next = list.getHead();}
        for (int i = 0; i < index; i++) {
            assert next != null;
            next = next.next;
        }
        nextIndex = index;
    }

    @Override
    public boolean hasNext() {
        return nextIndex < list.size();
    }

    @Override
    public T next() {
        lastReturned = next;
        next = next.next;
        nextIndex++;
        return lastReturned.data;
    }

    @Override
    public boolean hasPrevious() {
        return nextIndex > 0;
    }

    @Override
    public T previous() {
        if (next == null) next = list.getTail();
        else next = next.prev;
        lastReturned = next;
        nextIndex--;
        return lastReturned.data;
    }

    @Override
    public int nextIndex() {
        return nextIndex;
    }

    @Override
    public int previousIndex() {
        return nextIndex - 1;
    }

    @Override
    public void remove() {
        Node<T> lastNext = lastReturned.next;
        list.remove(lastReturned.data);
        if (next == lastReturned) next = lastNext;
        else nextIndex--;
        lastReturned = null;
    }

    @Override
    public void set(T t) {
        lastReturned.data = t;
    }

    @Override
    public void add(T t) {
        list.add(nextIndex++, t);
        lastReturned = null;
    }
}
