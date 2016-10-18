// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package HashTable;
import LinkedList.LinkedList;

/*
* A custom HashTable class of a fixed-size. Utilizes a custom LinkedList structure of HashEntry objects, which
*   represent individual 'buckets' within the HashTable itself.
* */
public class HashTable<T, V> {

    /*
    * Constructor used for initializing the HashTable with a fixed size
    * */
    public HashTable(int size){
        tableSize = size;
        hashTable = new LinkedList[tableSize];
        for(int i = 0; i < hashTable.length; i++){
            hashTable[i] = new LinkedList<HashEntry<T, V>>();
        }
    }

    private int tableSize;
    private LinkedList<HashEntry<T, V>>[] hashTable;

    /*
    * Hash function used to populate the LinkedList of HashEntry objects through a separate-chaining technique.
    * This particular hash function determines a hash location through use of Horner's Rule, but creating a
    *   polynomial function of 37.
    * Here, keys are also assumed to be Characters...may be standardized at a later date.
    * */
    private int hashFunction(T key){
        int hashValue = 0;
        String convertedKey = key.toString();
        for(Character c : convertedKey.toCharArray()){
            hashValue = 37 * hashValue + c;
        }
        return Math.abs(hashValue % tableSize);
    }

    /*
    * A method to determine whether or not the HashTable contains a given value (entry).
    * */
    public boolean contains(HashEntry<T, V> entry){
        for(LinkedList<HashEntry<T, V>> list : hashTable){
            if(list.contains(entry) == true){
                return true;
            }
        }
        return false;
    }


    /*
    * A method that determines which bucket contains a given hash entry
    * */
    public int find(HashEntry<T, V> entry){
        int index = 0;
        for(LinkedList<HashEntry<T, V>> list : hashTable){
            if(list.contains(entry)){
                return index;
            }
            index++;
        }
        return -1;
    }

    /*
    * A method that inserts a given entry into the HashTable.
    * Returns true if the entry was inserted successfully, false if the entry was already present or otherwise
    *   failed to insert.
    * */
    public boolean insert(HashEntry<T, V> entry){
        if(!contains(entry)){
            int hashLocation = hashFunction(entry.getKey());
            hashTable[hashLocation].insert(entry);
            return true;
        }
        return false;
    }

    /*
    * A method that removes a given entry from the HashTable.
    * Returns true if the entry was successfully removed, false if the entry was not found or otherwise failed
    *   to be removed.
    * */
    public boolean remove(HashEntry<T, V> entry){
        int index = find(entry);
        if(index > -1){
            if(hashTable[index].remove(entry)){
                return true;
            }
        }
        return false;
    }
}