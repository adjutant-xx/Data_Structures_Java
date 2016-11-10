package List.LinkedList;

import org.junit.Test;

public class LinkedList_Test {

    private LinkedList<Integer> _linkedList = new LinkedList<Integer>();
    private int[] _listElements = {117,21,5,2,0,99999,25,55};

    @Test
    public void testLinkedListInsert() throws Exception{
        for(Integer item : _listElements){
            boolean isInserted = _linkedList.insert(item);
            assert(isInserted);
        }
    }

    @Test
    public void testLinkedListGetRoot() throws Exception{
        testLinkedListInsert();
        LinkedListNode<Integer> root = _linkedList.getRoot();
        //assert(root.getValue() == _listElements[_listElements.length - 1]);
        assert(root.getValue().equals(_listElements[_listElements.length - 1]));
    }

    @Test
    public void testLinkedListGetSize() throws Exception{
        testLinkedListInsert();
        int size = _linkedList.getSize();
        assert(size == _listElements.length);
    }

    @Test
    public void testLinkedListTraverse() throws Exception{
        testLinkedListInsert();
        boolean traverse = _linkedList.traverse();
        assert(traverse);
    }

    @Test
    public void testLinkedListContains() throws Exception{
        testLinkedListInsert();
        int containsTrueIndex = 3, containsFalseIndex = -9999;
        boolean containsTrue = _linkedList.contains(_listElements[containsTrueIndex]);
        boolean containsFalse = _linkedList.contains(containsFalseIndex);
        assert(containsTrue);
        assert(!containsFalse);
    }

    @Test
    public void testLinkedListFind() throws Exception{
        testLinkedListInsert();
        int validIndex = 2, invalidIndex = -9999;
        int validIndexLocation = _linkedList.find(_listElements[validIndex]);
        int invalidIndexLocation = _linkedList.find(invalidIndex);
        assert(validIndexLocation == 5);
        assert(invalidIndexLocation == -1);
    }

    @Test
    public void testLinkedListInsertEnd() throws Exception{
        testLinkedListInsert();
        int insertValue = 500;
        LinkedListNode<Integer> root = _linkedList.getRoot();
        _linkedList.insertEnd(insertValue, root);
        boolean contains = _linkedList.contains(insertValue);
        int insertedIndex = _linkedList.find(insertValue);
        assert(contains);
        assert(insertedIndex == _linkedList.getSize() - 1);
    }

    @Test
    public void testLinkedListInsertAt() throws Exception{
        testLinkedListInsert();
        int insertValue = 1200, insertIndexLocation = 4;
        LinkedListNode<Integer> root = _linkedList.getRoot();
        _linkedList.insertAt(insertValue, insertIndexLocation, root);
        boolean contains = _linkedList.contains(insertValue);
        int actualInsertedIndex = _linkedList.find(insertValue);
        assert(contains);
        assert(actualInsertedIndex == insertIndexLocation);
    }

    @Test
    public void testLinkedListRemove() throws Exception{
        testLinkedListInsert();
        int validRemoveValue = 2, invalidRemoveValue = -47;
        boolean validRemoval = _linkedList.remove(validRemoveValue);
        boolean invalidRemoval = _linkedList.remove(invalidRemoveValue);
        assert(validRemoval);
        assert(!invalidRemoval);
    }

    @Test
    public void testLinkedListRemoveFront() throws Exception{
        testLinkedListInsert();
        int rootValuePreRemoval = _linkedList.getRoot().getValue(), listOldRoot = _listElements[_listElements.length - 1], listNewRoot = _listElements[_listElements.length - 2];
        assert(listOldRoot != listNewRoot);
        boolean isFrontRemoved = _linkedList.removeFront();
        if(isFrontRemoved){
            int rootValuePostRemoval = _linkedList.getRoot().getValue();
            assert(rootValuePreRemoval != rootValuePostRemoval);
            assert(rootValuePreRemoval == listOldRoot);
            assert(rootValuePostRemoval == listNewRoot);
        }
    }

    @Test
    public void testLinkedListRemoveEnd() throws Exception{
        testLinkedListInsert();
        int listOldTail = _listElements[0], listNewTail = _listElements[1], preRemovalTailIndex = _linkedList.find(listOldTail), size = _linkedList.getSize();
        assert(preRemovalTailIndex == size - 1);
        boolean containsOldTail = _linkedList.contains(listOldTail);
        boolean containsNewTail = _linkedList.contains(listNewTail);
        assert(containsOldTail);
        assert(containsNewTail);
        boolean isEndRemoved = _linkedList.removeEnd();
        if(isEndRemoved){
            size = _linkedList.getSize();
            int postRemovalTailIndex = _linkedList.find(listNewTail);
            containsOldTail = _linkedList.contains(listOldTail);
            containsNewTail = _linkedList.contains(listNewTail);
            assert(isEndRemoved);
            assert(containsNewTail);
            assert(!containsOldTail);
            assert(postRemovalTailIndex == size - 1);
        }
    }

    @Test
    public void testLinkedListRemoveAt() throws Exception{
        testLinkedListInsert();
        int indexRemove = 5, indexReplace = 6, valueToRemove = _listElements[indexRemove], valueToReplace = _listElements[indexReplace], indexRemoveActual = _linkedList.find(valueToRemove), indexReplaceActual = _linkedList.find(valueToReplace);
        assert(_linkedList.contains(valueToRemove));
        assert(_linkedList.contains(valueToReplace));
        assert(_linkedList.removeAt(indexRemoveActual));
        if(_linkedList.removeAt(indexRemoveActual)){
            assert(!_linkedList.contains(valueToRemove));
            assert(_linkedList.contains(valueToReplace));
            assert(indexReplaceActual == _linkedList.getSize() - indexReplace + 1);
        }
    }

    @Test
    public void testLinkedListGetNode() throws Exception{
        testLinkedListInsert();
        int index = 6;
        LinkedListNode<Integer> node = _linkedList.getNode(index);
        assert(node.getValue().equals(_listElements[_listElements.length - index - 1]));
    }
}