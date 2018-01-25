package hashTable;

import list.ListNode;
import list.SinglyLinkedList;

import java.util.Arrays;

/**
 * Contains operational implementations for the HashTable data structure.
 */
public class HashTable<K, V> {

    /**
     * NOTE: need to change hash value to calculate something to do with key, since size of underlying table array can change and skew existing key hashes over time...
     */

    private ListNode<Entry<K, V>>[] table;
    private int size;
    private final int initSize = 4;
    private final double loadFactor = 0.70;
    private final int resizeFactor = 2;

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
            ListNode<Entry<K, V>> bucket = getBucket(key);
            while(bucket.getData() != null) {
                if(bucket.getData().getKey().equals(key)) {
                    bucket.getData().setValue(value);
                }
                bucket = bucket.getNext();
            }
            bucket.setData(new Entry(key, value));
            this.size++;
            resize();
            return true;
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

    // hash function:
    private int hashFunction(K key) {
        return key.hashCode() % this.table.length;
    }

    private void resize() throws Exception {
        try {
            if(this.size / (double)this.table.length > this.loadFactor) {
                int count = this.table.length;
                this.table = Arrays.copyOf(this.table, this.table.length * this.resizeFactor);
                for(int i = count; i < this.table.length; i++) {
                    this.table[i] = new ListNode<>();
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
