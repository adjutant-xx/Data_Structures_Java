package Tree;

public class MinHeap<T> {

    private BinaryTreeNode<T> root;

    public MinHeap(){
        root = null;
    }

    public void insert(T value){
        root = insert(value, root);
    }

    private BinaryTreeNode<T> insert(T value, BinaryTreeNode<T> current){
        if(current == null){
            current = new BinaryTreeNode<T>(value);
            return current;
        }
        BinaryTreeNode<T> leaf = findLeaf(current);
        if(leaf.left != null){
            leaf.right = new BinaryTreeNode<T>(value);
            leaf.right.parent = leaf;
            leaf = leaf.right;

            // prop code here
            leaf = propagateUp(leaf);
            return leaf;
        }
        else{
            leaf.left = new BinaryTreeNode<T>(value);
            leaf.left.parent = leaf;
            leaf = leaf.left;

            // prop code here
            leaf = propagateUp(leaf);
            return leaf;
        }
    }

    private BinaryTreeNode<T> findLeaf(BinaryTreeNode<T> node){
        while(!isLeaf(node)){
            node.right.parent = node;
            node = node.right;
        }
        return node;
    }

    private boolean isLeaf(BinaryTreeNode<T> node){
        if(node.left == null && node.right == null){
            return true;
        }
        else if(node.left != null && node.right == null){
            return true;
        }
        return false;
    }

    private BinaryTreeNode<T> propagateUp(BinaryTreeNode<T> node){

        while((Integer)node.getValue() < (Integer)node.parent.getValue()){
            BinaryTreeNode<T> temp = node.parent;
            node.parent = node;
            node = temp;
            if(node.parent == null){
                return node;
            }
        }
        return node;
    }
}
