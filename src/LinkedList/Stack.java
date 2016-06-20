package LinkedList;

public class Stack {

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
                printValue(temp.getValue());
                temp = temp.next;
            }
            printValue(temp.getValue());
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
}