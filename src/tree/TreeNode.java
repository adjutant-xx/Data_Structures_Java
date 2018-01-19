package tree;

/**
 * Contains implementations for a TreeNode object, to be used with Tree-based data structures.
 */
public class TreeNode<T> {
    private T data;

    public TreeNode() {}

    public TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
