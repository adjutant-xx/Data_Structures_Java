package array.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TestAssetEngine;

import java.util.Arrays;

/**
 * Contains unit tests for methods contained within the MaxHeap class.
 */
public class MaxHeapTest extends HeapTest {

    public MaxHeapTest() throws Exception {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(200).upperBoundSize(this.UPPER_BOUND_SIZE));
    }

    @Before
    public void initialize() {
        this.heap = new MaxHeap<>(Integer.class, this.UPPER_BOUND_SIZE);
    }

    @Override
    @Test
    public void heapGetExtremeTest() throws HeapException {
        int[] arr = this.engine.generateUnorderedIntegerArrayOfSize(this.UPPER_BOUND_SIZE);
        for(Integer item : arr) {
            this.heap.push(item);
        }
        Arrays.sort(arr);
        int expected = arr[arr.length - 1];
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
        for(int i = arr.length - 1; i >= 0; i--) {
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
        int[] arrHeapOrder = {190, 138, 184, 20, -77, -149, -8, -18, -135, -135};
        Integer[] heapArr = this.heap.getHeap();
        for(int i = 0; i < arrHeapOrder.length; i++) {
            int expected = arrHeapOrder[i];
            int actual = heapArr[i];
            Assert.assertEquals(expected, actual);
        }
    }

}
