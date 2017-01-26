// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/mpaauw
//
// No license, free use

package Tree.Graph;

import List.Queue.Queue;
import List.Stack.Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
* SUMMARY:  Represents a Directed Graph data structure.
*           Utilizes a native Java ArrayList to contain a list of all vertices within the graph.
*
* NOTE:     This class is currently under construction, as of 10-18-2016.
* */
public class Graph<T> {
    public enum VisitState {
        Unvisited, Visiting, Visited
    }
    private HashMap<T, GraphNode<T>> _graph;
    private int _size;

    /*
    * SUMMARY:  Default constructor, initializes the graph to an empty HashMap.
    * */
    public Graph(){
        _graph = new HashMap<T, GraphNode<T>>();
        _size = 0;
    }

    /*
    * SUMMARY:  Returns the number of values present within the graph.
    * */
    public int getSize(){
        return _size;
    }

    /*
    * SUMMARY:  Returns a vertex of the graph given a specific key.
    * */
    public GraphNode<T> getVertex(T key){
        if(_graph.containsKey(key)){
            return _graph.get(key);
        }
        return null;
    }

    /*
    * SUMMARY:  Returns a HashMap object containing each vertex present in the graph.
    * */
    public HashMap<T, GraphNode<T>> getVertices(){
        return _graph;
    }

    /*
    * SUMMARY:  Inserts a new vertex and it's associated value into the graph.
    *           Returns true if insertion was successful, false if otherwise.
    * */
    public boolean addVertex(T value){
        return addVertex(value, _graph);
    }
    private boolean addVertex(T value, HashMap<T, GraphNode<T>> graph){
        try{
            GraphNode<T> newNode = new GraphNode<T>(value);
            graph.put(value, newNode);
            _size++;
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    /*
    * SUMMARY:  Adds an edge to the graph, provided two vertices.
    *           Edge is only added to the graph if the parent vertex can be found (edges are single-directional).
    * */
    public boolean addEdge(T parentValue, T childValue){
        return addEdge(parentValue, childValue, _graph);
    }
    private boolean addEdge(T parentValue, T childValue, HashMap<T, GraphNode<T>> graph){
        try{
            if(graph.containsValue(_graph.get(parentValue))){
                GraphNode<T> parentObject = graph.get(parentValue);
                if(parentObject.getChildren().size() < 1 || !parentObject.getChildren().contains(childValue)){
                    GraphNode<T> newChild = _graph.get(childValue);
                    parentObject.addChild(newChild);
                    return true;
                }
            }
            return false;
        }
        catch(Exception ex){
            return false;
        }
    }

    /*
    * SUMMARY:  Removes a vertex from the graph, if it can be found within the graph.
    * */
    public boolean removeVertex(T vertexValue){
        return removeVertex(vertexValue, _graph);
    }
    private boolean removeVertex(T vertexValue, HashMap<T, GraphNode<T>> graph){
        try{
            if(graph.containsKey(vertexValue)){
                for(Map.Entry<T, GraphNode<T>> node : graph.entrySet()){
                    GraphNode<T> data = node.getValue();
                    if(data.getChildren().contains(vertexValue)){
                        data.getChildren().remove(vertexValue);
                    }
                }
                _size--;
                graph.remove(vertexValue);
                return true;
            }
            return false;
        }
        catch(Exception ex){
            return false;
        }
    }

    /*
    * SUMMARY:  Removes an edge from the graph, if the graph contains both parent and child vertices.
    * */
    public boolean removeEdge(T parentValue, T childValue){
        return removeEdge(parentValue, childValue, _graph);
    }
    private boolean removeEdge(T parentValue, T childValue, HashMap<T, GraphNode<T>> graph){
        try{
            if(!graph.containsKey(parentValue) || !graph.containsKey(childValue)){
                return false;
            }
            GraphNode<T> parent = graph.get(parentValue);
            GraphNode<T> child = graph.get(childValue);
            ArrayList<GraphNode<T>> children = parent.getChildren();
            children.remove(child);
            parent.setChildren(children);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    /*
    * SUMMARY:  Determines if two vertices are adjacent to each other, via either a directed or undirected edge.
    *           Returns true if the vertices are neighbors, false if they are not or cannot be found within the graph.
    * */
    public boolean isAdjacent(T x, T y){ // checks to see whether a single edge exists between the two nodes, in either direction
        if(!_graph.containsKey(x) || !_graph.containsKey(y)){
            return false;
        }
        GraphNode<T> xNode = _graph.get(x);
        GraphNode<T> yNode = _graph.get(y);
        if(xNode.getChildren().contains(yNode) || yNode.getChildren().contains(xNode)){
            return true;
        }
        return false;
    }

    /*
    * SUMMARY:  Returns an ArrayList object of vertices that describe all the neighbors of a given vertex.
    *           A vertex is considered a neighbor if it has an upstream or downstream edge connected to the other
    *               vertex in question.
    * */
    public ArrayList<GraphNode<T>> getNeighbors(T vertexValue){ // gets a list of all neighbors of a given vertex, defined as having an edge that connects the vertex to/from another neighbor
        ArrayList<GraphNode<T>> neighbors = new ArrayList<GraphNode<T>>();
        GraphNode<T> vertex = _graph.get(vertexValue);
        for(GraphNode<T> node : vertex.getChildren()){ // first, add all direct neighbors from list of target vertex's children
            neighbors.add(node);
        }
        for(GraphNode<T> node : _graph.values()){ // next, check all other vertices within the graph to see if they have any connection to the target vertex
            if(node.getChildren().contains(vertex)){
                neighbors.add(node);
            }
        }
        return neighbors;
    }

    /*
    * SUMMARY:  Traverses the graph using a Depth First Search algorithm, determines if a path exists between
    *               two nodes.
    * */
    public boolean depthFirstSearchPath(T sourceValue, T destinationValue){
        HashMap<T, GraphNode<T>> tempGraph = _graph;
        GraphNode<T> sourceNode = _graph.get(sourceValue);
        GraphNode<T> destinationNode = _graph.get(destinationValue);
        return depthFirstSearchPath(sourceNode, destinationNode, tempGraph);
    }
    private boolean depthFirstSearchPath(GraphNode<T> source, GraphNode<T> destination, HashMap<T, GraphNode<T>> graph){
        if(!graph.containsValue(source) || !graph.containsValue(destination)){
            return false;
        }
        if(source == destination){
            return true;
        }

        source.setVisitState(VisitState.Visited);
        for(GraphNode<T> node : source.getChildren()){
            if(node == null){
                return false;
            }
            if(node == destination){
                return true;
            }
            node.setVisitState(VisitState.Visited);
            for(GraphNode<T> child : node.getChildren()){
                if(child.getVisitState() == VisitState.Unvisited){
                    return depthFirstSearchPath(child, destination, graph);
                }
            }
        }
        return false;
    }

    /*
    * SUMMARY:  Traverses the graph using a Depth First Search algorithm, returns an ArrayList of graph nodes ordered by their appearance during traversal.
    * */
    public ArrayList<GraphNode<T>> depthFirstSearchTraversal(){
        HashMap<T, GraphNode<T>> tempGraph = _graph;
        Stack<GraphNode<T>> stack = new Stack();
        ArrayList<GraphNode<T>> nodes = new ArrayList<>();
        for(int i = 0; i < tempGraph.size(); i++){
            GraphNode<T> currentNode = tempGraph.get(i);
            if(tempGraph.get(i).getVisitState() == VisitState.Unvisited){
                stack.push(currentNode);
                depthFirstSearchTraversal(stack, nodes);
            }
        }
        return nodes;
    }
    public ArrayList<GraphNode<T>> depthFirstSearchTraversal(Stack<GraphNode<T>> stack, ArrayList<GraphNode<T>> nodes){
        while(!stack.isEmpty()){
            GraphNode<T> currentNode = stack.pop();
            if(currentNode.getVisitState() == VisitState.Visited){
                return nodes;
            }
            nodes.add(currentNode);
            currentNode.setVisitState(VisitState.Visited);
            for(GraphNode<T> child : currentNode.getChildren()){
                stack.push(child);
                return depthFirstSearchTraversal(stack, nodes);
            }
        }
        return nodes;
    }

    /*
    * SUMMARY:  Traverses the graph using a Breadth First Search algorithm, determines if a path exists between
    *               two nodes.
    * */
    public boolean breadthFirstSearchPath(T sourceValue, T destinationValue){
        HashMap<T, GraphNode<T>> tempGraph = _graph;
        GraphNode<T> sourceNode = _graph.get(sourceValue);
        GraphNode<T> destinationNode = _graph.get(destinationValue);
        return breadthFirstSearchPath(sourceNode, destinationNode, _graph);
    }
    private boolean breadthFirstSearchPath(GraphNode<T> source, GraphNode<T> destination, HashMap<T, GraphNode<T>> graph){
        if(!graph.containsValue(source) || !graph.containsValue(destination)){
            return false;
        }
        if(source == destination){
            return true;
        }
        Queue<GraphNode<T>> queue = new Queue<GraphNode<T>>();
        queue.enqueue(source);
        while(!queue.isEmpty()) {
            GraphNode<T> temp = queue.dequeue();
            if (temp != null) {
                for (GraphNode<T> child : temp.getChildren()) {
                    if (child.getVisitState() == VisitState.Unvisited) {
                        if (child == destination) {
                            return true;
                        } else {
                            child.setVisitState(VisitState.Visited);
                            queue.enqueue(child);
                        }
                    }
                }
                temp.setVisitState(VisitState.Visited);
            }
        }
        return false;
    }

    /*
    * SUMMARY:  Traverses the graph using a Breadth First Search algorithm, prints each graph node to the console in the order they are visited.
    * */
    public void breadthFirstSearchTraversal(GraphNode<T> node){
        GraphNode<T> tempNode = node;
        Queue<GraphNode<T>> queue = new Queue();
    }
}
