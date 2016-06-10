package BinaryTree;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(){
        root = null;
    }

    public Node getRoot(){
        return root;
    }

    public void printValue(Object value){
        System.out.println("[" + value + "]" + "\n");
    }

    public void traverseInOrderCall(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node current){
        if(current == null){
            return;
        }
        traverseInOrder(current.left);
        printValue(current.getValue());
        traverseInOrder(current.right);
    }

    public void traversePreOrderCall(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node current){
        if(current == null){
            return;
        }
        printValue(current.getValue());
        traversePreOrder(current.left);
        traversePreOrder(current.right);
    }

    public void traversePostOrderCall(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node current){
        if(current == null){
            return;
        }
        traversePostOrder(current.left);
        traversePostOrder(current.right);
        printValue(current.getValue());
    }

    public void insert(Object value){
        root = insert(value, root);
    }

    private Node insert(Object value, Node current){

        if(current == null){
            current = new Node(value);
        }
        else if((Integer)value < (Integer)current.getValue()){
            current.left = insert(value, current.left);
        }
        else if((Integer)value > (Integer)current.getValue()){
            current.right = insert(value, current.right);
        }

        return current;
    }




}
