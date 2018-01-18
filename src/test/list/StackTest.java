package test.list;

import list.stack.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TestAssetEngine;

/**
 * Contains unit tests for methods contained within the Stack class.
 */
public class StackTest {
    private TestAssetEngine engine;
    private Stack<Integer> stack;

    public StackTest() {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(200).upperBoundSize(100));
    }

    @Before
    public void initialize() {
        this.stack = new Stack<>();
    }

    @Test
    public void stackPushTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.stack.push(item);
            int expected = item;
            int actual = this.stack.getElementAtFront();
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void stackPopTest() {
       int[] arr = this.engine.generateUnorderedIntegerArray();
       for(Integer item : arr) {
           this.stack.push(item);
       }
       for(int i = arr.length - 1; i >= 0; i--) {
           int expected = arr[i];
           int actual = this.stack.pop();
           Assert.assertEquals(expected, actual);
       }
    }

    @Test
    public void stackPeekTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.stack.push(item);
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            int expected = arr[i];
            int actual = this.stack.peek();
            Assert.assertEquals(expected, actual);
            this.stack.pop();
        }
    }

    @Test
    public void stackIsEmptyTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        boolean expected1 = true;
        boolean actual1 = this.stack.isEmpty();
        Assert.assertEquals(expected1, actual1);
        for(Integer item : arr) {
            this.stack.push(item);
            boolean expected2 = false;
            boolean actual2 = this.stack.isEmpty();
            Assert.assertEquals(expected2, actual2);
        }
        while(!this.stack.isEmpty()) {
            this.stack.pop();
        }
        boolean expected3 = true;
        boolean actual3 = this.stack.isEmpty();
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void stackGetSizeTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        int expected1 = 0;
        int actual1 = this.stack.getSize();
        Assert.assertEquals(expected1, actual1);
        int count = 0;
        for(Integer item : arr) {
            this.stack.push(item);
            count++;
            int expected2 = count;
            int actual2 = this.stack.getSize();
            Assert.assertEquals(expected2, actual2);
        }
        int expected3 = arr.length;
        int actual3 = this.stack.getSize();
        Assert.assertEquals(expected3, actual3);
        while(!this.stack.isEmpty()) {
            this.stack.pop();
            count--;
            int expected4 = count;
            int actual4 = this.stack.getSize();
            Assert.assertEquals(expected4, actual4);
        }
        int expected5 = 0;
        int actual5 = this.stack.getSize();
        Assert.assertEquals(expected5, actual5);
    }
}
