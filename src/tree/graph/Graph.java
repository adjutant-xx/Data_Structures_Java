package tree.graph;

import tree.graph.GraphNode;
import util.Constants;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

    // add vertex:
    public boolean addVertex(GraphNode<T> node) throws Exception {
        try {
            if(!this.adjacencyMap.containsKey(node)) {
                this.adjacencyMap.put(node, new HashSet<>());
                this.numVertices++;
                return true;
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    // remove vertex:
    public boolean removeVertex(GraphNode<T> node) throws Exception {
        try {
            if(this.adjacencyMap.containsKey(node)) {
                this.adjacencyMap.remove(node);
                for(Map.Entry<GraphNode<T>, HashSet<GraphNode<T>>> entry : this.adjacencyMap.entrySet()) {
                    if(entry.getValue().contains(node)) {
                        this.adjacencyMap.get(entry.getKey()).remove(node);
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

    // add edge
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

    // remove edge
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

    // is adjacent?
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

    // contains vertex:
    public boolean containsVertex(GraphNode<T> node) throws Exception {
        try {
            if(this.adjacencyMap.containsKey(node)) {
                return true;
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    // get neighbors
    public HashSet<GraphNode<T>> getNeighbors(GraphNode<T> node) throws Exception {
        try {
            return this.adjacencyMap.get(node);
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    // get num vertices
    public int getNumVertices() throws Exception {
        try {
            return this.numVertices;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    // get num edges:
    public int getNumEdges() throws Exception {
        try {
            return this.numEdges;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

}
