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
    public boolean remove(T value) {
        try {
            this.root = remove(this.root, value);
            this.size--;
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    private BinaryTreeNode<T> remove(BinaryTreeNode<T> node, T value) {
        if(!isEmpty()) {
            while(node != null) {
                int result = value.compareTo(node.getData());
                if (result == 0) {
                    if (node.getLeft() != null && node.getRight() != null) {
                        node = findMin(node.getRight());
                        remove(node.getRight(), node.getData());
                    } else {
                        node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
                    }
                } else if (result < 0) {
                    node = node.getLeft();
                } else {
                    node = node.getRight();
                }
            }
        }
        return node;
    }

    // find
    public BinaryTreeNode<T> find(T value) {
        return find(this.root, value);
    }
    private BinaryTreeNode<T> find(BinaryTreeNode<T> node, T value) {
        if(node == null) {
            return node;
        }
        int result = value.compareTo(node.getData());
        if(result == 0) {
            return node;
        } else if(result < 0) {
            return find(node.getLeft(), value);
        } else {
            return find(node.getRight(), value);
        }
    }

    // findMin
    public BinaryTreeNode<T> findMin() {
        return findMin(this.root);
    }
    private BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
        if(!isEmpty()) {
            while(node.getLeft() != null) {
                node = node.getLeft();
            }
            return node;
        }
        return null;
    }

    // findMax
    public BinaryTreeNode<T> findMax() {
        return findMax(this.root);
    }
    private BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
        if(!isEmpty()) {
            while(node.getRight() != null) {
                node = node.getRight();
            }
            return node;
        }
        return null;
    }

    // traverse in order
    public DoublyLinkedList<BinaryTreeNode<T>> traverseInOrder() {
        return traverseInOrder(this.root, new DoublyLinkedList<>());
    }
    private DoublyLinkedList<BinaryTreeNode<T>> traverseInOrder(BinaryTreeNode<T> node, DoublyLinkedList<BinaryTreeNode<T>> order) {
        if(node == null) {
            return order;
        }
        traverseInOrder(node.getLeft(), order);
        order.insertEnd(node);
        traverseInOrder(node.getRight(), order);
        return order;
    }

    // traverse pre order
    public DoublyLinkedList<BinaryTreeNode<T>> traversePreOrder() {
        return traversePreOrder(this.root, new DoublyLinkedList<>());
    }
    private DoublyLinkedList<BinaryTreeNode<T>> traversePreOrder(BinaryTreeNode<T> node, DoublyLinkedList<BinaryTreeNode<T>> order) {
        if(node == null) {
            return order;
        }
        order.insertEnd(node);
        traversePreOrder(node.getLeft(), order);
        traversePreOrder(node.getRight(), order);
        return order;
    }

    // traverse post order:
    public DoublyLinkedList<BinaryTreeNode<T>> traversePostOrder() {
        return traversePostOrder(this.root, new DoublyLinkedList<>());
    }
    private DoublyLinkedList<BinaryTreeNode<T>> traversePostOrder(BinaryTreeNode<T> node, DoublyLinkedList<BinaryTreeNode<T>> order) {
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
