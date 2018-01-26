package list;

import list.queue.Queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TestAssetEngine;

/**
 * Contains unit tests for methods contained within the Queue class.
 */
public class QueueTest {
    private TestAssetEngine engine;
    private Queue<Integer> queue;

    public QueueTest() throws Exception {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(200).upperBoundSize(100));
    }

    @Before
    public void initialize() {
        this.queue = new Queue();
    }

    @Test
    public void queueEnqueueTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.queue.enqueue(item);
            int expected = item;
            int actual = this.queue.getElementAtEnd();
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void queueDequeueTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.queue.enqueue(item);
        }
        for(Integer item : arr) {
            int expected = item;
            int actual = this.queue.dequeue();
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void queuePeekTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.queue.enqueue(item);
        }
        for(Integer item : arr) {
            int expected = item;
            int actual = this.queue.peek();
            Assert.assertEquals(expected, actual);
            this.queue.dequeue();
        }
    }

    @Test
    public void queueIsEmptyTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        boolean expected1 = true;
        boolean actual1 = this.queue.isEmpty();
        Assert.assertEquals(expected1, actual1);
        for(Integer item : arr) {
            this.queue.enqueue(item);
            boolean expected2 = false;
            boolean actual2 = this.queue.isEmpty();
            Assert.assertEquals(expected2, actual2);
        }
        while(!this.queue.isEmpty()) {
            this.queue.dequeue();
        }
        boolean expected3 = true;
        boolean actual3 = this.queue.isEmpty();
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void queueGetSizeTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        int expected1 = 0;
        int actual1 = this.queue.getSize();
        Assert.assertEquals(expected1, actual1);
        int count = 0;
        for(Integer item : arr) {
            this.queue.enqueue(item);
            count++;
            int expected2 = count;
            int actual2 = this.queue.getSize();
            Assert.assertEquals(expected2, actual2);
        }
        int expected3 = arr.length;
        int actual3 = this.queue.getSize();
        Assert.assertEquals(expected3, actual3);
        while(!this.queue.isEmpty()) {
            this.queue.dequeue();
            count--;
            int expected4 = count;
            int actual4 = this.queue.getSize();
            Assert.assertEquals(expected4, actual4);
        }
        int expected5 = 0;
        int actual5 = this.queue.getSize();
        Assert.assertEquals(expected5, actual5);
    }

}
