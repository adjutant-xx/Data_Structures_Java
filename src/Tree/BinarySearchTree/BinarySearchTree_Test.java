package Tree.BinarySearchTree;

import org.junit.Test;

public class BinarySearchTree_Test {
    private BinarySearchTree<Integer> _binarySearchTree = new BinarySearchTree<Integer>();
    private int[] _binarySearchTreeElements = {117,21,5,2,0,99999,25,55};

    @Test
    public void testBinarySearchTreeInsert() throws Exception{
        for(Integer item : _binarySearchTreeElements){
            boolean isInserted = _binarySearchTree.insert(item);
            assert(isInserted);
        }
    }
}
