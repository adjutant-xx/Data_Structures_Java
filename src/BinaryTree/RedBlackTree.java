package BinaryTree;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class RedBlackTree extends BinarySearchTree {

    static final int RED = 0;
    static final int BLACK = 1;

    public class RedBlackNode extends BinaryTree.Node{

        public RedBlackNode(Object v, int color){
            this.setValue(v);
            this.left = null;
            this.right = null;
            this.parent = null;
            this.setColor(color);
        }

        RedBlackNode parent;
        RedBlackNode left;
        RedBlackNode right;
        private int color;
        boolean emptyLeafNode;

        public int getColor(){
            return color;
        }

        public void setColor(int c){
            color = c;
        }
    }

    private boolean blackNodesCheck(RedBlackNode root, AtomicInteger totalCount, int count){
        if(root.getColor() == BLACK){
            count++;
        }
        if(root.left == null && root.right == null){
            if(totalCount.get() == 0){
                totalCount.set(count);
                return true;
            }
            else{
                return count == totalCount.get();
            }
        }
        return blackNodesCheck(root.left, totalCount, count) && blackNodesCheck(root.right, totalCount, count);
    }

    private boolean redRedParentChildRelationshipCheck(RedBlackNode root, int parentColor){
        if(root == null){
            return true;
        }
        if(root.getColor() == RED && parentColor == RED){
            return false;
        }
        return redRedParentChildRelationshipCheck(root.left, root.getColor()) && redRedParentChildRelationshipCheck(root.right, root.getColor());
    }

    public boolean authenticateTree(RedBlackNode root){
        if(root == null){
            return true;
        }

        if(root.getColor() != BLACK){
            return false;
        }

        AtomicInteger totalBlackNodesCount = new AtomicInteger(0);
        return blackNodesCheck(root, totalBlackNodesCount, 0) && redRedParentChildRelationshipCheck(root, BLACK);
    }

    private void rightRotate(RedBlackNode root, boolean colorSwap){
        RedBlackNode parent = root.parent;
        root.parent = parent.parent;
        if(parent.parent != null){
            if(parent.parent.right == parent){
                parent.parent.right = root;
            }
            else {
                parent.parent.left = root;
            }
        }

        RedBlackNode right = root.right;
        root.right = parent;
        parent.parent = root;
        parent.left = right;
        if(right != null){
            right.parent = parent;
        }
        if(colorSwap == true){
            root.setColor(BLACK);
            parent.setColor(RED);
        }
    }

    private void leftRotate(RedBlackNode root, boolean colorSwap){
        RedBlackNode parent = root.parent;
        root.parent = parent.parent;
        if(parent.parent != null){
            if(parent.parent.right == parent){
                parent.parent.right = root;
            }
            else{
                parent.parent.left = root;
            }
            RedBlackNode left = root.left;
            root.left = parent;
            parent.parent = root;
            parent.right = left;
            if(left != null){
                left.parent = parent;
            }
            if(colorSwap == true){
                root.setColor(BLACK);
                parent.setColor(RED);
            }
        }
    }

    private Optional<RedBlackNode> findSiblingNode(RedBlackNode root){
        RedBlackNode parent = root.parent;
        if(isLeftChildNode(root)){
            return Optional.ofNullable(parent.right.emptyLeafNode ? null : parent.right);
        }
        else{
            return Optional.ofNullable(parent.left.emptyLeafNode ? null : parent.left);
        }
    }

    private boolean isLeftChildNode(RedBlackNode root){
        RedBlackNode parent = root.parent;
        if(parent.left == root){
            return true;
        }
        else{
            return false;
        }
    }

    private Optional<RedBlackNode> findSiblingRedBlackNode(RedBlackNode root){
        RedBlackNode parent = root.parent;
        if(isLeftChildNode(root)){
            return Optional.ofNullable(parent.right.emptyLeafNode ? null : parent.right);
        }
        else{
            return Optional.ofNullable(parent.left.emptyLeafNode ? null : parent.left);
        }
    }

    public RedBlackNode insert(RedBlackNode root, Object value){
        return insert(null, root, value);
    }

    private RedBlackNode insert(RedBlackNode parent, RedBlackNode root, Object value){

        if((root == null) || (root.emptyLeafNode == true)){
            if(parent != null){
                return new RedBlackNode(parent.getValue(), RED); //Create a new red leaf node.
            }
            else{
                return new RedBlackNode(value, BLACK);
            }
        }

        //check for duplicate insertion, do not allow:
        if(root.getValue() == value){
            return null; //NOTE: Figure out a better way to check for dupes...
        }

        boolean isLeftSubtree;
        if((Integer)root.getValue() > (Integer)value){
            RedBlackNode newLeftNode = insert(root, root.left, value);
            if(newLeftNode == root.parent){
                return newLeftNode;
            }
            root.left = newLeftNode;
            isLeftSubtree = true;
        }
        else{
            RedBlackNode newRightNode = insert(root, root.right, value);
            if(newRightNode == root.parent){
                return newRightNode;
            }
            root.right = newRightNode;
            isLeftSubtree = false;
        }

        if(isLeftSubtree == true) {
            if (root.getColor() == RED && root.left.getColor() == RED) {
                Optional<RedBlackNode> siblingNode = findSiblingNode(root);
                if(siblingNode.isPresent() == false || siblingNode.get().getColor() == BLACK){
                    if(isLeftChildNode(root)){
                        rightRotate(root, true);
                    }
                    else{
                        rightRotate(root.left, false);
                        root = root.parent;
                        leftRotate(root, true);
                    }
                }
                else{
                    root.setColor(BLACK);
                    siblingNode.get().setColor(BLACK);
                    if(root.parent.parent != null){
                        root.parent.setColor(RED);
                    }
                }
            }
        }
        else{
            if(root.getColor() == RED && root.right.getColor() == RED){
                Optional<RedBlackNode> siblingNode = findSiblingNode(root);
                if(siblingNode.isPresent() == false || siblingNode.get().getColor() == BLACK){
                    if(isLeftChildNode(root) == false){
                        leftRotate(root, true);
                    }
                    else {
                        leftRotate(root.right, false);
                        root = root.parent;
                        rightRotate(root, true);
                    }
                }
                else{
                    root.setColor(BLACK);
                    siblingNode.get().setColor(BLACK);
                    if(root.parent.parent != null){
                        root.parent.setColor(RED);
                    }
                }
            }
        }
        return root;
    }

//    static final int RED = 0;
//    static final int BLACK = 1;

//    private RedBlackNode current;
//    private RedBlackNode root;
//    private RedBlackNode parent;
//    private RedBlackNode grand;
//    private RedBlackNode great;
//
//    public RedBlackTree(Object rootValue){
//        root = new RedBlackNode(rootValue);
//        root.left = null;
//        root.right = null;
//    }
//
//    public void insert(Object value){
//        current = parent = grand = root;
//        while(current.getValue() != value){
//            great = grand;
//            grand = parent;
//            parent = current;
//            current = (Integer)value < (Integer)current.getValue() ? current.left : current.right;
//            if(current.left != null && current.right != null){
//                if((current.left.getColor() == RED) && current.right.getColor() == RED){
//                    handleReorient(value);
//                }
//            }
//
//        }
//        if(current != null){
//            return;
//        }
//        current = new RedBlackNode(value);
//        if((Integer)value < (Integer)parent.getValue()){
//            parent.left = current;
//        }
//        else{
//            parent.right = current;
//        }
//        handleReorient(value);
//        //return current;
//    }
//
//    private void handleReorient(Object value){
//        current.setColor(RED);
//        current.left.setColor(BLACK);
//        current.right.setColor(BLACK);
//
//        if(parent.getColor() == RED){
//            grand.setColor(RED);
//            if((Integer)value < (Integer)grand.getValue() != (Integer)value < (Integer)parent.getValue()){
//                parent = rotate(value, grand);
//            }
//            current = rotate(value, great);
//            current.setColor(BLACK);
//        }
//        root.right.setColor(BLACK);
//    }
//
//    private RedBlackNode rotate(Object value, RedBlackNode parent){
//        if((Integer)value < (Integer)parent.getValue()){
//            return parent.left = (Integer)value < (Integer)parent.left.getValue() ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left);
//        }
//        else{
//            return parent.right = (Integer)value < (Integer)parent.right.getValue() ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
//        }
//    }
//
//    private RedBlackNode rotateWithLeftChild(RedBlackNode node){
//        RedBlackNode subNode = node.left;
//        node.left = subNode.right;
//        subNode.right = node;
//        return subNode;
//    }
//
//    private RedBlackNode rotateWithRightChild(RedBlackNode subNode){
//        RedBlackNode node = subNode.right;
//        subNode.right = node.left;
//        node.left = subNode;
//        return node;
//    }


}