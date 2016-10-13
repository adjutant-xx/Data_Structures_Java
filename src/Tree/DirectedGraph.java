package Tree;

import HashTable.HashTable;
import java.util.HashMap;
import java.util.HashSet;

public class DirectedGraph<T> {

    private HashMap<T, Node<T>> graph;

    public DirectedGraph(){
        graph = new HashMap<T, Node<T>>();
    }

    public void addVertex(T value){
        graph = addVertex(value, graph);
    }

    private HashMap<T, Node<T>> addVertex(T value, HashMap<T, Node<T>> graph){
        if(graph.containsKey(value)){ // graph can only contain one copy of a given value
            return graph;
        }
        Node<T> newNode = new Node<T>(value);
        graph.put(value,newNode);
        return graph;
    }

    public Node<T> getVertex(T value){ // return the vertex corresponding to a given value:
        return graph.get(value);
    }

    public void addEdge(Node<T> p, Node<T> c){
        graph = addEdge(p, c, graph);
    }

    private HashMap<T, Node<T>> addEdge(Node<T> parent, Node<T> child, HashMap<T,Node<T>> graph){
        if(graph.containsValue(parent)){ // Check to see if graph already contains the parent node
            Node<T> parentObject = graph.get(parent.data);

            if(parentObject.children == null || !parentObject.children.contains(child)){ // if directed graph does not already contain an edge from parent to child, create one:
                parentObject.children.add(child);
                graph.put(parentObject.data, parentObject);
            }
        }
        return graph;
    }

    public void deleteVertex(Node<T> vertex){
        graph = deleteVertex(vertex, graph);
    }

    private HashMap<T,Node<T>> deleteVertex(Node<T> vertex, HashMap<T,Node<T>> graph){
        if(graph.containsKey(vertex)){ // if graph does contain the vertex in question, remove it's references from all edges upon removal of the vertex itself:
            for(T key : graph.keySet()){
                Node<T> value = graph.get(key);
                HashSet<Node<T>> mutableChildren = value.children;
                if(mutableChildren.remove(vertex)){
                    value.children = mutableChildren;
                    graph.put(key, value);
                }
            }
            graph.remove(vertex);
        }
        return graph;
    }

    public void deleteEdge(Node<T> p, Node<T> c){
        graph = deleteEdge(p,c, graph);
    }

    private HashMap<T,Node<T>> deleteEdge(Node<T> parent, Node<T> child, HashMap<T, Node<T>> graph){
        if(graph.containsKey(parent.data)){
            HashSet<Node<T>> mutableChildren = graph.get(parent.data).children;
            if(mutableChildren.remove(child)){
                parent.children = mutableChildren;
                graph.put(parent.data,parent);
            }
        }
        return graph;
    }
}