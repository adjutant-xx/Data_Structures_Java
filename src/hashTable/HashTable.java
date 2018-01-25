package hashTable;

import java.util.Arrays;

/**
 * Contains operational implementations for the HashTable data structure.
 */
public class HashTable<K, V> {

    /**
     * NOTE: need to implement SEPARATE CHAINING for hash collision.
     */

    private Entry<K, V>[] table;
    private int size;

    public HashTable() {
        this.table = new Entry[4];
    }

    public V get(K key) throws Exception {
        try {
            return this.table[hasher(key)].getValue();
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    public boolean put(K key, V value) throws Exception {
        try {
            if(containsKey(key)) {
                this.table[hasher(key)].setValue(value);
            } else {
                this.table[hasher(key)] = new Entry<>(key, value);
            }
            this.size++;
            return true;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    public boolean containsKey(K key) throws Exception {
        try {
            if(this.table[hasher(key)] != null) {
                if(this.table[hasher(key)].getKey().equals(key)) {
                    return true;
                }
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    public boolean remove(K key, V value) throws Exception {
        try {
            if(containsKey(key)) {
                this.table[hasher(key)] = null;
            }
            return false;
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    // hash function:
    private int hasher(K key) {
        return key.hashCode() % this.table.length;
    }

    private void resize() throws Exception {
        try {
            if(this.size / this.table.length > 0.70) {
                this.table = Arrays.copyOf(this.table, this.table.length * 2);
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
