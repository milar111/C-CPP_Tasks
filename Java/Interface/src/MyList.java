import java.util.*;
public class MyList<T> implements List<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<T>(t);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next= newNode;
            newNode.prev = tail;
            tail = newNode;
        }size++;
        return true;
    }

    private void removes(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        if (prev == null) head = next;
        else prev.next = next;
        if (next == null) tail = prev;
        else next.prev = prev;
        size--;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                removes(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T set(int index, T element) {
        Node<T> node = getNode(index);
        T old = node.data;
        node.data = element;
        return old;
    }

    private Node<T> getNode(int index) {
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }return current;
    }

    @Override
    public void add(int index, T element) {
        Node<T> newNode = new Node<>(element);
        if(index == size){
            add(element);
        }else if (index==0){
            newNode.next= head;
            if(head != null) head.prev = newNode;
            head = newNode;
            if(tail == null) tail = newNode;
        }else{
            Node<T> current = getNode(index);
            Node<T> prevNode = current.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        Node<T> toRemove = getNode(index);
        T data = toRemove.data;
        removes(toRemove);
        return data;
    }

    @Override
    public int indexOf(Object o) {
            Node<T> current = head;
            int index = 0;
            while (current != null) {
                if (Objects.equals(current.data, o)) return index;
                current = current.next;
                index++;
            }
            return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    Node<T> getHead() { return head; }
    Node<T> getTail() { return tail; }
}
