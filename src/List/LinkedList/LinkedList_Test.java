package List.LinkedList;

import org.junit.Test;

public class LinkedList_Test {

    private LinkedList<Integer> _linkedList;
    private int[] _listElements = {117,21,5,2,0,99999,25,55};

    @Test
    public void testInsert() throws Exception{
        for(Integer item : _listElements){
            boolean isInserted = _linkedList.insert(item);
            assert(isInserted);
        }
    }

}
