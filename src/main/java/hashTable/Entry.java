package hashTable;

/**
 * Contains implementations for an Entry object, to be used with Hashtable-based data structures.
 */
public class Entry<K, V> {
    private K key;
    private V value;

    public Entry() {}

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
