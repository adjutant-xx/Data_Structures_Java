// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/mpaauw
//
// No license, free use

package Tree.Graph;

import Tree.TreeNode;

import java.util.ArrayList;

/*
* SUMMARY:  Represents a single node, or vertex, within a Graph data structure.
* */
public class GraphNode<T> extends TreeNode<T> {
    private ArrayList<GraphNode<T>> _children;
    private DirectedGraph.VisitState _status;

    public GraphNode(T d){
        this.setData(d);
        _children = new ArrayList<GraphNode<T>>();
        _status = DirectedGraph.VisitState.Unvisited;
    }

    public ArrayList<GraphNode<T>> getChildren(){
        return _children;
    }

    public void addChild(GraphNode<T> newChild){
        _children.add(newChild);
    }

    public DirectedGraph.VisitState getVisitState(){
        return _status;
    }

    public void setVisitState(DirectedGraph.VisitState state){
        _status = state;
    }
}
