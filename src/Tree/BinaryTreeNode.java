// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package Tree;

public class BinaryTreeNode<T> {
    public BinaryTreeNode(){
        value = null;
        left = null;
        right = null;
        parent = null;
    }

    public BinaryTreeNode(T v){
        setValue(v);
    }

    private T value;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode<T> parent;

    public T getValue(){
        return value;
    }

    public void setValue(T v){
        value = v;
    }
}
