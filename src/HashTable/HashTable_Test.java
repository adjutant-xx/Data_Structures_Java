package HashTable;

import org.junit.Test;

public class HashTable_Test {

    private HashTable<Integer, String> _hashTable = new HashTable(8);
    private HashEntry<Integer,String>[] _hashTableEntries = new HashEntry[]{new HashEntry(1,"cat"), new HashEntry(2,"dog"), new HashEntry(3,"fish"), new HashEntry(4,"mouse"), new HashEntry(5,"bird"), new HashEntry(6,"chicken"), new HashEntry(7,"cow"), new HashEntry(8,"fly")};

    @Test
    public void testHashTableInsert() throws Exception{
        int insertionCount = 0;
        for(HashEntry entry : _hashTableEntries){
            boolean isInserted = _hashTable.insert(entry);
            assert(isInserted);
            insertionCount++;
            assert(_hashTable.getCount() == insertionCount);
        }
        assert(_hashTable.getCount() == _hashTable.getTableSize());
    }

    @Test
    public void testHashTableContainsEntry() throws Exception{
        testHashTableInsert();
        HashEntry<Integer, String> validTerm = _hashTableEntries[2];
        HashEntry<Integer, String> invalidTerm = new HashEntry<Integer, String>(4,"lizard");
        boolean containsTrue = _hashTable.containsEntry(validTerm);
        boolean containsFalse = _hashTable.containsEntry(invalidTerm);
        assert(containsTrue);
        assert(!containsFalse);
    }

    @Test
    public void testHashTableGet() throws Exception{
        testHashTableInsert();
        HashEntry<Integer, String> searchEntry = _hashTableEntries[6];
        HashEntry<Integer, String> retrieval = _hashTable.get(searchEntry.getKey());
        assert(retrieval.equals(searchEntry));
    }

    @Test
    public void testHashTableFind() throws Exception{
        testHashTableInsert();
        HashEntry<Integer, String> validEntry = _hashTableEntries[3];
        HashEntry<Integer, String> invalidEntry = new HashEntry<Integer, String>(99,"octopus");
        int validLocation = _hashTable.find(validEntry);
        int invalidLocation = _hashTable.find(invalidEntry);
        assert(0 < validLocation && validLocation < _hashTable.getTableSize());
        assert(invalidLocation == -1);
    }
}
