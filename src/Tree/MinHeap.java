// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package Tree;

public class MinHeap<T> {

    private BinaryTreeNode<T> root;

    public MinHeap(){
        root = null;
    }

    public void upHeap(T value){
        root = upHeap(value, root);
    }

    private BinaryTreeNode<T> upHeap(T value, BinaryTreeNode<T> current){
        if(current == null){
            current = new BinaryTreeNode<T>(value);
            return current;
        }
        //BinaryTreeNode<T> leaf = findLeaf(current);
        current = findBranch(current);
        if(current.left != null && current.right == null){
            current.right = new BinaryTreeNode<T>(value);
            current.right.parent = current;
            current = current.right;

            // prop code here
            current = percolateUp(current);
            return current;
        }
        else if(current.left == null && current.right == null){
            current.left = new BinaryTreeNode<T>(value);
            current.left.parent = current;
            current = current.left;

            // prop code here
            current = percolateUp(current);
            return current;
        }
        else{
            return current;
        }
    }

    public T downHeap(){
        T minimumVal = root.getValue();

        //percolate down, replacing the root with the next smallest child while recursively replacing:

        return minimumVal;
    }

    private BinaryTreeNode<T> findBranch(BinaryTreeNode<T> node){

        while(node != null){
            if(node.left == null || node.right == null){
                return node;
            }
            else{
                //check left subtree:
                if(node.left.left == null || node.left.right == null){
                    node = node.left;
                }
                else{
                    node = node.right;
                }
            }
        }
        return node;
    }

    private BinaryTreeNode<T> percolateUp(BinaryTreeNode<T> node){

        //while((Integer)node.getValue() < (Integer)node.parent.getValue()){
        while(node.parent != null){

            if((Integer)node.getValue() < (Integer)node.parent.getValue()) {
                T temp = node.getValue();
                node.setValue(node.parent.getValue());
                node.parent.setValue(temp);
            }
            node = node.parent;
        }
        return node;
    }
}
