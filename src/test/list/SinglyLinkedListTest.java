package test.list;
import list.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ItemIndex;
import util.TestAssetEngine;

/**
 * Contains unit tests for methods contained within the SinglyLinkedList class.
 */
public class SinglyLinkedListTest {
    protected TestAssetEngine engine;
    protected SinglyLinkedList<Integer> list;

    public SinglyLinkedListTest() {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(200).upperBoundSize(100));
    }

    @Before
    public void initialize() {
        this.list = new SinglyLinkedList<>();
    }

    @Test
    public void singlyLinkedListInsertGetFrontTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.list.insertFront(item);
        }
        int expected = arr[arr.length - 1];
        int actual = this.list.getElementAtFront();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singlyLinkedListInsertGetEndTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            this.list.insertEnd(item);
        }
        int expected = arr[arr.length - 1];
        int actual = this.list.getElementAtEnd();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singlyLinkedListInsertGetAtTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        int val = this.engine.generateRandomInteger();
        int index = this.engine.generateRandomPositiveIntegerWithBound(arr.length);
        for(Integer item : arr) {
            this.list.insertEnd(item);
        }
        this.list.insertAt(index, val);
        int expected = val;
        int actual = this.list.getElementAt(index);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singlyLinkedListRemoveFrontTest() {
        int[] arr = null;
        do {
            arr = this.engine.generateUnorderedIntegerArray();
        } while(arr.length < 2);
        for(Integer item : arr) {
            this.list.insertEnd(item);
        }
        int expected1 = arr[0];
        int actual1 = this.list.getElementAtFront();
        this. list.removeFront();
        int expected2 = arr[1];
        int actual2 = this.list.getElementAtFront();
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void singlyLinkedListRemoveEndTest() {
        int[] arr = null;
        do {
            arr = this.engine.generateUnorderedIntegerArray();
        } while(arr.length < 2);
        for(Integer item : arr) {
            this.list.insertEnd(item);
        }
        int expected1 = arr[arr.length - 1];
        int actual1 = this.list.getElementAtEnd();
        this.list.removeEnd();
        int expected2 = arr[arr.length - 2];
        int actual2 = list.getElementAtEnd();
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void singlyLinkedListRemoveAtTest() {
        int[] arr = null;
        do {
            arr = this.engine.generateUnorderedIntegerArray();
        } while(arr.length < 2);
        int index = -1;
        do {
            index = this.engine.generateRandomPositiveIntegerWithBound(arr.length);
        } while(index >= arr.length - 1);
        for(Integer item : arr) {
            this.list.insertEnd(item);
        }
        int expected1 = arr[index];
        int actual1 = this.list.getElementAt(index);
        this.list.removeAt(index);
        int expected2 = arr[index + 1];
        int actual2 = this.list.getElementAt(index);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void singlyLinkedListFindTest() {
        int[] arr = this.engine.generateUnorderedUniqueIntegerArray();
        int index = this.engine.generateRandomPositiveIntegerWithBound(arr.length);
        for(Integer item : arr) {
            this.list.insertEnd(item);
        }
        int expected = index;
        int actual = this.list.find(arr[index]);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singlyLinkedListIsEmptyTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        boolean expected1 = true;
        boolean actual1 = this.list.isEmpty();
        Assert.assertEquals(expected1, actual1);
        for(Integer item : arr) {
            this.list.insertEnd(item);
            boolean expected2 = false;
            boolean actual2 = list.isEmpty();
            Assert.assertEquals(expected2, actual2);
        }
        while(!this.list.isEmpty()) {
            this.list.removeFront();
        }
        boolean expected3 = true;
        boolean actual3 = this.list.isEmpty();
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void singlyLinkedListGetSizeTest() {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        int expected1 = 0;
        int actual1 = this.list.getSize();
        Assert.assertEquals(expected1, actual1);
        int count = 0;
        for(Integer item : arr) {
            this.list.insertFront(item);
            count++;
            int expected2 = count;
            int actual2 = this.list.getSize();
            Assert.assertEquals(expected2, actual2);
        }
        int expected3 = arr.length;
        int actual3 = this.list.getSize();
        Assert.assertEquals(expected3, actual3);
        while(!this.list.isEmpty()) {
            this.list.removeFront();
            count--;
            int expected4 = count;
            int actual4 = this.list.getSize();
            Assert.assertEquals(expected4, actual4);
        }
        int expected5 = 0;
        int actual5 = this.list.getSize();
        Assert.assertEquals(expected5, actual5);
    }

}
