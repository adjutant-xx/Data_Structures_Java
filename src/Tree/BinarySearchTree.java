package Tree;

public class BinarySearchTree<T> {

    private BSTNode<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public BSTNode<T> getRoot(){
        return root;
    }

    public void printValue(T value){
        System.out.println("[" + value + "]" + "\n");
    }

    public void traverseInOrderCall(){
        traverseInOrder(root);
    }

    private void traverseInOrder(BSTNode<T> current){
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

    private void traversePreOrder(BSTNode<T> current){
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

    private void traversePostOrder(BSTNode<T> current){
        if(current == null){
            return;
        }
        traversePostOrder(current.left);
        traversePostOrder(current.right);
        printValue(current.getValue());
    }

    public boolean contains(T value){
        return contains(value, root);
    }

    private boolean contains(T value, BSTNode<T> current){
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

    public void insert(T value){
        root = insert(value, root);
    }

    private BSTNode<T> insert(T value, BSTNode<T> current){
        if(current == null){
            current = new BSTNode<T>(value);
        }
        else if((Integer)value < (Integer)current.getValue()){
            current.left = insert(value, current.left);
        }
        else if((Integer)value > (Integer)current.getValue()){
            current.right = insert(value, current.right);
        }
        return current;
    }

    public void remove(T value){
        root = remove(value, root);
    }

    private BSTNode<T> remove(T value, BSTNode<T> current){
        if(current == null){
            return current;
        }
        if((Integer)value < (Integer)current.getValue()){
            current.left = remove(value, current.left);
        }
        else if((Integer) value > (Integer)current.getValue()){
            current.right = remove(value, current.right);
        }
        else if(current.left != null && current.right != null){
            current.setValue(findMin(current.right).getValue());
            current.right = remove(current.getValue(), current.right);
        }
        else{
            current = (current.left != null) ? current.left : current.right;
        }
        return current;
    }

    public BSTNode<T> findMin(){
        return findMin(root);
    }

    private BSTNode<T> findMin(BSTNode<T> current){
        if(current == null){
            return null;
        }
        if(current.left == null){
            return current;
        }
        return findMin(current.left);
    }

    public BSTNode<T> findMax(){
        return findMax(root);
    }

    private BSTNode<T> findMax(BSTNode<T> current){
        if(current == null){
            return null;
        }
        if(current.right == null){
            return current;
        }
        return findMax(current.right);
    }
}