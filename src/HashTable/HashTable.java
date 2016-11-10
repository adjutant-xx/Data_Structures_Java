// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package HashTable;
import List.LinkedList.LinkedList;

/*
* SUMMARY:  A custom HashTable class of a fixed-size. Utilizes a custom LinkedList structure of HashEntry objects, which
*               represent individual 'buckets' within the HashTable itself.
* */
public class HashTable<T, V> {

    /*
    * SUMMARY:  Constructor used for initializing the HashTable with a fixed size
    * */
    public HashTable(int size){
        _count = 0;
        _tableSize = size;
        _hashTable = new LinkedList[_tableSize];
        for(int i = 0; i < _hashTable.length; i++){
            _hashTable[i] = new LinkedList<HashEntry<T, V>>();
        }
    }

    private int _count;
    private int _tableSize;
    private LinkedList<HashEntry<T, V>>[] _hashTable;

    /*
    * SUMMARY:  Hash function used to populate the LinkedList of HashEntry objects through a separate-chaining technique.
    *           This particular hash function determines a hash location through use of Horner's Rule, but creating a
    *               polynomial function of 37.
    *           Here, keys are also assumed to be Characters...may be standardized at a later date.
    * */
    private int hashFunction(T key){
        int hashValue = 0;
        String convertedKey = key.toString();
        for(Character c : convertedKey.toCharArray()){
            hashValue = 37 * hashValue + c;
        }
        return Math.abs(hashValue % _tableSize);
    }

    /*
    * SUMMARY:  A method that determines whether or not the HashTable contains a given entry.
    * */
    public boolean containsEntry(HashEntry<T, V> entry){
        int hash = hashFunction(entry.getKey());
        if(0 < hash && hash < _tableSize){
            if(_hashTable[hash].contains(entry)){
                return true;
            }
        }
        return false;
    }

        /*
    * SUMMARY:  A method that returns a given key-value pair object given a specific key to search.
    *           Returns the first result of a search within the specific hashed bucket.
    * */
    public HashEntry<T, V> get(T key){
        int hash = hashFunction(key);
        if(0 < hash && hash < _tableSize){
            return _hashTable[hash].getElementAt(0);
        }
        return null;
    }

    /*
    * SUMMARY:  A method that determines which bucket contains a given hash entry
    * */
    public int find(HashEntry<T, V> entry){
        int index = 0;
        for(LinkedList<HashEntry<T, V>> list : _hashTable){
            if(list.contains(entry)){
                return index;
            }
            index++;
        }
        return -1;
    }

    /*
    * SUMMARY:  A method that inserts a given entry into the HashTable.
    *           Returns true if the entry was inserted successfully, false if the entry was already present or otherwise
*                   failed to insert.
    * */
    public boolean insert(HashEntry<T, V> entry){
        try {
            int hashLocation = hashFunction(entry.getKey());
            _hashTable[hashLocation].insert(entry);
            _count++;
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    /*
    * SUMMARY:  A method that removes a given entry from the HashTable.
    *           Returns true if the entry was successfully removed, false if the entry was not found or otherwise failed
    *               to be removed.
    * */
    public boolean remove(HashEntry<T, V> entry){
        int index = find(entry);
        if(index > -1){
            if(_hashTable[index].remove(entry)){
                _count--;
                return true;
            }
        }
        return false;
    }

    /*
    * SUMMARY:  A method that returns the value of the size of the HashTable as an integer.
    * */
    public int getTableSize(){
        return _tableSize;
    }

    /*
    * SUMMARY:  A method that returns the value of the current number of elements within
    *               the HashTable as an integer.
    * */
    public int getCount(){
        return _count;
    }
}