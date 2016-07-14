package BinaryTree;

public class Node<T> {

    public Node(){
        value = null;
        left = null;
        right = null;
    }

    public Node(T v){
        value = v;
    }

    private T value;
    public Node<T> left;
    public Node<T> right;

    public T getValue(){
        return value;
    }

    public void setValue(T v){
        value = v;
    }
}
