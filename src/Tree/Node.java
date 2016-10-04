package Tree;

public class Node<T> {

    public Node(){}

    public Node(T v){
        data = v;
    }

    public T data;
    public Node<T>[] children;


}
