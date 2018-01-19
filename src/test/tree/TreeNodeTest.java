package test.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tree.TreeNode;
import util.TestAssetEngine;

/**
 * Contains unit tests for methods contained within the TreeNode class.
 */
public class TreeNodeTest {

    private TestAssetEngine engine;
    private TreeNode<Integer> node;

    public TreeNodeTest() {
        this.engine = new TestAssetEngine();
    }

    @Before
    public void initialize() {
        this.node = new TreeNode();
    }

    @Test
    public void treeNodeGetDataTest() {
        int data = this.engine.generateRandomInteger();
        this.node = new TreeNode<>(data);
        int expected = data;
        int actual = this.node.getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void treeNodeSetDataTest() {
        int data = this.engine.generateRandomInteger();
        this.node.setData(data);
        int expected = data;
        int actual = this.node.getData();
        Assert.assertEquals(expected, actual);
    }

}
