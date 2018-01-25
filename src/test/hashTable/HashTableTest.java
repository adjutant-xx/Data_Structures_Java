package test.hashTable;

import hashTable.HashTable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TestAssetEngine;

/**
 * Contains unit tests for methods contained within the HashTable class.
 */
public class HashTableTest {

    private TestAssetEngine engine;
    private HashTable<String, Integer> hashTable;

    public HashTableTest() {
        this.engine = new TestAssetEngine();
    }

    @Before
    public void initialize() {
        this.hashTable = new HashTable<>();
    }

    @Test
    public void hashTablePutTest() throws Exception {
        String[] arr = {"John", "Jane", "Matt", "Chief", "Matt", "Foobar"};
        for(String s : arr) {
            boolean expected = true;
            boolean actual = this.hashTable.put(s, this.engine.generateRandomInteger());
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void hashTableGetTest() throws Exception {
        String[] keyArr = {"Matthew", "Mark", "Luke", "John", "Dolan"};
        Integer[] valueArr = new Integer[keyArr.length];
        for(int i = 0; i < keyArr.length; i++) {
            int val = this.engine.generateRandomInteger();
            valueArr[i] = val;
            this.hashTable.put(keyArr[i], valueArr[i]);
        }
        for(int i = 0; i < keyArr.length; i++) {
            int expected = valueArr[i];
            int actual = this.hashTable.get(keyArr[i]);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void hashTableContainsKeyTest() throws Exception {
        String[] validArr = {"Luke", "Leia", "Han", "Chewie", "C3P0", "R2", "Vader"};
        String[] invalidArr = {"Cat", "Dog", "Bird", "Fish"};
        for(String s : validArr) {
            this.hashTable.put(s, this.engine.generateRandomInteger());
        }
        for(String s : validArr) {
            boolean expected1 = true;
            boolean actual1 = this.hashTable.containsKey(s);
            Assert.assertEquals(expected1, actual1);
        }
        for(String s : invalidArr) {
            boolean expected2 = false;
            boolean actual2 = this.hashTable.containsKey(s);
            Assert.assertEquals(expected2, actual2);
        }
    }

    @Test
    public void hashTableRemoveTest() throws Exception {
        String[] arr = {"Audi", "Beamer", "Benz", "Bentley"};
        for(String s : arr) {
            this.hashTable.put(s, this.engine.generateRandomInteger());
        }
        for(String s : arr) {
            boolean expected1 = true;
            boolean actual1 = this.hashTable.remove(s);
            Assert.assertEquals(expected1, actual1);
            boolean expected2 = false;
            boolean actual2 = this.hashTable.containsKey(s);
            Assert.assertEquals(expected2, actual2);
        }
    }

    @Test
    public void hashTableGetSizeTest() throws Exception {
        String[] arr = {"Alpha", "Beta", "Charlie", "Delta", "Echo", "Gamma", "Foxtrot"};
        int count = 0;
        for(String s : arr) {
            this.hashTable.put(s, this.engine.generateRandomInteger());
            count++;
            int expected1 = count;
            int actual1 = this.hashTable.getSize();
            Assert.assertEquals(expected1, actual1);
        }
        for(String s : arr) {
            this.hashTable.remove(s);
            count--;
            int expected2 = count;
            int actual2 = this.hashTable.getSize();
            Assert.assertEquals(expected2, actual2);
        }
    }

    @Test
    public void hashTableIsEmptyTest() throws Exception {
        String[] arr = {"Apple", "Banana", "Cranberry", "Dumpling"};
        boolean expected1 = true;
        boolean actual1 = this.hashTable.isEmpty();
        Assert.assertEquals(expected1, actual1);
        for(String s : arr) {
            this.hashTable.put(s, this.engine.generateRandomInteger());
            boolean expected2 = false;
            boolean actual2 = this.hashTable.isEmpty();
            Assert.assertEquals(expected2, actual2);
        }
        for(String s : arr) {
            boolean expected3 = false;
            boolean actual3 = this.hashTable.isEmpty();
            Assert.assertEquals(expected3, actual3);
            this.hashTable.remove(s);
        }
        boolean expected4 = true;
        boolean actual4 = this.hashTable.isEmpty();
        Assert.assertEquals(expected4, actual4);
    }

}
