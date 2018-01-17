package test.list;

import list.ListNode;
import org.junit.Assert;
import org.junit.Test;
import util.TestAssetEngine;

/**
 * Contains unit tests for methods contained within the ListNode class.
 */
public class ListNodeTest {

    private TestAssetEngine engine;

    public ListNodeTest() {
        this.engine = new TestAssetEngine();
    }

    @Test
    public void listNodeGetDataTest() {
        int expected = this.engine.generateRandomInteger();
        ListNode<Integer> node = new ListNode<Integer>(new ListNode.Builder().data(expected));
        int actual = node.getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNodeSetDataTest() {
        int expected = this.engine.generateRandomInteger();
        ListNode<Integer> node = new ListNode<Integer>();
        node.setData(expected);
        int actual = node.getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNodeGetNextTest() {
        int val1 = this.engine.generateRandomInteger();
        int val2 = this.engine.generateRandomInteger();
        ListNode<Integer> node2 = new ListNode<Integer>(new ListNode.Builder().data(val2));
        ListNode<Integer> node1 = new ListNode<Integer>(new ListNode.Builder().data(val1).next(node2));
        ListNode<Integer> expected = node2;
        ListNode<Integer> actual = node1.getNext();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNodeSetNextTest() {
        int val1 = this.engine.generateRandomInteger();
        int val2 = this.engine.generateRandomInteger();
        ListNode<Integer> node2 = new ListNode<Integer>(new ListNode.Builder().data(val2));
        ListNode<Integer> node1 = new ListNode<Integer>(new ListNode.Builder().data(val1));
        node1.setNext(node2);
        ListNode<Integer> expected = node2;
        ListNode<Integer> actual = node1.getNext();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNodeConstructorBuilderTest() {
        int expected1 = this.engine.generateRandomInteger();
        int expected2 = this.engine.generateRandomInteger();
        ListNode<Integer> node2 = new ListNode<Integer>(new ListNode.Builder().data(expected2));
        ListNode<Integer> node1 = new ListNode<Integer>(new ListNode.Builder().data(expected1).next(node2));
        ListNode<Integer> expected3 = node2;
        ListNode<Integer> expected4 = null;
        int actual1 = node1.getData();
        int actual2 = node2.getData();
        ListNode<Integer> actual3 = node1.getNext();
        ListNode<Integer> actual4 = node2.getNext();
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }
}
