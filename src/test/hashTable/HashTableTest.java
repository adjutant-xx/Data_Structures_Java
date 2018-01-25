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
        String[] arr = {"John", "Jane", "Matt", "Chief", "Foobar"};
        for(String s : arr) {
            boolean expected1 = true;
            boolean actual1 = this.hashTable.put(s, this.engine.generateRandomInteger());
            Assert.assertEquals(expected1, actual1);
        }
    }

}
