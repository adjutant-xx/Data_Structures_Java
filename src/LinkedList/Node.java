package LinkedList;

public class Node<T> {
    private T value;
    public Node<T> next;

    public Node(T v) {
        value = v;
    }

    public T getValue() {
        return value;
    }
}