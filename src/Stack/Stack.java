package Stack;


public class Stack {

    public static void main(String[] args){

        Stack s = new Stack();

        //Populate a new stack:
        s.push("dog");
        s.push("cat");
        s.push("fish");
        s.push("bunny");

        //Traverse the stack:
        s.traverse();
        System.out.println("-------------\n");

        //Push a new value onto the stack, and traverse:
        s.push("zebra");
        s.traverse();
        System.out.println("-------------\n");

        //Pop off the top value of the stack, and traverse:
        s.pop();
        s.traverse();
        System.out.println("-------------\n");

        //Get the size of the stack:
        int size = s.getSize();
        System.out.println("Size: [" + size + "]");
        System.out.println("-------------\n");
    }

    private Node root;

    public Stack(){
        root = null;
    }

    public void printValue(Object value){
        System.out.println("[" + value + "]" + "\n");
    }

    public Node getRoot(){
        return root;
    }

    public int getSize(){
        Node temp = root;
        int count = 0;
        if(temp == null){
            return count;
        }
        else{
            while(temp.next != null){
                count++;
                temp = temp.next;
            }
            count++;
            return count;
        }
    }

    public void traverse(){
        Node temp = root;
        if(temp != null){
            while(temp.next != null){
                printValue(temp.value);
                temp = temp.next;
            }
            printValue(temp.value);
        }
    }

    public void push(Object value){
        if(root == null){
            root = new Node(value);
        }
        else{
            Node newNode = new Node(value);
            newNode.next = root;
            root = newNode;
        }
    }

    public void pop(){
        if(root != null){
            root = root.next;
        }
    }

    static class Node{

        private Object value;
        private Node next;

        public Node(Object v){
            value = v;
        }

        public Object getValue(){
            return value;
        }
    }
}