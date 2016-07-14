package HashTable;
import LinkedList.LinkedList;

public class HashTable<T, V> {

    public HashTable(int size){
        tableSize = size;
        hashTable = new LinkedList[tableSize];
        for(int i = 0; i < hashTable.length; i++){
            hashTable[i] = new LinkedList<HashEntry<T, V>>();
        }
    }

    private int tableSize;
    private LinkedList<HashEntry<T, V>>[] hashTable; //Utilizing an array of LinkedLists, to reflect Separate Chaining.

    private int hashFunction(T key){
        int hashValue = 0;
        String convertedKey = key.toString();
        for(Character c : convertedKey.toCharArray()){ //Implying that keys are strings
            hashValue = 37 * hashValue + c; //Hash Function that computes a polynomial function (of 37) by use of Horner's Rule.
        }
        return Math.abs(hashValue % tableSize); //Ensure that no negative locations are generated.
    }

    public boolean contains(HashEntry<T, V> entry){
        for(LinkedList<HashEntry<T, V>> list : hashTable){
            if(list.contains(entry)){
                return true;
            }
        }
        return false;
    }

    public boolean insert(HashEntry<T, V> entry){
        if(!contains(entry)){
            int hashLocation = hashFunction(entry.getKey());
            hashTable[hashLocation].insert(entry);
            return true;
        }
        return false;
    }
}