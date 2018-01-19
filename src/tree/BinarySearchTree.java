package tree;

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

    // balance
    public void balance(BinaryTreeNode<T> node) {
        if(node == null) {
            return;
        }
        int leftHeight = getHeight(node.getLeft(), 0);
        int rightHeight = getHeight(node.getRight(), 0);
        if(Math.abs(leftHeight - rightHeight) > 1) {
            if(leftHeight < rightHeight) {
                // take 
            }
        }
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
