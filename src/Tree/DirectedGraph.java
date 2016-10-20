// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package Tree;

import HashTable.HashTable;
import LinkedList.LinkedList;
import LinkedList.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collection;

/*
* SUMMARY:  Represents a Directed Graph data structure.
*           Utilizes a native Java HashMap to contain a list of all vertices within the graph.
*
* NOTE:     This class is currently under construction, as of 10-18-2016.
* */
public class DirectedGraph<T> {

    private ArrayList<GraphNode<T>> _graph;
    private int _size;

    /*
    * SUMMARY:  Default constructor, initializes the graph to an empty HashMap.
    * */
    public DirectedGraph(){
        _graph = new ArrayList<GraphNode<T>>();
        _size = 0;
    }

    /*
    * SUMMARY:  Returns the number of values present within the graph.
    * */
    public int getSize(){
        return _size;
    }

    /*
    * SUMMARY:  Returns a vertex of the graph given a specific index
    *           The 'index' parameter is zero-based.
    * */
    public GraphNode<T> getVertex(int index){
        if(index < 0 || index >= _size){
            return null;
        }
        return _graph.get(index);
    }

    /*
    * SUMMARY:  Inserts a new vertex and it's associated value into the graph.
    * */
    public void addVertex(T value){
        _graph = addVertex(value, _graph);
    }
    private ArrayList<GraphNode<T>> addVertex(T value, ArrayList<GraphNode<T>> graph){
        GraphNode<T> newNode = new GraphNode<T>(value);
        graph.add(newNode);
        _size++;
        return graph;
    }

    /*
    * SUMMARY:  Adds an edge to the graph, provided two vertices.
    *           Edge is only added to the graph if the parent vertex can be found (edges are single-directional).
    * */
    public void addEdge(GraphNode<T> p, GraphNode<T> c){
        _graph = addEdge(p, c, _graph);
    }
    private ArrayList<GraphNode<T>> addEdge(GraphNode<T> parent, GraphNode<T> child, ArrayList<GraphNode<T>> graph){
        if(graph.contains(parent)){
            int index = graph.lastIndexOf(parent);
            GraphNode<T> parentObject = graph.get(index);

            // Add edge only if parent node is either empty or does not already contain an edge to the child node
            if(parentObject.getChildren().size() < 1 || !parentObject.getChildren().contains(child)){
                parentObject.addChild(child);
                graph.set(index, parentObject);
            }
        }
        return graph;
    }

    /*
    * SUMMARY:  Removes a vertex from the graph, if it can be found within the graph.
    * */
    public void removeVertex(GraphNode<T> vertex){
        _graph = removeVertex(vertex, _graph);
    }
    private ArrayList<GraphNode<T>> removeVertex(GraphNode<T> vertexDelete, ArrayList<GraphNode<T>> graph){
        // If graph does contain the vertex in question, remove it's references from all edges upon removal of the vertex itself:
        if(graph.contains(vertexDelete)){
            for(GraphNode<T> node : graph){
                if(node.getChildren().contains(vertexDelete)){
                    node.getChildren().remove(vertexDelete);
                }
            }
            _size--;
            graph.remove(vertexDelete);
        }
        return graph;
    }

    /*
    * SUMMARY:  Removes an edge from the graph, if the graph contains both parent and child vertices.
    * */
    public void removeEdge(GraphNode<T> p, GraphNode<T> c){
        _graph = removeEdge(p,c, _graph);
    }
    private ArrayList<GraphNode<T>> removeEdge(GraphNode<T> parent, GraphNode<T> child, ArrayList<GraphNode<T>> graph){
        if(graph.contains(parent)){
            if(parent.getChildren().contains(child)){
                parent.getChildren().remove(child);
            }
        }
        return graph;
    }

    /*
    * SUMMARY:  Determines if two vertices are adjacent to each other, via either an upstream or downstream edge.
    *           Returns true if the vertices are neighbors, false if they are not or cannot be found within the graph.
    * */
    public boolean isAdjacent(GraphNode<T> x, GraphNode<T> y){ // checks to see whether a single edge exists between the two nodes, in either direction
        if(!_graph.contains(x) || !_graph.contains(y)){
            return false;
        }
        if(x.getChildren().contains(y) || y.getChildren().contains(x)){
            return true;
        }
        return false;
    }

    /*
    * SUMMARY:  Returns an ArrayList object of vertices that describe all the neighbors of a given vertex.
    *           A vertex is considered a neighbor if it has an upstream or downstream edge connected to the other
    *               vertex in question.
    * */
    public ArrayList<GraphNode<T>> getNeighbors(GraphNode<T> vertex){ // gets a list of all neighbors of a given vertex, defined as having an edge that connects the vertex to/from another neighbor
        ArrayList<GraphNode<T>> neighbors = new ArrayList<GraphNode<T>>();
        for(GraphNode<T> node : vertex.getChildren()){ // first, add all direct neighbors from list of target vertex's children
            neighbors.add(node);
        }
        for(GraphNode<T> node : _graph){ // next, check all other vertices within the graph to see if they have any connection to the target vertex
            if(node.getChildren().contains(vertex)){
                neighbors.add(node);
            }
        }
        return neighbors;
    }

    /*
    * SUMMARY:  Traverses the graph using a Depth First Search algorithm, determines if a path exists between
    *               two nodes.
    * NOTE:     This method is currently under construction as of 10-18-2016.
    * */
    public boolean depthFirstSearch(){ // return a node matching the search value, if it is present within the graph
        // DFS pseudocode:
        // --> visit a node and iterate through all of its neighbors; exhaustively search through each neighbor's neighbors, etc, until moving onto other neighbors.
//        void search(Node root){
//            if(root == null){
//                return;
//            }
//            visit(root);
//            root.visited = true;
//            for each(Node n in root.adjacent){
//                if(n.visited == false){
//                    search(n);
//                }
//            }
//        }
        return false;
    }

    /*
    * SUMMARY:  Traverses the graph using a Breadth First Search algorithm, determines if a path exists between
    *               two nodes.
    * NOTE:     This method is currently under construction as of 10-19-2016.
    * */
    public boolean breadthFirstSearch(GraphNode<T> a, GraphNode<T> b){
        return breadthFirstSearch(a, b, _graph);
    }
    private boolean breadthFirstSearch(GraphNode<T> a, GraphNode<T> b, ArrayList<GraphNode<T>> graph){
        // BFS pseudocode:
        // -->a node visits each of it's own neighbors before visiting any of it's childrens neighbors.
//        void search(Node root){
//            Queue queue = new Queue();
//            root.marked = true;
//            queue.enqueue(root); // Add to the end of the queue.
//
//            while(!queue.isEmpty()){
//                Node r = queue.dequeue(); // remove from the front of the queue
//                visit(r);
//                foreach(Node n in r.adjacent){
//                    if(n.marked == false){
//                        n.marked = true;
//                        queue.enqueue(n);
//                    }
//                }
//            }
//        }
        if(!graph.contains(a) || !graph.contains(b)){
            return false;
        }

        Queue<GraphNode<T>> queue = new Queue<GraphNode<T>>();
        queue.enqueue(a);
        GraphNode<T> temp;
        while(!queue.isEmpty()) {
            temp = queue.dequeue();
            if (temp != null) {
                for (GraphNode<T> child : temp.getChildren()) {
                    if (child.getVisitState() == false) {
                        if (child == b) {
                            return true;
                        } else {
                            child.setVisitState(true);
                            queue.enqueue(child);
                        }
                    }
                }
                temp.setVisitState(true);
            }
        }
        return false;
    }
}

// NOTE: CtCI Graph/GraphNode/BFS code for reference:
//package Test;
//
//        import javafx.util.Pair;
//
//        import java.io.*;
//        import java.lang.reflect.Array;
//
//        import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Graph g = createNewGraph();
//        Node[] n = g.getNodes();
//        Node start = n[3];
//        Node end = n[5];
//        System.out.println(search(g, start, end));
//
//    }
//
//    public static boolean search(Graph g,Node start,Node end) {
//        LinkedList<Node> q = new LinkedList<Node>();
//        for (Node u : g.getNodes()) {
//            u.state = State.Unvisited;
//        }
//        start.state = State.Visiting;
//        q.add(start);
//        Node u;
//        while(!q.isEmpty()) {
//            u = q.removeFirst();
//            if (u != null) {
//                for (Node v : u.getAdjacent()) {
//                    if (v.state == State.Unvisited) {
//                        if (v == end) {
//                            return true;
//                        } else {
//                            v.state = State.Visiting;
//                            q.add(v);
//                        }
//                    }
//                }
//                u.state = State.Visited;
//            }
//        }
//        return false;
//    }
//
//
//    public static class Graph {
//        public int MAX_VERTICES = 6;
//        private Node vertices[];
//        public int count;
//        public Graph() {
//            vertices = new Node[MAX_VERTICES];
//            count = 0;
//        }
//
//        public void addNode(Node x) {
//            if (count < vertices.length) {
//                vertices[count] = x;
//                count++;
//            } else {
//                System.out.print("Graph full");
//            }
//        }
//
//        public Node[] getNodes() {
//            return vertices;
//        }
//    }
//
//    public static class Node {
//        private Node adjacent[];
//        public int adjacentCount;
//        private String vertex;
//        public State state;
//        public Node(String vertex, int adjacentLength) {
//            this.vertex = vertex;
//            adjacentCount = 0;
//            adjacent = new Node[adjacentLength];
//        }
//
//        public void addAdjacent(Node x) {
//            if (adjacentCount < adjacent.length) {
//                this.adjacent[adjacentCount] = x;
//                adjacentCount++;
//            } else {
//                System.out.print("No more adjacent can be added");
//            }
//        }
//        public Node[] getAdjacent() {
//            return adjacent;
//        }
//        public String getVertex() {
//            return vertex;
//        }
//    }
//
//    public enum State {
//        Unvisited, Visited, Visiting;
//    }
//
//    public static Graph createNewGraph()
//    {
//        Graph g = new Graph();
//        Node[] temp = new Node[6];
//
//        temp[0] = new Node("a", 3);
//        temp[1] = new Node("b", 0);
//        temp[2] = new Node("c", 0);
//        temp[3] = new Node("d", 1);
//        temp[4] = new Node("e", 1);
//        temp[5] = new Node("f", 0);
//
//        temp[0].addAdjacent(temp[1]);
//        temp[0].addAdjacent(temp[2]);
//        temp[0].addAdjacent(temp[3]);
//        temp[3].addAdjacent(temp[4]);
//        temp[4].addAdjacent(temp[5]);
//        for (int i = 0; i < 6; i++) {
//            g.addNode(temp[i]);
//        }
//        return g;
//    }
//
//}



