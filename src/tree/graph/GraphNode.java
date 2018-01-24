package tree.graph;

import tree.TreeNode;

/**
 * Contains implementations for a GraphNode object, to be used with Graph-based data structures.
 * Extends the TreeNode class.
 */
public class GraphNode<T> extends TreeNode<T> {

    private VisitStatus status = VisitStatus.Unvisited;

    public GraphNode() {}

    public GraphNode(T data) {
        super(data);
    }

    public GraphNode(GraphNodeBuilder<T> builder) {
        this.data = builder.data;
    }

    public VisitStatus getStatus() {
        return status;
    }

    public void setStatus(VisitStatus status) {
        this.status = status;
    }

    public static class GraphNodeBuilder<T> {
        private T data;

        public GraphNodeBuilder<T> data(T data) {
            this.data = data;
            return this;
        }
    }
}
