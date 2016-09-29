package Tree;

public class BSTNode<T> {
    public BSTNode(){
        value = null;
        left = null;
        right = null;
    }

    public BSTNode(T v){
        value = v;
    }

    private T value;
    public BSTNode<T> left;
    public BSTNode<T> right;

    public T getValue(){
        return value;
    }

    public void setValue(T v){
        value = v;
    }
}
