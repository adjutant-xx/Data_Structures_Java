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
        //BinaryTreeNode<T> leaf = findLeaf(current);
        current = findBranch(current);
        if(current.left != null && current.right == null){
            current.right = new BinaryTreeNode<T>(value);
            current.right.parent = current;
            current = current.right;

            // prop code here
            current = propagateUp(current);
            return current;
        }
        else if(current.left == null && current.right == null){
            current.left = new BinaryTreeNode<T>(value);
            current.left.parent = current;
            current = current.left;

            // prop code here
            current = propagateUp(current);
            return current;
        }
        else{
            return current;
        }
    }

    private BinaryTreeNode<T> findBranch(BinaryTreeNode<T> node){
        while(node != null){
            if(node.left == null && node.right == null){
                return node;
            }
            else if(node.left != null && node.right == null){
                return node;
            }
            else if(node.left != null && node.right != null){
                node = node.left;
            }
        }
        return node;
    }

    private Character isLeaf(BinaryTreeNode<T> node){
        if(node.left == null && node.right == null){
            return 'l';
        }
        else if(node.left != null && node.right == null){
            return 'r';
        }
        return 'c';
    }

    private BinaryTreeNode<T> propagateUp(BinaryTreeNode<T> node){

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
