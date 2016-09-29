package Tree;

public class Node<T> {

    public Node(){}

    public Node(T v){
        value = v;
    }

    public T value;
    public Node<T>[] children;
}
