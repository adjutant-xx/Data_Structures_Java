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
        System.out.println("-------------\n");

        //Check to see if the hash table contains a value that we just inserted (expecting true):
        HashEntry searchValueContains = hashEntries[2];
        if(hashTable.contains(searchValueContains) == true){
            System.out.println("Hash table contains entry with key: [" + searchValueContains.getKey() + "]");
        }
        else{
            System.out.println("Hash table does not contain entry with key: [" + searchValueContains.getKey() + "]");
        }
        System.out.println("-------------\n");

        //Check to see if the hash table contains a value that is not present within the table (expecting false):
        HashEntry searchValueMissing = new HashEntry("Damian", 49);
        if(hashTable.contains(searchValueMissing) == true){
            System.out.println("Hash table contains entry with key: [" + searchValueMissing.getKey() + "]");
        }
        else{
            System.out.println("Hash table does not contain entry with key: [" + searchValueMissing.getKey() + "]");
        }
        System.out.println("-------------\n");

        //Remove an entry from the hash table, and subsequently check to see if that entry still exists or not (expecting false):
        HashEntry removal = hashEntries[1];
        hashTable.remove(removal);
        if(hashTable.contains(removal)){
            System.out.println("Hash table contains entry with key: [" + removal.getKey() + "]");
        }
        else{
            System.out.println("Hash table does not contain entry with key: [" + removal.getKey() + "]");
        }
        System.out.println("-------------\n");
    }
}
