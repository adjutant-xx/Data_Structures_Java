package Tree;

import HashTable.HashTable;

import java.util.HashMap;
import java.util.HashSet;

public class DirectedGraph<T> {

    private HashMap<Node<T>, Node<T>> graph;
    //private int hashKey;

    public DirectedGraph(){
        graph = new HashMap<Node<T>, Node<T>>();
        //hashKey = 0;
    }


    public void addVertex(T value){
        Node n = new Node(value);
        graph = addVertex(n, graph);
    }

    private HashMap<Node<T>, Node<T>> addVertex(Node<T> vertex, HashMap<Node<T>, Node<T>> graph){
        if(graph.containsKey(vertex)){
            return graph;
        }

        graph.put(vertex,vertex);

        return graph;
    }

}
