// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package Tree;

import java.util.HashSet;

/*
* SUMMARY:  Represents a single node, or vertex, within a Graph data structure.
* */
public class GraphNode<T> extends Node<T> {

    public GraphNode(T v){
        data = v;
        children = new HashSet<GraphNode<T>>();
        visited = false;
    }

    HashSet<GraphNode<T>> children;
    boolean visited;
}
