package BinaryTree;

public class Node {

    public Node(){
        value = null;
        left = null;
        right = null;
    }

    public Node(Object v){
        value = v;
    }

    private Object value;
    public Node left;
    public Node right;

    public Object getValue(){
        return value;
    }

    public void setValue(Object v){
        value = v;
    }
}
