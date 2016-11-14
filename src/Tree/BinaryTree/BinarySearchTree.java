// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package Tree.BinaryTree;

/*
* SUMMARY:  Represents a BinarySearchTree data structure.
*
* NOTE:     Will refactor to include a self-balancing algorithm to properly handle insertions/removals.
* */
public class BinarySearchTree<T> {

    private BinaryTreeNode<T> root;

    /*
    * SUMMARY:  Default constructor, initializes the root of the tree to null.
    * */
    public BinarySearchTree(){
        root = null;
    }

    /*
    * SUMMARY:  Returns the root node of the tree.
    *           Required method since the actual root has private access.
    * */
    public BinaryTreeNode<T> getRoot(){
        return root;
    }

    public void printValue(T value){
        System.out.println("[" + value + "]" + "\n");
    }

    /*
    * SUMMARY:  Traverses the tree using In-Order Traversal method.
    *           Nodes are printed to console during traversal.
    * */
    public void traverseInOrderCall(){
        traverseInOrder(root);
    }
    private void traverseInOrder(BinaryTreeNode<T> current){
        if(current == null){
            return;
        }
        traverseInOrder(current.left);
        printValue(current.getValue());
        traverseInOrder(current.right);
    }

    /*
    * SUMMARY:  Traverses the tree using Pre-Order Traversal method.
    *           Nodes are printed to console during traversal.
    * */
    public void traversePreOrderCall(){
        traversePreOrder(root);
    }
    private void traversePreOrder(BinaryTreeNode<T> current){
        if(current == null){
            return;
        }
        printValue(current.getValue());
        traversePreOrder(current.left);
        traversePreOrder(current.right);
    }

    /*
    * SUMMARY:  Traverses the tree using Post-Order Traversal method.
    *           Nodes are printed to console during traversal.
    * */
    public void traversePostOrderCall(){
        traversePostOrder(root);
    }
    private void traversePostOrder(BinaryTreeNode<T> current){
        if(current == null){
            return;
        }
        traversePostOrder(current.left);
        traversePostOrder(current.right);
        printValue(current.getValue());
    }

    /*
    * SUMMARY:  Returns a boolean indicating whether or not the tree contains a given value
    *           Returns true if the tree contains the value, false if the tree is empty or does not contain the value.
    * */
    public boolean contains(T value){
        return contains(value, root);
    }
    private boolean contains(T value, BinaryTreeNode<T> current){
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

    /*
    * SUMMARY:  Inserts a value into the tree based on Binary Tree insertion rules.
    * */
    public void insert(T value){
        root = insert(value, root);
    }
    private BinaryTreeNode<T> insert(T value, BinaryTreeNode<T> current){
        if(current == null){
            current = new BinaryTreeNode<T>(value);
        }
        else if((Integer)value < (Integer)current.getValue()){
            current.left = insert(value, current.left);
        }
        else if((Integer)value > (Integer)current.getValue()){
            current.right = insert(value, current.right);
        }
        return current;
    }

    /*
    * SUMMARY:  Removes a given value from the tree based on Binary Tree removal rules.
    * */
    public void remove(T value){
        root = remove(value, root);
    }
    private BinaryTreeNode<T> remove(T value, BinaryTreeNode<T> current){
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

    /*
    * SUMMARY:  Returns a node object representing the smallest value within the tree.
    * */
    public BinaryTreeNode<T> findMin(){
        return findMin(root);
    }
    private BinaryTreeNode<T> findMin(BinaryTreeNode<T> current){
        if(current == null){
            return null;
        }
        if(current.left == null){
            return current;
        }
        return findMin(current.left);
    }

    /*
    * SUMMARY:  Returns a node object representing the largest value within the tree.
    * */
    public BinaryTreeNode<T> findMax(){
        return findMax(root);
    }
    private BinaryTreeNode<T> findMax(BinaryTreeNode<T> current){
        if(current == null){
            return null;
        }
        if(current.right == null){
            return current;
        }
        return findMax(current.right);
    }
}