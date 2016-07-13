package HashTable;
import LinkedList.LinkedList;

public class HashTable {



    private int tableSize;

    LinkedList[] hashtable; //Utilizing an array of LinkedLists, to reflect Separate Chaining.

    public HashTable(int size){
        tableSize = size;
        hashtable = new LinkedList[tableSize];
        for(int i = 0; i < hashtable.length; i++){
            hashtable[i] = new LinkedList();
        }
    }

    private int hashFunction(String key){
        int hashValue = 0;
        for(Character c : key.toCharArray()){
            hashValue = 37 * hashValue + c; //Hash Function that computes a polynomial function (of 37) by use of Horner's Rule.
        }
        return Math.abs(hashValue % tableSize); //Ensure that no negative locations are generated.
    }

    public boolean contains(String key){
        for(LinkedList list : hashtable){
            if(list.contains(key)){
                return true;
            }
        }
        return false;
    }

    public boolean insert(String key, Object value){
        if(!contains(key)){
            int hashLocation = hashFunction(key);
            hashtable[hashLocation].insertEnd(value);
            return true;
        }
        return false;
    }
}
