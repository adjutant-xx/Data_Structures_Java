package Tree;

import java.util.HashSet;

public class Node<T> {

    public Node(){}

    public Node(T v){
        data = v;
    }

    public T data;
    public HashSet<Node<T>> children;


}
