package tree;

/**
 * Contains implementations for a BinaryTreeNode object, to be used with Tree-based data structures.
 */
public class BinaryTreeNode<T> extends TreeNode<T>{

    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode() {}

    public BinaryTreeNode(T data) {
        super(data);
    }
    
    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
}
