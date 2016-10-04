package Tree;

public class BinaryTreeNode<T> {
    public BinaryTreeNode(){
        value = null;
        left = null;
        right = null;
        parent = null;
    }

    public BinaryTreeNode(T v){
        value = v;
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
