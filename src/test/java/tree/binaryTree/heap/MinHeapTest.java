package tree.binaryTree.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TestAssetEngine;

import java.util.Arrays;

/**
 * Contains unit tests for methods contained within the MinHeap class.
 */
public class MinHeapTest {

    private TestAssetEngine engine;
    private MinHeap<Integer> heap;

    public MinHeapTest() throws Exception {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(2000).upperBoundSize(100));
    }

    @Before
    public void initialize() {
        this.heap = new MinHeap<Integer>();
    }

    @Test
    public void minHeapInsertTest() throws Exception {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            boolean expected = true;
            boolean actual = this.heap.insert(item);
            Assert.assertEquals(expected, actual);
        }
        String lol = "";
    }

//    @Test
//    public void minHeapGetMinTest() throws Exception {
//        int[] arr = this.engine.generateOrderedIntegerArray();
//        for(int i = arr.length - 1; i >= 0; i--) {
//            this.heap.insert(arr[i]);
//            int expected = arr[i];
//            int actual = this.heap.getMin();
//            Assert.assertEquals(expected, actual);
//        }
//    }

//    @Test
//    public void minHeapRemoveMinTest() throws Exception {
//        int[] arr = this.engine.generateUnorderedIntegerArray();
//        for(Integer item : arr) {
//            this.heap.insert(item);
//        }
//        Arrays.sort(arr);
//        for(int i = 0; i < arr.length; i++) {
//            int expected = arr[i];
//            int actual = this.heap.removeMin();
//            Assert.assertEquals(expected, actual);
//        }
//    }

}
