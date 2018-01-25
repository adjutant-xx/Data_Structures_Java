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

    public Entry(EntryBuilder<K, V> builder) {
        this.key = builder.key;
        this.value = builder.value;
    }

    public static class EntryBuilder<K, V> {
        private K key;
        private V value;

        public EntryBuilder key(K key) {
            this.key = key;
            return this;
        }

        public EntryBuilder value(V value) {
            this.value = value;
            return this;
        }
    }
}
