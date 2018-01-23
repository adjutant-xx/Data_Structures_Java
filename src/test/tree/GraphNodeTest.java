package test.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tree.GraphNode;
import util.TestAssetEngine;

/**
 * Contains unit tests for methods contained within the GraphNode class.
 */
public class GraphNodeTest {

    private TestAssetEngine engine;
    private GraphNode<Integer> node;

    public GraphNodeTest() {
        this.engine = new TestAssetEngine();
    }

    @Before
    public void initialize() {
        this.node = new GraphNode<Integer>();
    }

    @Test
    public void graphNodeGetDataTest() {
        int data = this.engine.generateRandomInteger();
        this.node = new GraphNode<>(data);
        int expected = data;
        int actual = this.node.getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void graphNodeSetDataTest() {
        int data = this.engine.generateRandomInteger();
        this.node.setData(data);
        int expected = data;
        int actual = this.node.getData();
        Assert.assertEquals(expected, actual);
    }

}
