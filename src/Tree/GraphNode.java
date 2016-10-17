package Tree;

import java.util.HashSet;

public class GraphNode<T> extends Node<T> {

    public GraphNode(T v){
        data = v;
        children = new HashSet<GraphNode<T>>();
        explored = false;
    };

    HashSet<GraphNode<T>> children;
    public boolean explored;

}
