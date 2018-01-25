package tree.graph;

import list.queue.Queue;
import list.stack.Stack;
import util.Constants;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Contains operational implementations for the Graph data structure.
 */
public class Graph<T> {

    private HashMap<GraphNode<T>, HashSet<GraphNode<T>>> adjacencyMap;
    private int numVertices;
    private int numEdges;
    private final String type = Constants.DIRECTED;
    private final boolean weighted = false;

    public Graph() {
        this.adjacencyMap = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     * @param vertex vertex to add.
     * @return true if vertex was added successfully, false if otherwise.
     * @throws Exception
     */
    public boolean addVertex(GraphNode<T> vertex) throws Exception {
        try {
            if(!this.adjacencyMap.containsKey(vertex)) {
                this.adjacencyMap.put(vertex, new HashSet<>());
                this.numVertices++;
                return true;
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Removes a specified vertex from the graph.
     * @param vertex vertex to remove.
     * @return true if vertex was removed successfully, false if otherwise.
     * @throws Exception
     */
    public boolean removeVertex(GraphNode<T> vertex) throws Exception {
        try {
            if(this.adjacencyMap.containsKey(vertex)) {
                this.adjacencyMap.remove(vertex);
                for(Map.Entry<GraphNode<T>, HashSet<GraphNode<T>>> entry : this.adjacencyMap.entrySet()) {
                    if(entry.getValue().contains(vertex)) {
                        this.adjacencyMap.get(entry.getKey()).remove(vertex);
                    }
                }
                this.numVertices--;
                return true;
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Adds an edge between two vertices to the graph.
     * @param x source vertex of edge to add.
     * @param y destination vertex of edge to add.
     * @return true if the edge was added successfully, false if otherwise.
     * @throws Exception
     */
    public boolean addEdge(GraphNode<T> x, GraphNode<T> y) throws Exception {
        try {
            if(this.adjacencyMap.containsKey(x)) {
                if(!this.adjacencyMap.get(x).contains(y)) {
                    this.adjacencyMap.get(x).add(y);
                    this.numEdges++;
                    return true;
                }
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Removes a specified edge between two vertices from the graph, if it already exists.
     * @param x source vertex of edge to remove.
     * @param y destination vertex of edge to remove.
     * @return true if the edge was removed successfully, false if otherwise.
     * @throws Exception
     */
    public boolean removeEdge(GraphNode<T> x, GraphNode<T> y) throws Exception {
        try {
            if(this.adjacencyMap.containsKey(x)) {
                if(this.adjacencyMap.get(x).contains(y)) {
                    this.adjacencyMap.get(x).remove(y);
                    this.numEdges--;
                    return true;
                }
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Determines if two vertices are adjacent (or, if an edge exists between them).
     * @param x source vertex.
     * @param y destination vertex.
     * @return true if both vertices are adjacent, false if otherwise.
     * @throws Exception
     */
    public boolean isAdjacent(GraphNode<T> x, GraphNode<T> y) throws Exception {
        try {
            HashSet<GraphNode<T>> adjacencySet = this.adjacencyMap.get(x);
            if(adjacencySet != null) {
                if(adjacencySet.contains(y)) {
                    return true;
                }
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Determines if graph contains a given vertex or not.
     * @param vertex vertex to search.
     * @return true if the graph contains the vertex, false if otherwise.
     * @throws Exception
     */
    public boolean containsVertex(GraphNode<T> vertex) throws Exception {
        try {
            if(this.adjacencyMap.containsKey(vertex)) {
                return true;
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Returns a HashSet containing all neighbors of a given vertex (or, all vertices with which the vertex shares an edge).
     * @param vertex vertex to search.
     * @return a HashSet containing all neighbors of the vertex.
     * @throws Exception
     */
    public HashSet<GraphNode<T>> getNeighbors(GraphNode<T> vertex) throws Exception {
        try {
            return this.adjacencyMap.get(vertex);
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Determines whether or not a path exists between two nodes, using Depth-First Search.
     * Uses a wrapper method to initialize objects required for search traversal.
     * @param source source node to be used in search.
     * @param destination destination node to be used in search.
     * @return true if a path exists between source and destination nodes, false if otherwise.
     * @throws Exception
     */
    public boolean depthFirstSearch(GraphNode<T> source, GraphNode<T> destination) throws Exception {
        Stack<GraphNode<T>> stack = new Stack<>();
        stack.push(source);
        return depthFirstSearch(stack, destination);
    }
    private boolean depthFirstSearch(Stack<GraphNode<T>> stack, GraphNode<T> destination) throws Exception {
        try {
            HashMap<GraphNode<T>, VisitStatus> visited = new HashMap<>();
            while(!stack.isEmpty()) {
                GraphNode<T> current = stack.pop();
                visited.put(current, VisitStatus.Visiting);
                if(current.equals(destination)) {
                    return true;
                }
                for(GraphNode<T> neighbor : this.adjacencyMap.get(current)) {
                    if(visited.containsKey(neighbor)) {
                        if(visited.get(neighbor).equals(VisitStatus.Unvisited)) {
                            stack.push(neighbor);
                        }
                    } else {
                        stack.push(neighbor);
                    }
                }
                visited.put(current, VisitStatus.Visited);
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Determines whether or not a path exists between two nodes, using Breadth-First Search.
     * Uses a wrapper method to initialize objects required for search traversal.
     * @param source source node to be used in search.
     * @param destination destination node to be used in search.
     * @return true if a path exists between source and destination nodes, false if otherwise.
     * @throws Exception
     */
    public boolean breadthFirstSearch(GraphNode<T> source, GraphNode<T> destination) throws Exception {
        Queue<GraphNode<T>> queue = new Queue<>();
        queue.enqueue(source);
        return breadthFirstSearch(queue, destination);
    }
    private boolean breadthFirstSearch(Queue<GraphNode<T>> queue, GraphNode<T> destination) throws Exception {
        try {
            HashMap<GraphNode<T>, VisitStatus> visited = new HashMap<>();
            while(!queue.isEmpty()) {
                GraphNode<T> current = queue.dequeue();
                visited.put(current, VisitStatus.Visiting);
                if(current.equals(destination)) {
                    return true;
                }
                for(GraphNode<T> neighbor : this.adjacencyMap.get(current)) {
                    if(visited.containsKey(neighbor)) {
                        if(visited.get(neighbor).equals(VisitStatus.Unvisited)) {
                            queue.enqueue(neighbor);
                        }
                    } else {
                        queue.enqueue(neighbor);
                    }
                }
                visited.put(current, VisitStatus.Visited);
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Returns the number of vertices within the graph.
     * @return an integer representing number of vertices contained within the graph.
     * @throws Exception
     */
    public int getNumVertices() throws Exception {
        try {
            return this.numVertices;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Returns the number of edges within the graph.
     * @return an integer representing number of edges contained within the graph.
     * @throws Exception
     */
    public int getNumEdges() throws Exception {
        try {
            return this.numEdges;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

}
