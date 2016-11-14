// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/mpaauw
//
// No license, free use

package Tree;

import java.util.ArrayList;

/*
* SUMMARY:  Represents a single TreeNode object to be used within a Tree-like data structure.
* */
public class TreeNode<T> {
    private T _data;
    protected ArrayList<TreeNode<T>> _children;

    public TreeNode(){}

    public TreeNode(T d){
        _data = d;
        _children = new ArrayList<TreeNode<T>>();
    }

    public void setData(T d){
        _data = d;
    }

    public T getData(){
        return _data;
    }
}
