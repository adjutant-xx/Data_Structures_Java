// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

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