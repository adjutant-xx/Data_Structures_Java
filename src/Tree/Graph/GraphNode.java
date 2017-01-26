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
    private Graph.VisitState _status;

    public GraphNode(T d){
        this.setData(d);
        _children = new ArrayList<GraphNode<T>>();
        _status = Graph.VisitState.Unvisited;
    }

    public ArrayList<GraphNode<T>> getChildren(){
        return _children;
    }

    public void setChildren(ArrayList<GraphNode<T>> c){
        _children = c;
    }

    public void addChild(GraphNode<T> newChild){
        _children.add(newChild);
    }

    public Graph.VisitState getVisitState(){
        return _status;
    }

    public void setVisitState(Graph.VisitState state){
        _status = state;
    }
}
