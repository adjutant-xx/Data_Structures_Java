package hashTable;

import list.ListNode;
import list.SinglyLinkedList;

import java.util.Arrays;

/**
 * Contains operational implementations for the HashTable data structure.
 * Utilizes separate chaining hash collision and prime number dynamic resizing mechanics.
 */
public class HashTable<K, V> {

    private ListNode<Entry<K, V>>[] table;
    private int size;
    private final int initSize = 5;
    private final double loadFactor = 0.70;
    private final int resizeFactor = 2;

    // note: choose prime # for table size
    public HashTable() {
        this.table = new ListNode[this.initSize];
        for(int i = 0; i < this.table.length; i++) {
            this.table[i] = new ListNode<>();
        }
    }

    public V get(K key) throws Exception {
        try {
            ListNode<Entry<K, V>> bucket = getBucket(key);
            while(bucket != null) {
                if(bucket.getData().getKey().equals(key)) {
                    return bucket.getData().getValue();
                }
            }
            return null;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    public boolean put(K key, V value) throws Exception {
        try {
            if(put(new Entry<>(key, value))) {
                this.size++;
                resize();
                return true;
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }
    private boolean put(Entry<K, V> entry) throws Exception {
        try {
            // if bucket's data at hash index is empty, add entry
            if(this.table[hashFunction(entry.getKey())] == null) { // if bucket is null
                this.table[hashFunction(entry.getKey())] = new ListNode<>(entry);
                return true;
            } else if(this.table[hashFunction(entry.getKey())].getData() == null) { // if bucket holds no entry data
                this.table[hashFunction(entry.getKey())].setData(entry);
                return true;
            } else { // if bucket contains data:
                // iterate through bucket until a. bucket with data containing key is found, b. bucket with no entry data is found, or c. null bucket is found
                ListNode<Entry<K, V>> tempBucket = this.table[hashFunction(entry.getKey())];
                if(tempBucket.getData().getKey().equals(entry.getKey())) { // if bucket contains correct entry key data
                    tempBucket.getData().setValue(entry.getValue());
                    return true;
                }
                while(tempBucket.getNext() != null) {
                    if(tempBucket.getData().getKey().equals(entry.getKey())) { // if bucket contains correct entry key data
                        tempBucket.getData().setValue(entry.getValue());
                        return true;
                    } else { // check next bucket in list
                        tempBucket = tempBucket.getNext();
                    }
                }
                // null bucket has been found, add new entry data:
                tempBucket.setNext(new ListNode<>(entry));
                return true;
            }
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    public boolean containsKey(K key) throws Exception {
        try {
            ListNode<Entry<K, V>> bucket = getBucket(key);
            while(bucket != null) {
                if(bucket.getData().getKey().equals(key)) {
                    return true;
                }
                bucket = bucket.getNext();
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    public boolean remove(K key, V value) throws Exception {
        try {
            ListNode<Entry<K, V>> bucket = getBucket(key);
            ListNode<Entry<K, V>> prev = null;
            while(bucket != null) {
                if(bucket.getData().getKey().equals(key)) {
                    if(prev != null) {
                        ListNode<Entry<K, V>> temp = bucket;
                        bucket = prev;
                        bucket.setNext(temp.getNext());
                        this.size--;
                        return true;
                    }
                }
                prev = bucket;
                bucket = bucket.getNext();
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    private ListNode<Entry<K, V>> getBucket(K key) {
        return this.table[hashFunction(key)];
    }

    // handle negative hashes:
    private int hashFunction(K key) {
        int hash = key.hashCode() % this.table.length;
        return (hash < 0) ? hash * -1 : hash;
    }

    // rehash every element into new array:
    private void resize() throws Exception {
        try {
            if(this.size / (double)this.table.length > this.loadFactor) {
                int newSize = this.table.length * this.resizeFactor;
                while(newSize % 2 == 0 || newSize % 3 == 0) { // find > double current size prime number for new table size.
                    newSize++;
                }
                SinglyLinkedList<ListNode<Entry<K, V>>> oldEntries = new SinglyLinkedList(); // store current data to be rehashed later.
                for(int i = 0, iter = 0; i < this.table.length; i++) {
                    if(this.table[i].getData() != null) {
                        oldEntries.insertEnd(this.table[i]);
                    }
                }
                this.table = new ListNode[newSize];
                for(int i = 0; i < this.table.length; i++) {
                    this.table[i] = new ListNode<>();
                }
//                for(int i = 0; i < oldEntries.length; i++) { // rehash all old values into new array
//                    put(oldEntries[i].getData().getKey(), oldEntries[i].getData().getValue());
//                }
                for(int i = 0; i < oldEntries.getSize(); i++) { // rehash old values into newly-allocated array.
                    ListNode<Entry<K, V>> oldEntry = oldEntries.getElementAt(i);
                    while(oldEntry != null) {
                        put(oldEntry.getData().getKey(), oldEntry.getData().getValue());
                        this.size--; // ensure that size isn't being artificially inflated.
                        oldEntry = oldEntry.getNext();
                    }
                }
            }
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    public boolean isEmpty() throws Exception {
        try {
            return this.size <= 0;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

}
