package HashTable;

public class Main {
    public static void main(String[] args){

        //Run tests for Hash Table:
        System.out.println("--------------------------\n");
        System.out.println("Hash Table");
        System.out.println("-------------\n");

        //Instantiate a new hash table of a given size:
        final int HASH_TABLE_SIZE = 12;
        int tableSize = HASH_TABLE_SIZE;
        HashTable hashTable = new HashTable(tableSize);

        //Populate the newly-created hash table:
        //NOTE: key-value pairs in this case are people's names (key), with their corresponding ages (value).
        HashEntry[] hashEntries = {
                new HashEntry("Matthew", 25),
                new HashEntry("Mark", 55),
                new HashEntry("Luke", 24),
                new HashEntry("John", 999)
        };
        for(HashEntry entry : hashEntries){
            if(hashTable.insert(entry)){
                System.out.println("Hash entry with key: [" + entry.getKey() + "] added to hash table successfully.");
            }
        }
    }
}
