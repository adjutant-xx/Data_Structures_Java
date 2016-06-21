package BinaryTree;

public class RedBlackTree extends BinarySearchTree {

    static final int RED = 0;
    static final int BLACK = 1;

    private RedBlackNode current;
    private RedBlackNode root;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;

//    public void insert(Object value){
//        root = insert(value, root);
//    }

    public RedBlackTree(Object rootValue){
        root = new RedBlackNode(rootValue);
        root.left = null;
        root.right = null;
    }

    public void insert(Object value){
        current = parent = grand = root;
        while(current.getValue() != value){
            great = grand;
            grand = parent;
            parent = current;
            current = (Integer)value < (Integer)current.getValue() ? current.left : current.right;
            if(current.left.getColor() == RED && current.right.getColor() == RED){
                handleReorient(value);
            }
        }
        if(current != null){
            return;
        }
        current = new RedBlackNode(value);
        if((Integer)value < (Integer)parent.getValue()){
            parent.left = current;
        }
        else{
            parent.right = current;
        }
        handleReorient(value);
        //return current;
    }

//    public void handleReorient(Object value){
//        root = handleReorient(value, root);
//    }

    private void handleReorient(Object value){
        current.setColor(RED);
        current.left.setColor(BLACK);
        current.right.setColor(BLACK);

        if(parent.getColor() == RED){
            grand.setColor(RED);
            if((Integer)value < (Integer)grand.getValue() != (Integer)value < (Integer)parent.getValue()){
                parent = rotate(value, grand);
            }
            current = rotate(value, great);
            current.setColor(BLACK);
        }
        root.right.setColor(BLACK);
    }

    private RedBlackNode rotate(Object value, RedBlackNode parent){
        if((Integer)value < (Integer)parent.getValue()){
            return parent.left = (Integer)value < (Integer)parent.left.getValue() ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left);
        }
        else{
            return parent.right = (Integer)value < (Integer)parent.right.getValue() ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
        }
    }

    private RedBlackNode rotateWithLeftChild(RedBlackNode node){
        RedBlackNode subNode = node.left;
        node.left = subNode.right;
        subNode.right = node;
        return subNode;
    }

    private RedBlackNode rotateWithRightChild(RedBlackNode subNode){
        RedBlackNode node = subNode.right;
        subNode.right = node.left;
        node.left = subNode;
        return node;
    }

    public class RedBlackNode extends BinaryTree.Node{

        public RedBlackNode(Object v){
            this.setValue(v);
            this.left = null;
            this.right = null;
            this.setColor(BLACK);
        }

        RedBlackNode left;
        RedBlackNode right;
        private int value;
        private int color;
        
        public int getColor(){
            return color;
        }

        public void setColor(int c){
            color = c;
        }
    }
}