package LinkedList;

public class LinkedList {
    public static void main(String[] args){

        LinkedList linkedList = new LinkedList();

        //Create a new list:
        Node root = new Node(125, null);
        Node a = new Node(1101, null);
        Node b = new Node(3, null);
        Node c = new Node(123679, null);
        root.myNext = a;
        a.myNext = b;
        b.myNext = c;

        //Traverse the list:
        linkedList.traverse(root);
    }

    public void printValue(Object value){
        System.out.println(value + "\n");
    }

    public void traverse(Node root){
        Node temp = root;
        if(temp != null){
            while(temp.myNext != null){
                printValue(temp.getValue());
                temp = temp.myNext;
            }
            printValue(temp.getValue());
        }
    }

    static class Node {
        private Object myValue;
        private Node myNext;

        public Node(Object value, Node next) {
            myValue = value;
            myNext = next;
        }

        public Object getValue() {
            return myValue;
        }
    }
}


