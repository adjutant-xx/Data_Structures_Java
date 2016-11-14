// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package Tree.Heap;

import Tree.BinarySearchTree.BinaryTreeNode;

/*
* SUMMARY:  Represents a Min Heap data structure.
*           Utilizes binary tree nodes as part of its underlying design.
* NOTE:     This code is currently under construction, as of 10-18-2016.
* */
public class MinHeap<T> {

    private BinaryTreeNode<T> root;

    /*
    * SUMMARY:  Default constructor, initializes the root of the heap to null.
    * */
    public MinHeap(){
        root = null;
    }

    /*
    * SUMMARY:  Inserts a new node into the heap.
    *           Propagation algorithms are then used to preserve the rules of the min heap structure.
    * */
    public void upHeap(T value){
        root = upHeap(value, root);
    }
    private BinaryTreeNode<T> upHeap(T value, BinaryTreeNode<T> current){
        if(current == null){
            current = new BinaryTreeNode<T>(value);
            return current;
        }
        current = findBranch(current);
        if(current.left != null && current.right == null){
            current.right = new BinaryTreeNode<T>(value);
            current.right.parent = current;
            current = current.right;
            current = percolateUp(current);
            return current;
        }
        else if(current.left == null && current.right == null){
            current.left = new BinaryTreeNode<T>(value);
            current.left.parent = current;
            current = current.left;
            current = percolateUp(current);
            return current;
        }
        else{
            return current;
        }
    }

    /*
    * SUMMARY:  Removes the minimum value from the heap.
    *           Propagation algorithms are then used to preserve the rules of the min heap.
    * */
    public T downHeap(){
        T minimumVal = root.getValue();

        //percolate down, replacing the root with the next smallest child while recursively replacing:

        return minimumVal;
    }

    /*
    * SUMMARY:  Returns a node object parent to a leaf node within the heap.
    * */
    private BinaryTreeNode<T> findBranch(BinaryTreeNode<T> node){

        while(node != null){
            if(node.left == null || node.right == null){
                return node;
            }
            else{
                //check left subtree:
                if(node.left.left == null || node.left.right == null){
                    node = node.left;
                }
                else{
                    node = node.right;
                }
            }
        }
        return node;
    }

    /*
    * SUMMARY:  Returns the root of the heap after performing a percolation algorithm in order to preserve the
    *               rules of the min heap.
    * */
    private BinaryTreeNode<T> percolateUp(BinaryTreeNode<T> node){

        //while((Integer)node.getValue() < (Integer)node.parent.getValue()){
        while(node.parent != null){

            if((Integer)node.getValue() < (Integer)node.parent.getValue()) {
                T temp = node.getValue();
                node.setValue(node.parent.getValue());
                node.parent.setValue(temp);
            }
            node = node.parent;
        }
        return node;
    }
}
