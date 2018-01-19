package test.tree;

import org.junit.Before;
import org.junit.Test;
import tree.BinarySearchTree;
import util.TestAssetEngine;

public class BinarySearchTreeTest {

    private TestAssetEngine engine;
    private BinarySearchTree<Integer> bst;

    public BinarySearchTreeTest() {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(200).upperBoundSize(10));
    }

    @Before
    public void initialize() {
        this.bst = new BinarySearchTree<>();
    }


}
