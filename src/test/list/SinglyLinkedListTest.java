package test.list;

import com.sun.javaws.exceptions.InvalidArgumentException;
import list.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Test;
import util.ItemIndex;
import util.TestAssetEngine;

/**
 * Contains unit tests for methods contained within the SinglyLinkedList class.
 */
public class SinglyLinkedListTest {
    private TestAssetEngine engine;

    public SinglyLinkedListTest() {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(20).upperBoundSize(5));
    }

    @Test
    public void singlyLinkedListInsertGetFrontTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            list.insertFront(item);
        }
        int expected = arr[arr.length - 1];
        int actual = list.getElementAtFront();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singlyLinkedListInsertGetEndTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int[] arr = this.engine.generateUnorderedIntegerArray();
        for(Integer item : arr) {
            list.insertEnd(item);
        }
        int expected = arr[arr.length - 1];
        int actual = list.getElementAtEnd();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singlyLinkedListInsertGetAtTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int[] arr = this.engine.generateUnorderedIntegerArray();
        int val = this.engine.generateRandomInteger();
        int index = this.engine.generateRandomPositiveIntegerWithBound(arr.length);
        for(Integer item : arr) {
            list.insertEnd(item);
        }
        list.insertAt(index, val);
        int expected = val;
        int actual = list.getElementAt(index);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singlyLinkedListRemoveFrontTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int[] arr = null;
        do {
            arr = this.engine.generateUnorderedIntegerArray();
        } while(arr.length < 2);
        for(Integer item : arr) {
            list.insertEnd(item);
        }
        int expected1 = arr[0];
        int actual1 = list.getElementAtFront();
        list.removeFront();
        int expected2 = arr[1];
        int actual2 = list.getElementAtFront();
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void singlyLinkedListRemoveEndTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int[] arr = null;
        do {
            arr = this.engine.generateUnorderedIntegerArray();
        } while(arr.length < 2);
        for(Integer item : arr) {
            list.insertEnd(item);
        }
        int expected1 = arr[arr.length - 1];
        int actual1 = list.getElementAtEnd();
        list.removeEnd();
        int expected2 = arr[arr.length - 2];
        int actual2 = list.getElementAtEnd();
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void singlyLinkedListRemoveAtTest() {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int[] arr = null;
        do {
            arr = this.engine.generateUnorderedIntegerArray();
        } while(arr.length < 2);
        int index = -1;
        do {
            index = this.engine.generateRandomPositiveIntegerWithBound(arr.length);
        } while(index >= arr.length - 1);
        for(Integer item : arr) {
            list.insertEnd(item);
        }
        int expected1 = arr[index];
        int actual1 = list.getElementAt(index);
        try {
            list.removeAt(index);
        } catch(Exception e) {
            String lol = "";
        }
        int expected2 = arr[index + 1];
        int actual2 = list.getElementAt(index);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void singlyLinkedListFindTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int[] arr = this.engine.generateUnorderedIntegerArray();
        int index = this.engine.generateRandomPositiveIntegerWithBound(arr.length);
        for(Integer item : arr) {
            list.insertEnd(item);
        }
        int expected = index;
        int actual = list.find(arr[index]);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singlyLinkedListIsEmptyTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int[] arr = this.engine.generateUnorderedIntegerArray();
        boolean expected1 = true;
        boolean actual1 = list.isEmpty();
        Assert.assertEquals(expected1, actual1);
        for(Integer item : arr) {
            list.insertEnd(item);
            boolean expected2 = false;
            boolean actual2 = list.isEmpty();
            Assert.assertEquals(expected2, actual2);
        }
        while(!list.isEmpty()) {
            list.removeFront();
        }
        boolean expected3 = true;
        boolean actual3 = list.isEmpty();
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void singlyLinkedListGetSizeTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int[] arr = this.engine.generateUnorderedIntegerArray();
        int expected1 = 0;
        int actual1 = list.getSize();
        int count = 0;
        for(Integer item : arr) {
            list.insertFront(item);
            count++;
            int expected2 = count;
            int actual2 = list.getSize();
            Assert.assertEquals(expected2, actual2);
        }
        int expected3 = arr.length;
        int actual3 = list.getSize();
        Assert.assertEquals(expected3, actual3);
        while(!list.isEmpty()) {
            list.removeFront();
            count--;
            int expected4 = count;
            int actual4 = list.getSize();
            Assert.assertEquals(expected4, expected4);
        }
        int expected5 = 0;
        int actual5 = list.getSize();
    }

}
