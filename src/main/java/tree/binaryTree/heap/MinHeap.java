package tree.binaryTree.heap;

import list.queue.Queue;
import tree.binaryTree.BinaryTreeNode;

/**
 * Contains operational implementations for the tree-based MinHeap data structure.
 */
public class MinHeap<T extends Comparable<T>> {

    private BinaryTreeNode<T> root;
    private int size;

    // insert
    public boolean insert(T data) {
        this.root = insert(this.root, data);
        heapify();
        this.size++;
        return true;
    }
    private BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T data) {
        BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(data);
        if(node == null) {
            return newNode;
        }
        BinaryTreeNode<T> temp = node;
        Queue<BinaryTreeNode<T>> queue = new Queue();
        queue.enqueue(node);
        while(!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();
            if(current.getLeft() == null && current.getRight() == null) {
                current.setLeft(newNode);
                break;
            } else if(current.getLeft() != null && current.getRight() == null) {
                current.setRight(newNode);
                break;
            } else if(current.getLeft() != null && current.getRight() != null) {
                queue.enqueue(current.getLeft());
                queue.enqueue(current.getRight());
            }
        }
        return temp;
    }

    // getMin
    public T getMin()  {
        return this.root.getData();
    }

//    // removeMin
//    public T removeMin()  {
//        T min = getMin();
//        replaceRoot();
//        heapify();
//        this.size--;
//        return min;
//    }
//
//    private void replaceRoot() {
////        BinaryTreeNode<T> replacementNode = replaceRoot(this.root);
////        if(replacementNode.equals(this.root) || replacementNode == null) {
////            this.root = null;
////        } else {
////            BinaryTreeNode<T> oldLeft = (this.root.getLeft() != null) ? this.root.getLeft() : null;
////            BinaryTreeNode<T> oldRight = (this.root.getRight() != null) ? this.root.getRight() : null;
////            replacementNode.setLeft(oldLeft);
////            replacementNode.setRight(oldRight);
////            this.root = replacementNode;
//
//        this.root = replaceRoot(this.root);
//    }
//    private BinaryTreeNode<T> replaceRoot(BinaryTreeNode<T> node) {
////        BinaryTreeNode<T> temp = node;
//        BinaryTreeNode<T> replacement = node;
//        Queue<BinaryTreeNode<T>> queue = new Queue();
//        queue.enqueue(node);
//        while(!queue.isEmpty()) {
//            BinaryTreeNode<T> current = queue.dequeue();
//            if(current.getLeft() == null && current.getRight() == null) {
//                replacement = current;
//                current = null;
//                break;
//            } else if(current.getLeft() != null && current.getRight() == null) {
//                replacement = current.getLeft();
//                current.setLeft(null);
//                break;
//            } else if(current.getLeft() != null && current.getRight() != null) {
//                queue.enqueue(current.getLeft());
//                queue.enqueue(current.getRight());
//            }
//        }
//        if(replacement.equals(node)) {
//            replacement = null;
//        } else{
//            BinaryTreeNode<T> oldLeft = (node.getLeft() != null) ? node.getLeft() : null;
//            BinaryTreeNode<T> oldRight = (node.getRight() != null) ? node.getRight() : null;
//            replacement.setLeft(oldLeft);
//            replacement.setRight(oldRight);
//        }
//        return replacement;
//    }

    public void heapify() {
        this.root = heapify(this.root);
    }
    private BinaryTreeNode<T> heapify(BinaryTreeNode<T> node) {
        if(node.getLeft() == null && node.getRight() == null) {
            return node;
        }
        if(node.getLeft() != null && node.getRight() != null) {
            if(node.getLeft().getData().compareTo(node.getRight().getData()) < 0) {
                // left node is min, compare w/ current node value to determine if swap
                if(node.getLeft().getData().compareTo(node.getData()) < 0) {
                    // swap left and current
                    T temp = node.getData();
                    node.setData(node.getLeft().getData());
                    node.getLeft().setData(temp);
                }
            } else {
                // right node is min, compare w/ current node value to determine if swap
                if(node.getRight().getData().compareTo(node.getData()) < 0) {
                    // swap right and current
                    T temp = node.getData();
                    node.setData(node.getRight().getData());
                    node.getRight().setData(temp);
                }
            }
        } else {
            if (node.getLeft() != null) {
                // check left node value w/ current node value to determine if swap
                if (node.getLeft().getData().compareTo(node.getData()) < 0) {
                    // swap left and current
                    T temp = node.getData();
                    node.setData(node.getLeft().getData());
                    node.getLeft().setData(temp);
                }
            } else if (node.getRight() != null) {
                // check right node value w/ current node value to determine if swap
                if (node.getRight().getData().compareTo(node.getData()) < 0) {
                    // swap right and current
                    T temp = node.getData();
                    node.setData(node.getRight().getData());
                    node.getRight().setData(temp);
                }
            }
        }
        // recursive heapify:
        node.setLeft((node.getLeft() != null) ? heapify(node.getLeft()) : null);
//        node.setLeft(heapify(node.getLeft()));
        node.setRight((node.getRight() != null) ? heapify(node.getRight()) : null);
//        node.setRight(heapify(node.getRight()));
        return node;
    }

//    private void heapify() {
//        this.root = heapify(this.root);
//    }
//    private BinaryTreeNode<T> heapify(BinaryTreeNode<T> node) {
//        while(node.getLeft() != null || node.getRight() != null) {
//            if(node.getLeft() != null && node.getRight() != null) {
//                if(node.getLeft().getData().compareTo(node.getRight().getData()) < 0) {
//                    if(node.getLeft().getData().compareTo(node.getData()) < 0) {
//                        T oldData = node.getData();
//                        node.setData(node.getLeft().getData());
//                        node.getLeft().setData(oldData);
//                        return heapify(node.getLeft());
//                    }
//                } else {
//                    if(node.getRight().getData().compareTo(node.getData()) < 0) {
//                        T oldData = node.getData();
//                        node.setData(node.getRight().getData());
//                        node.getRight().setData(oldData);
//                        return heapify(node.getRight());
//                    }
//                }
//            } else if(node.getLeft() != null) {
//                if(node.getLeft().getData().compareTo(node.getData()) < 0) {
//                   T oldData = node.getData();
//                    node.setData(node.getLeft().getData());
//                    node.getLeft().setData(oldData);
//                    return heapify(node.getLeft());
//                }
//            } else if(node.getRight() != null) {
//                if(node.getRight().getData().compareTo(node.getData()) < 0) {
//                    T oldData = node.getData();
//                    node.setData(node.getRight().getData());
//                    node.getRight().setData(oldData);
//                    return heapify(node.getRight());
//                }
//            }
//            break;
//        }
//        return node;
//    }

    // getSize
    public int getSize() {
        return this.size;
    }

    // isEmpty
    public boolean isEmpty() {
        return this.size <= 0;
    }

}
