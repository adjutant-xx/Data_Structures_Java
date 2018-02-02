package array.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TestAssetEngine;

import java.util.Arrays;

/**
 * Contains unit tests for methods contained within the Heap class.
 */
public abstract class HeapTest {

    protected TestAssetEngine engine;
    protected Heap<Integer> heap;
    protected final int UPPER_BOUND_SIZE = 100;

    public HeapTest() throws Exception {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(200).upperBoundSize(this.UPPER_BOUND_SIZE));
    }

    @Before
    public abstract void initialize();

    @Test
    public void heapInsertTest() throws HeapException {
        int[] arr = this.engine.generateUnorderedIntegerArrayOfSize(this.UPPER_BOUND_SIZE);
        for(Integer item : arr) {
            this.heap.insert(item);
        }
        int expected1 = arr.length;
        int actual1 = this.heap.getSize();
        Assert.assertEquals(expected1, actual1);
        Integer[] heapArr = this.heap.getHeap();
        int expected2 = arr.length;
        int actual2 = heapArr.length;
        Assert.assertEquals(expected2, actual2);
        Arrays.sort(heapArr);
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            int expected3 = arr[i];
            int actual3 = heapArr[i];
            Assert.assertEquals(expected3, actual3);
        }
    }

    @Test
    public abstract void heapGetExtremeTest() throws HeapException;

    @Test
    public abstract void heapRemoveExtremeTest() throws HeapException;

    @Test
    public abstract void heapGetHeapTest() throws HeapException;

    @Test
    public void heapGetMaxSizeTest() {
        int expected = this.UPPER_BOUND_SIZE;
        int actual = this.heap.getMaxSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void heapGetSizeTest() throws HeapException {
        int[] arr = this.engine.generateUnorderedIntegerArrayOfSize(this.UPPER_BOUND_SIZE);
        int count = 0;
        for(Integer item : arr) {
            this.heap.insert(item);
            count++;
            int expected1 = count;
            int actual1 = this.heap.getSize();
            Assert.assertEquals(expected1, actual1);
        }
        while(this.heap.getSize() > 0) {
            this.heap.removeExtreme();
            count--;
            int expected2 = count;
            int actual2 = this.heap.getSize();
            Assert.assertEquals(expected2, actual2);
        }
    }

    @Test
    public void heapIsEmptyTest() throws HeapException {
        int[] arr = this.engine.generateUnorderedIntegerArrayOfSize(this.UPPER_BOUND_SIZE);
        boolean expected1 = true;
        boolean actual1 = this.heap.isEmpty();
        Assert.assertEquals(expected1, actual1);
        for(Integer item : arr) {
            this.heap.insert(item);
            boolean expected2 = false;
            boolean actual2 = this.heap.isEmpty();
            Assert.assertEquals(expected2, actual2);
        }
        while(!this.heap.isEmpty()) {
            this.heap.removeExtreme();
        }
        boolean expected3 = true;
        boolean actual3 = this.heap.isEmpty();
        Assert.assertEquals(expected3, actual3);
    }

}
