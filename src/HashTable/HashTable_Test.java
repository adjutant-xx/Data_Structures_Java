package HashTable;

import org.junit.Test;

public class HashTable_Test {

    private HashTable<Integer, String> _hashTable = new HashTable(8);
    private String[] _hashTableValues = {"cat","dog","fish","mouse","bird","chicken","cow","fly"};

    @Test
    public void testHashTableInsert() throws Exception{
        int insertionCount = 0, hashTableKeyIterator = 1;
        for(String item : _hashTableValues){
            HashEntry<Integer, String> newEntry = new HashEntry<Integer, String>(hashTableKeyIterator, item);
            boolean isInserted = _hashTable.insert(newEntry);
            assert(isInserted);
            insertionCount++;
            hashTableKeyIterator++;
            assert(_hashTable.getCount() == insertionCount);
        }
        assert(_hashTable.getCount() == _hashTable.getTableSize());
    }
}
