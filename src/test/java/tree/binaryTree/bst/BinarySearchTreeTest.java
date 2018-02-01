package tree.binaryTree.bst;

import list.DoublyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tree.binaryTree.BinaryTreeNode;
import util.TestAssetEngine;

import java.util.Arrays;

/**
 * Contains unit tests for methods contained within the BinarySearchTree class.
 */
public class BinarySearchTreeTest {

    private TestAssetEngine engine;
    private BinarySearchTree<Integer> bst;

    public BinarySearchTreeTest() throws Exception {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(20000).upperBoundSize(200));
    }

    @Before
    public void initialize() {
        this.bst = new BinarySearchTree();
    }

    @Test
    public void binarySearchTreeInsertTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        int count = 0;
        for(Integer item : arr) {
            this.bst.insert(item);
            count++;
            Assert.assertNotNull(this.bst.find(item));
            int expected = count;
            int actual = this.bst.getSize();
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void binarySearchTreeRemoveTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.bst.insert(item);
        }
        int count = this.bst.getSize();
        for(Integer item : arr) {
            this.bst.remove(item);
            Assert.assertNull(this.bst.find(item));
            count--;
            int expected = count;
            int actual = this.bst.getSize();
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void binarySearchTreeFindTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.bst.insert(item);
        }
        for(Integer item :  arr) {
            BinaryTreeNode<Integer> node = this.bst.find(item);
            int expected = item;
            int actual = node.getData();
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void binarySearchTreeFindMinTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.bst.insert(item);
        }
        Arrays.sort(arr);
        int expected = arr[0];
        int actual = this.bst.findMin().getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binarySearchTreeFindMaxTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.bst.insert(item);
        }
        Arrays.sort(arr);
        int expected = arr[arr.length - 1];
        int actual = this.bst.findMax().getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binarySearchTreeTraverseInOrderTest() {
        int[] arr = {30, 25, 49, 10, 28, 37, 102};
        for(Integer item : arr) {
            this.bst.insert(item);
        }
        int[] inOrderArr = {10, 25, 28, 30, 37, 49, 102};
        DoublyLinkedList<BinaryTreeNode<Integer>> inOrderList = this.bst.traverseInOrder();
        for(int i = 0; i < inOrderArr.length; i++) {
            int expected = inOrderArr[i];
            int actual = inOrderList.getElementAt(i).getData();
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void binarySearchTreeTraversePreOrderTest() {
        int[] arr = {30, 25, 49, 10, 28, 37, 102};
        for(Integer item : arr) {
            this.bst.insert(item);
        }
        int[] preOrderArr = {30, 25, 10, 28, 49, 37, 102};
        DoublyLinkedList<BinaryTreeNode<Integer>> preOrderList = this.bst.traversePreOrder();
        for(int i = 0; i < preOrderArr.length; i++) {
            int expected = preOrderArr[i];
            int actual = preOrderList.getElementAt(i).getData();
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void binarySearchTreeTraversePostOrderTest() {
        int[] arr = {30, 25, 49, 10, 28, 37, 102};
        for(Integer item : arr) {
            this.bst.insert(item);
        }
        int[] postOrderArr = {10, 28, 25, 37, 102, 49, 30};
        DoublyLinkedList<BinaryTreeNode<Integer>> postOrderList = this.bst.traversePostOrder();
        for(int i = 0; i < postOrderArr.length; i++) {
            int expected = postOrderArr[i];
            int actual = postOrderList.getElementAt(i).getData();
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void binarySearchTreeDepthFirstSearchTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.bst.insert(item);
        }
        int index = this.engine.generateRandomIntegerWithBound(arr.length);
        while(index >= arr.length || index < 0) {
            index = this.engine.generateRandomIntegerWithBound(arr.length);
        }
        boolean expected1 = true;
        boolean actual1 = this.bst.depthFirstSearch(arr[index]);
        Assert.assertEquals(expected1, actual1);
        int invalidVal = this.engine.generateRandomIntegerNotInArray(arr);
        boolean expected2 = false;
        boolean actual2 = this.bst.depthFirstSearch(invalidVal);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void binarySearchTreeBreadthFirstSearchTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.bst.insert(item);
        }
        int index = this.engine.generateRandomIntegerWithBound(arr.length);
        while(index >= arr.length || index < 0) {
            index = this.engine.generateRandomIntegerWithBound(arr.length);
        }
        boolean expected1 = true;
        boolean actual1 = this.bst.breadthFirstSearch(arr[index]);
        Assert.assertEquals(expected1, actual1);
        int invalidVal = this.engine.generateRandomIntegerNotInArray(arr);
        boolean expected2 = false;
        boolean actual2 = this.bst.breadthFirstSearch(invalidVal);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void binarySearchTreeGetRootTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.bst.insert(item);
        }
        int expected = arr[0];
        int actual = this.bst.getRoot().getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binarySearchTreeToTreeToArrayTest() {
        Integer[] arr = {30, 25, 49, 10, 28, 37, 102};
        this.bst.toTree(arr);
        Integer[] bstArr = this.bst.toArray(Integer.class);
        int expected1 = arr.length;
        int actual1 = bstArr.length;
        Assert.assertEquals(expected1, actual1);
        for(int i = 0; i < bstArr.length; i++) {
            int expected2 = arr[i];
            int actual2 = bstArr[i];
            Assert.assertEquals(expected2, actual2);
        }
    }

    @Test
    public void binarySearchTreeIsEmptyTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        boolean expected1 = true;
        boolean actual1 = this.bst.isEmpty();
        Assert.assertEquals(expected1, actual1);
        for(Integer item : arr) {
            this.bst.insert(item);
            boolean expected2 = false;
            boolean actual2 = this.bst.isEmpty();
            Assert.assertEquals(expected2, actual2);
        }
        for(Integer item : arr) {
            this.bst.remove(item);
        }
        boolean expected3 = true;
        boolean actual3 = this.bst.isEmpty();
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void binarySearchTreeGetSizeTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        int expected1 = 0;
        int actual1 = this.bst.getSize();
        Assert.assertEquals(expected1, actual1);
        int count = 0;
        for(Integer item : arr) {
            this.bst.insert(item);
            count++;
            int expected2 = count;
            int actual2 = this.bst.getSize();
            Assert.assertEquals(expected2, actual2);
        }
        int expected3 = arr.length;
        int actual3 = this.bst.getSize();
        Assert.assertEquals(expected3, actual3);
        for(int i = 0; i < arr.length; i++) {
            this.bst.remove(arr[i]);
            count--;
            int expected4 = count;
            int actual4 = this.bst.getSize();
            Assert.assertEquals(expected4, actual4);
        }
        int expected5 = 0;
        int actual5 = this.bst.getSize();
        Assert.assertEquals(expected5, actual5);
    }

}
