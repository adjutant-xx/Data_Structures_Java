package test.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tree.BinarySearchTree;
import util.TestAssetEngine;

import java.util.Arrays;

public class BinarySearchTreeTest {

    private TestAssetEngine engine;
    private BinarySearchTree<Integer> bst;

    public BinarySearchTreeTest() {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(200).upperBoundSize(10));
    }

    @Before
    public void initialize() {
        this.bst = new BinarySearchTree<>();
    }

    @Test
    public void binarySearchTreeInsertTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        int count = 0;
        for(Integer item : arr) {
            this.bst.insert(item);
            count++;
            int expected1 = count;
            int actual1 = this.bst.getSize();
            Assert.assertEquals(expected1, actual1);
        }
        Integer[] bstArr = this.bst.toArray(Integer.class);
        int expected2 = arr.length;
        int actual2 = bstArr.length;
        Assert.assertEquals(expected2, actual2);
        Arrays.sort(bstArr);
        for(int i = 0; i < bstArr.length; i++) {
            int expected3 = arr[i];
            int actual3 = bstArr[i];
            Assert.assertEquals(expected3, actual3);
        }
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

}
