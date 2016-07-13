package HashTable;

public class Main {
    public static void main(String[] args){

        //Run tests for Hash Table:
        System.out.println("--------------------------\n");
        System.out.println("Linked List");
        System.out.println("-------------\n");

        //Instantiate a new hash table of a given size:
        int tableSize = 128;
        HashTable hashTable = new HashTable(tableSize);

        //Populate the newly-created hash table:
        //NOTE: key-value pairs in this case are people's names (key), with their corresponding ages (value).
        hashTable.insert("Matthew", 25);
        hashTable.insert("Mark", 55);
        hashTable.insert("Luke", 24);
        hashTable.insert("John", 999);


    }
}
