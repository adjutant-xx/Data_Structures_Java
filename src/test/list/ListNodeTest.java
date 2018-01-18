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
        ListNode<Integer> node = new ListNode<>(new ListNode.ListNodeBuilder().data(expected));
        int actual = node.getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNodeSetDataTest() {
        int expected = this.engine.generateRandomInteger();
        ListNode<Integer> node = new ListNode<>();
        node.setData(expected);
        int actual = node.getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNodeGetNextTest() {
        int val1 = this.engine.generateRandomInteger();
        int val2 = this.engine.generateRandomInteger();
        ListNode<Integer> node2 = new ListNode<>(new ListNode.ListNodeBuilder().data(val2));
        ListNode<Integer> node1 = new ListNode<>(new ListNode.ListNodeBuilder().data(val1).next(node2));
        ListNode<Integer> expected = node2;
        ListNode<Integer> actual = node1.getNext();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNodeSetNextTest() {
        int val1 = this.engine.generateRandomInteger();
        int val2 = this.engine.generateRandomInteger();
        ListNode<Integer> node2 = new ListNode<>(new ListNode.ListNodeBuilder().data(val2));
        ListNode<Integer> node1 = new ListNode<>(new ListNode.ListNodeBuilder().data(val1));
        node1.setNext(node2);
        ListNode<Integer> expected = node2;
        ListNode<Integer> actual = node1.getNext();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNodeGetPrevTest() {
        int val1 = this.engine.generateRandomInteger();
        int val2 = this.engine.generateRandomInteger();
        ListNode<Integer> node1 = new ListNode<>(new ListNode.ListNodeBuilder().data(val1));
        ListNode<Integer> node2 = new ListNode<>(new ListNode.ListNodeBuilder().data(val2).prev(node1));
        ListNode<Integer> expected = node1;
        ListNode<Integer> actual = node2.getPrev();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNodeSetPrevTest() {
        int val1 = this.engine.generateRandomInteger();
        int val2 = this.engine.generateRandomInteger();
        ListNode<Integer> node2 = new ListNode<>(new ListNode.ListNodeBuilder().data(val2));
        ListNode<Integer> node1 = new ListNode<>(new ListNode.ListNodeBuilder().data(val1));
        node2.setPrev(node1);
        ListNode<Integer> expected = node1;
        ListNode<Integer> actual = node2.getPrev();
        Assert.assertEquals(expected, actual);
    }

}
