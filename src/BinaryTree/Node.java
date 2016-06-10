package BinaryTree;

public class Node {
    private Object value;
    public Node left;
    public Node right;

    public Node(Object v){
        value = v;
        left = null;
        right = null;
    }

    public Object getValue(){
        return value;
    }
}
