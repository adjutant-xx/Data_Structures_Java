package tree.graph;

/**
 * Contains implementations for a GraphNode object, to be used with Graph-based data structures.
 * Extends the TreeNode class.
 */
public class GraphNode<T> {

    private T data;

    public GraphNode() {}

    public GraphNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
