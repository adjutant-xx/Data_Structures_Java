// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package Tree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        /*
        * NOTE 10-20-2016: Commented-out unused test code while testing DirectedGraph functionality
        * */
//        BinarySearchTree bst = new BinarySearchTree();
//
//        //Populate a new Binary Search Tree (BST):
//        bst.insert(12);
//        bst.insert(1115);
//        bst.insert(555);
//        bst.insert(123456789);
//        bst.insert(1);
//        bst.insert(2);
//        bst.insert(14);
//
//        //Traverse the BST using Inorder Traversal:
//        bst.traverseInOrderCall();
//        System.out.println("-------------\n");
//
//        //Traverse the BST using Preorder Traversal:
//        bst.traversePreOrderCall();
//        System.out.println("-------------\n");
//
//        //Traverse the BST using Postorder Traversal:
//        bst.traversePostOrderCall();
//        System.out.println("-------------\n");
//
//        //Insert a new node, and traverse the BST using Inorder Traversal:
//        bst.insert(0);
//        bst.traverseInOrderCall();
//        System.out.println("-------------\n");
//
//        //Check to see if tree contains a certain value (expecting true):
//        boolean isPresentTrue = bst.contains(1115);
//        bst.printValue(isPresentTrue);
//        System.out.println("-------------\n");
//
//        //Check to see if tree contains a certain value (expecting false):
//        boolean isPresentFalse = bst.contains(117);
//        bst.printValue(isPresentFalse);
//        System.out.println("-------------\n");
//
//        //Find the smallest value in the tree:
//        BinaryTreeNode min = bst.findMin();
//        bst.printValue(min.getValue());
//        System.out.println("-------------\n");
//
//        //Find the largest value in the tree:
//        BinaryTreeNode max = bst.findMax();
//        bst.printValue(max.getValue());
//        System.out.println("-------------\n");
//
//        //Remove a node from the tree, and traverse using Inorder Traversal:
//        bst.remove(555);
//        bst.traverseInOrderCall();
//        System.out.println("-------------\n");
//
//        //Testing Min Heap:
//        System.out.println("| -------------------------- |\n");
//        System.out.println("|   MIN HEAP                 |\n");
//        System.out.println("| -------------------------- |\n");
//
//        //Populate a new Min Heap by testing insert statements:
//        MinHeap<Integer> minHeap = new MinHeap<Integer>();
//        int[] minHeapInserts = {55,50,90,4,7,87};
//        for(Integer item : minHeapInserts){
//            minHeap.upHeap(item);
//        }
//
//        //Test min retrieval:
//        int testRetrieval = minHeap.downHeap();

        //Testing Directed Graph:
        System.out.println("| -------------------------- |\n");
        System.out.println("|   DIRECTED GRAPH           |\n");
        System.out.println("| -------------------------- |\n");

        //Populate a new Directed Graph by testing insert statements:
        Character[] graphVertexInserts = {'A','B','C','D','E','F'};
        DirectedGraph<Character> directedGraph = new DirectedGraph<Character>();
        for(Character item : graphVertexInserts){
            directedGraph.addVertex(item);
        }

        //Test vertex retrieval & edge inserts:
        Integer[][] graphEdgeInserts = {{0,1},{1,2},{2,4},{4,3},{3,2},{4,5}};
        for(Integer[] item : graphEdgeInserts){
            GraphNode<Character> parent = directedGraph.getVertex(item[0]);
            GraphNode<Character> child = directedGraph.getVertex(item[1]);
            directedGraph.addEdge(parent, child);
        }
        for(int i = 0; i < graphEdgeInserts.length; i++){
            Integer[] edgeSet = graphEdgeInserts[i];
            GraphNode<Character> parent = directedGraph.getVertex(edgeSet[0]);
        }

        //Test BFS:
        boolean testBFS = directedGraph.breadthFirstSearch(directedGraph.getVertex(3), directedGraph.getVertex(5));

        //Test neighbor retrieval:
        ArrayList<GraphNode<Character>> neighbors = directedGraph.getNeighbors(directedGraph.getVertex(1));

        //Test vertex deletion:
        directedGraph.removeVertex(directedGraph.getVertex(1));

        //Test edge deletion:
        Integer[] edge = {4,3};
        GraphNode<Character> parent = directedGraph.getVertex(edge[0]);
        GraphNode<Character> child = directedGraph.getVertex((edge[1]));
        directedGraph.removeEdge(parent, child);

        //Test graph adjacencies:
        Character[][] adjacencies = {{0,3},{4,5}};
        for(Character[] item : adjacencies){
            GraphNode<Character> x = directedGraph.getVertex(item[0]);
            GraphNode<Character> y = directedGraph.getVertex((item[1]));
            boolean check = directedGraph.isAdjacent(x, y);
        }

        //Test neighbor retrieval again:
        ArrayList<GraphNode<Character>> neighbors2 = directedGraph.getNeighbors(directedGraph.getVertex(4));


    }
}