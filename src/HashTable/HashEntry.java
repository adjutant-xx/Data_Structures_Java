package HashTable;

public class HashEntry<T, V> {

    public HashEntry(T k, V v){
        key = k;
        value = v;
    }

    private T key;
    private V value;

    public V getValue(){
        return value;
    }

    public T getKey() {
        return key;
    }
}