package tree;

import jdk.nashorn.api.tree.BinaryTree;
import list.DoublyLinkedList;

import java.lang.reflect.Array;

/**
 * Contains operational implementations for the Binary Search Tree data structure.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryTreeNode<T> root;
    private int size;

    // insert
    public boolean insert(T value) {
        try {
            this.root = insert(this.root, value);
            this.size++;
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    private BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T value) {
        if(node == null) {
            return new BinaryTreeNode<>(value);
        }
        int result = value.compareTo(node.getData());
        if(result <= 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }

    // remove
    public void remove(BinaryTreeNode<T> node, T value) {
        if(!isEmpty()) {
            BinaryTreeNode<T> temp = node;
            while(temp != null) {
                int result = temp.getData().compareTo(value);
                if (result == 0) {
                    if (temp.getLeft() != null && temp.getRight() != null) {
                        temp = findMin(temp.getRight());
                        remove(temp.getRight(), temp.getData());
                    } else {
                        temp = (temp.getLeft() != null) ? temp.getLeft() : temp.getRight();
                    }
                    this.size--;
                } else if (result < 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
    }

    // find
    public BinaryTreeNode<T> find(BinaryTreeNode<T> node, T value) {
        if(!isEmpty()) {
            BinaryTreeNode<T> temp = node;
            while(temp != null) {
                calculateFork(temp, value);
            }
        }
        return null;
    }

    // findMin
    public BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
        if(!isEmpty()) {
            BinaryTreeNode<T> temp = node;
            while(temp.getLeft() != null) {
                temp = temp.getLeft();
            }
            return temp;
        }
        return null;
    }

    // findMax
    public BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
        if(!isEmpty()) {
            BinaryTreeNode<T> temp = node;
            while(temp.getRight() != null) {
                temp = temp.getRight();
            }
            return temp;
        }
        return null;
    }

    // traverse in order
    public DoublyLinkedList<BinaryTreeNode<T>> traverseInOrder(BinaryTreeNode<T> node, DoublyLinkedList<BinaryTreeNode<T>> order) {
        if(node == null) {
            return order;
        }
        traverseInOrder(node.getLeft(), order);
        order.insertEnd(node);
        traverseInOrder(node.getRight(), order);
        return order;
    }

    // traverse pre order
    public DoublyLinkedList<BinaryTreeNode<T>> traversePreOrder(BinaryTreeNode<T> node, DoublyLinkedList<BinaryTreeNode<T>> order) {
        if(node == null) {
            return order;
        }
        order.insertEnd(node);
        traversePreOrder(node.getLeft(), order);
        traversePreOrder(node.getRight(), order);
        return order;
    }

    // traverse post order:
    public DoublyLinkedList<BinaryTreeNode<T>> traversePostOrder(BinaryTreeNode<T> node, DoublyLinkedList<BinaryTreeNode<T>> order) {
        if(node == null) {
            return order;
        }
        traversePostOrder(node.getLeft(), order);
        traversePostOrder(node.getRight(), order);
        order.insertEnd(node);
        return order;
    }

    //getRoot
    public BinaryTreeNode<T> getRoot() {
        return this.root;
    }

    // calculateFork
    private BinaryTreeNode<T> calculateFork(BinaryTreeNode<T> node, T value) {
        int result = value.compareTo(node.getData());
        if(result <= 0) {
            return node.getLeft();
        } else {
            return node.getRight();
        }
    }

    // to array:
    public T[] toArray(Class<T> clazz) {
        return toArray((T[])Array.newInstance(clazz, this.size), 0, this.root);
    }
    private T[] toArray(T[] arr, int i, BinaryTreeNode<T> node) {
        if(node == null || i > this.size - 1) {
            return arr;
        }
        arr[i] = node.getData();
        arr = (node.getLeft() != null) ? toArray(arr, (2 * i) + 1, node.getLeft()) : arr;
        arr = (node.getRight() != null) ? toArray(arr, (2 * i) + 2, node.getRight()) : arr;
        return arr;
    }

    // to tree:
    public void toTree(T[] arr) {
        for(int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    // isEmpty
    public boolean isEmpty() {
        if(this.root == null) {
            return true;
        }
        return false;
    }

    // getSize
    public int getSize() {
        return this.size;
    }

}
