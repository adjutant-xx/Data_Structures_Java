package List.LinkedList;

import org.junit.Test;

public class LinkedList_Test {

    private LinkedList<Integer> _linkedList = new LinkedList<Integer>();
    private int[] _listElements = {117,21,5,2,0,99999,25,55};

    @Test
    public void testInsert() throws Exception{
        for(Integer item : _listElements){
            boolean isInserted = _linkedList.insert(item);
            assert(isInserted);
        }
    }

    @Test
    public void testGetRoot() throws Exception{
        testInsert();
        LinkedListNode<Integer> root = _linkedList.getRoot();
        assert(root.getValue() == _listElements[_listElements.length - 1]);
    }

    @Test
    public void testGetSize() throws Exception{
        testInsert();
        int size = _linkedList.getSize();
        assert(size == _listElements.length);
    }

    @Test
    public void testTraverse() throws Exception{
        testInsert();
        boolean traverse = _linkedList.traverse();
        assert(traverse);
    }
}
