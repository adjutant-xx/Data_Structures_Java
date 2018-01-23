package test.tree.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tree.BinaryTreeNode;
import tree.TreeNode;
import util.TestAssetEngine;

/**
 * Contains unit tests for methods contained within the BinaryTreeNode class.
 */
public class BinaryTreeNodeTest {

    private TestAssetEngine engine;
    private BinaryTreeNode<Integer> node;

    public BinaryTreeNodeTest() {
        this.engine = new TestAssetEngine();
    }

    @Before
    public void initialize() {
        this.node = new BinaryTreeNode<>();
    }

    @Test
    public void binaryTreeNodeGetDataTest() {
        int data = this.engine.generateRandomInteger();
        this.node = new BinaryTreeNode<>(data);
        int expected = data;
        int actual = this.node.getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binaryTreeNodeSetDataTest() {
        int data = this.engine.generateRandomInteger();
        this.node.setData(data);
        int expected = data;
        int actual = this.node.getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binaryTreeNodeGetLeftTest() {
        int data1 = this.engine.generateRandomInteger();
        int data2 = this.engine.generateRandomInteger();
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data2);
        this.node = new BinaryTreeNode(new BinaryTreeNode.BinaryTreeNodeBuilder<Integer>().data(data1).left(newNode));
        BinaryTreeNode<Integer> expected = newNode;
        BinaryTreeNode<Integer> actual = this.node.getLeft();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binaryTreeNodeSetLeftTest() {
        int data1 = this.engine.generateRandomInteger();
        int data2 = this.engine.generateRandomInteger();
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data2);
        this.node.setData(data1);
        this.node.setLeft(newNode);
        BinaryTreeNode<Integer> expected = newNode;
        BinaryTreeNode<Integer> actual = this.node.getLeft();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binaryTreeNodeGetRightTest() {
        int data1 = this.engine.generateRandomInteger();
        int data2 = this.engine.generateRandomInteger();
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data2);
        this.node = new BinaryTreeNode<>(new BinaryTreeNode.BinaryTreeNodeBuilder<Integer>().data(data1).right(newNode));
        BinaryTreeNode<Integer> expected = newNode;
        BinaryTreeNode<Integer> actual = this.node.getRight();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binaryTreeNodeSetRightTest() {
        int data1 = this.engine.generateRandomInteger();
        int data2 = this.engine.generateRandomInteger();
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data2);
        this.node.setData(data1);
        this.node.setRight(newNode);
        BinaryTreeNode<Integer> expected = newNode;
        BinaryTreeNode<Integer> actual = this.node.getRight();
        Assert.assertEquals(expected, actual);
    }
}
