// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/mpaauw
//
// No license, free use

package HashTable;

/*
* SUMMARY:  Represents a single 'bucket' to be used with the HashTable class.
*           Includes support for two different data types relative to the 'key' and 'value'
*               of each bucket.
* */
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