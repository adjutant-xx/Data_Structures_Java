package BinaryTree;

public class Main {
    public static void main(String[] args){

        BinarySearchTree bst = new BinarySearchTree();

        //Populate a new Binary Search Tree (BST):
        bst.insert(12);
        bst.insert(1115);
        bst.insert(555);
        bst.insert(123456789);
        bst.insert(1);
        bst.insert(2);
        bst.insert(14);

        //Traverse the BST using Inorder Traversal:
        bst.traverseInOrderCall();
        System.out.println("-------------\n");

        //Traverse the BST using Preorder Traversal:
        bst.traversePreOrderCall();
        System.out.println("-------------\n");

        //Traverse the BST using Postorder Traversal:
        bst.traversePostOrderCall();
        System.out.println("-------------\n");

        //Insert a new node, and traverse the BST using Inorder Traversal:
        bst.insert(0);
        bst.traverseInOrderCall();
        System.out.println("-------------\n");

        //Check to see if tree contains a certain value (expecting true):
        boolean isPresentTrue = bst.contains(1115);
        bst.printValue(isPresentTrue);
        System.out.println("-------------\n");

        //Check to see if tree contains a certain value (expecting false):
        boolean isPresentFalse = bst.contains(117);
        bst.printValue(isPresentFalse);
        System.out.println("-------------\n");

        //Find the smallest value in the tree:
        Node min = bst.findMin();
        bst.printValue(min.getValue());
        System.out.println("-------------\n");

        //Find the largest value in the tree:
        Node max = bst.findMax();
        bst.printValue(max.getValue());
        System.out.println("-------------\n");

        //Remove a node from the tree, and traverse using Inorder Traversal:
        bst.remove(555);
        bst.traverseInOrderCall();
        System.out.println("-------------\n");


    }
}
