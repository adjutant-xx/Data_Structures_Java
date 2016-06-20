package LinkedList;

public class Node {
    private Object value;
    public Node next;

    public Node(Object v) {
        value = v;
    }

    public Object getValue() {
        return value;
    }
}