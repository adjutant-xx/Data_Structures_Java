package tree.binaryTree;

import tree.TreeNode;

/**
 * Contains implementations for a BinaryTreeNode object, to be used with Tree-based data structures.
 * Extends the TreeNode class.
 */
public class BinaryTreeNode<T> extends TreeNode<T> {

    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode() {}

    public BinaryTreeNode(T data) {
        super(data);
    }

    public BinaryTreeNode(BinaryTreeNodeBuilder<T> builder) {
        this.data = builder.data;
        this.left = builder.left;
        this.right = builder.right;
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

    public static class BinaryTreeNodeBuilder<T> {

        private T data;
        private BinaryTreeNode<T> left;
        private BinaryTreeNode<T> right;

        public BinaryTreeNodeBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public BinaryTreeNodeBuilder<T> left(BinaryTreeNode<T> left) {
            this.left = left;
            return this;
        }

        public BinaryTreeNodeBuilder<T> right(BinaryTreeNode<T> right) {
            this.right = right;
            return this;
        }
    }
}
