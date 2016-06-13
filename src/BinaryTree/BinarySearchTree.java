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

    public boolean contains(Object value){
        return contains(value, root);
    }

    private boolean contains(Object value, Node current){
        if(current == null) {
            return false;
        }
        else if((Integer)value < (Integer)current.getValue()){
                return contains(value, current.left);
            }
        else if((Integer)value > (Integer)current.getValue()){
            return contains(value, current.right);
        }
        else {
            return true;
        }
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

    public void remove(Object value){
        root = remove(value, root);
    }

    private Node remove(Object value, Node current){
        if(current == null){
            return null;
        }

        if((Integer)value < (Integer)current.getValue()){
            remove(value, current.left);
        }
        else if((Integer)value > (Integer)current.getValue()){
            remove(value, current.right);
        }
        else if(current.left != null && current.right != null){
            current = findMin(current.right);
            remove(current.getValue(), current.right);
        }
        else{
            //Node oldNode = current;
            current = (current.left != null) ? current.left : current.right;
        }
        return current;
    }

    public Node findMin(){
        return findMin(root);
    }

    private Node findMin(Node current){
        if(current == null){
            return null;
        }
        if(current.left == null){
            return current;
        }
        return findMin(current.left);
    }

    public Node findMax(){
        return findMax(root);
    }

    private Node findMax(Node current){
        if(current == null){
            return null;
        }
        if(current.right == null){
            return current;
        }
        return findMax(current.right);
    }
}