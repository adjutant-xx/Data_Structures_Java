package tree;

import list.DoublyLinkedList;

import java.lang.reflect.Array;

/**
 * Contains operational implementations for the Binary Search Tree data structure.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryTreeNode<T> root;
    private int size;

    // insert
    public void insert(T value) {
        BinaryTreeNode<T> newNode = new BinaryTreeNode<>(value);
        if(isEmpty()) {
            this.root = newNode;
        } else {
            BinaryTreeNode<T> temp = this.root;
            while(temp != null) {
                calculateFork(temp, value);
            }
            temp = newNode;
        }
        // balance tree here...
        this.size++;
    }

    // remove
    public void remove(BinaryTreeNode<T> node, T value) {
        if(!isEmpty()) {
            BinaryTreeNode<T> temp = node;
            while(temp != null) {
                int result = temp.getData().compareTo(value);
                if (result == 0) {
                    // remove
                    if (temp.getLeft() != null && temp.getRight() != null) {
                        // pull smallest value in temp's right subtree, swap with temp and then remove that value from the right subtree
                        temp = findMin(temp.getRight());
                        remove(temp.getRight(), temp.getData());
                    } else {
                        temp = (temp.getLeft() != null) ? temp.getLeft() : temp.getRight();
                    }
                    // balance tree here...
                    this.size--;
                } else if (result < 0) {
                    // traverse left
                    temp = temp.getLeft();
                } else {
                    // traverse right
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

    // balance
    public void balance(BinaryTreeNode<T> node) {
        if(node == null) {
            return;
        }
        int leftHeight = getHeight(node.getLeft(), 0);
        int rightHeight = getHeight(node.getRight(), 0);
        if(Math.abs(leftHeight - rightHeight) > 1) {
            if(leftHeight < rightHeight) {
                // take root => old root, assign old root's right child to root's right child's left child, assign root's right child to root, assign new root's left child to old root
                BinaryTreeNode<T> oldNode  = node;
                oldNode.setRight(node.getRight().getLeft());
                node = node.getRight();
                node.setLeft(oldNode);
            } else if(leftHeight > rightHeight) {
                BinaryTreeNode<T> oldNode = node;
                oldNode.setLeft(node.getLeft().getRight());
                node = node.getLeft();
                node.setRight(oldNode);
            }
        }
        balance(node.getLeft());
        balance(node.getRight());
    }

    // getHeight
    public int getHeight(BinaryTreeNode<T> node, int height) {
        if(node == null) {
            return height;
        }
        return Math.max(getHeight(node.getLeft(), height++), getHeight(node.getRight(), height));
    }

    // calculateFork
    private void calculateFork(BinaryTreeNode<T> node, T value) {
        int result = node.getData().compareTo(value);
        if(result <= 0) {
            node = node.getLeft();
        } else {
            node = node.getRight();
        }
    }

    // to array:
    public T[] toArray(Class<T> clazz) {
        BinaryTreeNode<T> temp = this.root;
        return toArray((T[])Array.newInstance(clazz, this.size), 0, temp);
    }
    private T[] toArray(T[] arr, int i, BinaryTreeNode<T> node) {
        if(node == null) {
            return arr;
        }
        arr[i++] = node.getData();
        toArray(arr, i, node.getLeft());
        toArray(arr, i, node.getRight());
        return arr;
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
