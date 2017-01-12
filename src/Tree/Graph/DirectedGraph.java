// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/mpaauw
//
// No license, free use

package Tree.Graph;

import List.Queue.Queue;

import java.util.ArrayList;

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
    * */
    public boolean depthFirstSearchPath(GraphNode<T> source, GraphNode<T> destination){

        // Use temp variables to preserve the state of the graph, since we are only conducting a search:
        ArrayList<GraphNode<T>> tempGraph = _graph;
        GraphNode<T> tempSource = source;
        GraphNode<T> tempDestination = destination;
        return depthFirstSearchPath(tempSource, tempDestination, tempGraph);
    }
    private boolean depthFirstSearchPath(GraphNode<T> source, GraphNode<T> destination, ArrayList<GraphNode<T>> graph){
        if(!graph.contains(source) || !graph.contains(destination)){
            return false;
        }
        if(source == destination){
            return true;
        }

        source.setVisitState(true);
        for(GraphNode<T> node : source.getChildren()){
            if(node == null){
                return false;
            }
            if(node == destination){
                return true;
            }
            node.setVisitState(true);
            for(GraphNode<T> child : node.getChildren()){
                if(child.getVisitState() == false){
                    return depthFirstSearchPath(child, destination, graph);
                }
            }
        }
        return false;
    }

    /*
    * SUMMARY:  Traverses the graph using a Depth First Search algorithm, prints each graph node to the console in the order they are visited.
    * */
    public void depthFirstSearchTraversal(GraphNode<T> source){
        
    }

    /*
    * SUMMARY:  Traverses the graph using a Breadth First Search algorithm, determines if a path exists between
    *               two nodes.
    * */
    public boolean breadthFirstSearchPath(GraphNode<T> source, GraphNode<T> destination){
        return breadthFirstSearchPath(source, destination, _graph);
    }
    private boolean breadthFirstSearchPath(GraphNode<T> source, GraphNode<T> destination, ArrayList<GraphNode<T>> graph){
        if(!graph.contains(source) || !graph.contains(destination)){
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
                    if (child.getVisitState() == false) {
                        if (child == destination) {
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
