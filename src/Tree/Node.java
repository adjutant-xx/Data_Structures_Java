package Tree;

import java.util.HashSet;

public class Node<T> {

    public Node(){}

    public Node(T v){
        data = v;
        children = new HashSet<Node<T>>();
    }

    public T data;
    public HashSet<Node<T>> children;
}
