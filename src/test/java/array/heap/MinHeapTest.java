package array.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TestAssetEngine;

import java.util.Arrays;

/**
 * Contains unit tests for methods contained within the MinHeap class.
 */
public class MinHeapTest extends HeapTest {

    public MinHeapTest() throws Exception {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(200).upperBoundSize(this.UPPER_BOUND_SIZE));
    }

    @Override
    @Before
    public void initialize() {
        this.heap = new MinHeap<>(Integer.class, this.UPPER_BOUND_SIZE);
    }

    @Override
    @Test
    public void heapGetExtremeTest() throws HeapException {
        int[] arr = this.engine.generateUnorderedIntegerArrayOfSize(this.UPPER_BOUND_SIZE);
        for(Integer item : arr) {
            this.heap.push(item);
        }
        Arrays.sort(arr);
        int expected = arr[0];
        int actual = this.heap.peek();
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void heapRemoveExtremeTest() throws HeapException {
        int[] arr = this.engine.generateUnorderedIntegerArrayOfSize(this.UPPER_BOUND_SIZE);
        for(Integer item : arr) {
            this.heap.push(item);
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            int expected = arr[i];
            int actual = this.heap.pop();
            Assert.assertEquals(expected, actual);
        }
    }

    @Override
    @Test
    public void heapGetHeapTest() throws HeapException {
        int[] arr = {-18, 138, -149, 184, -135, -8, 190, 20, -135, -77};
        for(Integer item : arr) {
            this.heap.push(item);
        }
        int[] arrHeapOrder = {-149, -135, -18, -135, -77, -8, 190, 184, 20, 138};
        Integer[] heapArr = this.heap.getHeap();
        for(int i = 0; i < arrHeapOrder.length; i++) {
            int expected = arrHeapOrder[i];
            int actual = heapArr[i];
            Assert.assertEquals(expected, actual);
        }
    }

}
