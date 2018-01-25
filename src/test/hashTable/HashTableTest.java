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
            boolean expected1 = true;
            boolean actual1 = this.hashTable.put(s, this.engine.generateRandomInteger());
            Assert.assertEquals(expected1, actual1);
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

}
