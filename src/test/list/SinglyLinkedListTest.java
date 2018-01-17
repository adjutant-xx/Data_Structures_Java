package test.list;

import list.SinglyLinkedList;
import util.TestAssetEngine;

/**
 * Contains unit tests for methods contained within the SinglyLinkedList class.
 */
public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> list;
    private TestAssetEngine engine;

    public SinglyLinkedListTest() {
        this.list = new SinglyLinkedList<Integer>();
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(20).upperBoundSize(20));
    }

}
