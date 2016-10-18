package Tree;

import HashTable.HashTable;
import LinkedList.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collection;

public class DirectedGraph<T> {

    private HashMap<T, GraphNode<T>> graph;

    public DirectedGraph(){
        graph = new HashMap<T, GraphNode<T>>();
    }

    public void addVertex(T value){
        graph = addVertex(value, graph);
    }

    private HashMap<T, GraphNode<T>> addVertex(T value, HashMap<T, GraphNode<T>> graph){
        if(graph.containsKey(value)){ // graph can only contain one copy of a given value
            return graph;
        }
        GraphNode<T> newNode = new GraphNode<T>(value);
        graph.put(value,newNode);
        return graph;
    }

    public GraphNode<T> getVertex(T value){ // return the vertex corresponding to a given value:
        return graph.get(value);
    }

    public void addEdge(GraphNode<T> p, GraphNode<T> c){
        graph = addEdge(p, c, graph);
    }

    private HashMap<T, GraphNode<T>> addEdge(GraphNode<T> parent, GraphNode<T> child, HashMap<T,GraphNode<T>> graph){
        if(graph.containsValue(parent)){ // Check to see if graph already contains the parent node
            GraphNode<T> parentObject = graph.get(parent.data);

            if(parentObject.children == null || !parentObject.children.contains(child)){ // if directed graph does not already contain an edge from parent to child, create one:
                parentObject.children.add(child);
                graph.put(parentObject.data, parentObject);
            }
        }
        return graph;
    }

    public void removeVertex(GraphNode<T> vertex){
        graph = removeVertex(vertex, graph);
    }

    private HashMap<T,GraphNode<T>> removeVertex(GraphNode<T> vertex, HashMap<T,GraphNode<T>> graph){
        if(graph.containsKey(vertex.data)){ // if graph does contain the vertex in question, remove it's references from all edges upon removal of the vertex itself:
            for(T key : graph.keySet()){
                GraphNode<T> value = graph.get(key);
                HashSet<GraphNode<T>> mutableChildren = value.children;
                if(mutableChildren.remove(vertex)){
                    value.children = mutableChildren;
                    graph.put(key, value);
                }
            }
            graph.remove(vertex.data);
        }
        return graph;
    }

    public void removeEdge(GraphNode<T> p, GraphNode<T> c){
        graph = removeEdge(p,c, graph);
    }

    private HashMap<T,GraphNode<T>> removeEdge(GraphNode<T> parent, GraphNode<T> child, HashMap<T, GraphNode<T>> graph){
        if(graph.containsKey(parent.data)){
            HashSet<GraphNode<T>> mutableChildren = graph.get(parent.data).children;
            if(mutableChildren.remove(child)){
                parent.children = mutableChildren;
                graph.put(parent.data, parent);
            }
        }
        return graph;
    }

    public boolean isAdjacent(GraphNode<T> x, GraphNode<T> y){ // checks to see whether a single edge exists between the two nodes, in either direction
        if(!graph.containsKey(x.data) || !graph.containsKey(y.data)){
            return false;
        }
        if(x.children.contains(y) || y.children.contains(x)){
            return true;
        }
        return false;
    }

    public ArrayList<GraphNode<T>> getNeighbors(GraphNode<T> vertex){ // gets a list of all neighbors of a given vertex, defined as having an edge that connects the vertex to/from another neighbor
        ArrayList<GraphNode<T>> neighbors = new ArrayList<GraphNode<T>>();
        for(GraphNode<T> item : vertex.children){ // first, add all direct neighbors from list of target vertex's children
            neighbors.add(item);
        }
        for(GraphNode<T> item : graph.values()){ // next, check all other vertices within the graph to see if they have any connection to the target vertex
            if(item.children.contains(vertex)){
                neighbors.add(item);
            }
        }
        return neighbors;
    }

    public boolean depthFirstSearchQuery(T term){
        HashMap<T, GraphNode<T>> tempGraph = graph;
        for(GraphNode<T> node : tempGraph.values()){
            if(depthFirstSearchQuery(term, node)){
                return true;
            }
        }
        return false;
    }

    private boolean depthFirstSearchQuery(T term, GraphNode<T> node){ // return a node matching the search value, if it is present within the graph
        if(node.data == term){
            return true;
        }
        node.visited = true;
        for(GraphNode<T> child : node.children){
            if(child.visited == false){
                return depthFirstSearchQuery(term, child);
            }
        }
        return false;
    }
}