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
        //assert(root.getValue() == _listElements[_listElements.length - 1]);
        assert(root.getValue().equals(_listElements[_listElements.length - 1]));
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

    @Test
    public void testContains() throws Exception{
        testInsert();
        int containsTrueIndex = 3, containsFalseIndex = -9999;
        boolean containsTrue = _linkedList.contains(_listElements[containsTrueIndex]);
        boolean containsFalse = _linkedList.contains(containsFalseIndex);
        assert(containsTrue);
        assert(!containsFalse);
    }

    @Test
    public void testFind() throws Exception{
        testInsert();
        int validIndex = 2, invalidIndex = -9999;
        int validIndexLocation = _linkedList.find(_listElements[validIndex]);
        int invalidIndexLocation = _linkedList.find(invalidIndex);
        assert(validIndexLocation == 5);
        assert(invalidIndexLocation == -1);
    }

    @Test
    public void testInsertEnd() throws Exception{
        testInsert();
        int insertValue = 500;
        LinkedListNode<Integer> root = _linkedList.getRoot();
        _linkedList.insertEnd(insertValue, root);
        boolean contains = _linkedList.contains(insertValue);
        int insertedIndex = _linkedList.find(insertValue);
        assert(contains);
        assert(insertedIndex == _linkedList.getSize() - 1);
    }

    @Test
    public void testInsertAt() throws Exception{
        testInsert();
        int insertValue = 1200, insertIndexLocation = 4;
        LinkedListNode<Integer> root = _linkedList.getRoot();
        _linkedList.insertAt(insertValue, insertIndexLocation, root);
        boolean contains = _linkedList.contains(insertValue);
        int actualInsertedIndex = _linkedList.find(insertValue);
        assert(contains);
        assert(actualInsertedIndex == insertIndexLocation);
    }

    @Test
    public void testRemove() throws Exception{
        testInsert();
        int validRemoveValue = 2, invalidRemoveValue = -47;
        boolean validRemoval = _linkedList.remove(validRemoveValue);
        boolean invalidRemoval = _linkedList.remove(invalidRemoveValue);
        assert(validRemoval);
        assert(!invalidRemoval);
    }
}
