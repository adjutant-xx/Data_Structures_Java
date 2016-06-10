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
    }
}
