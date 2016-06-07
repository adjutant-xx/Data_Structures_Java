package Queue;

public class Queue {

    public static void main(String[] args)
    {
        Queue q = new Queue();

        //Populate new list:
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        q.enqueue('d');

        //Traverse the queue:
        q.traverse();
        System.out.println("-------------\n");

        //Enqueue a value to the end of the queue, and traverse:
        q.enqueue('e');
        q.traverse();
        System.out.println("-------------\n");

        //Dequeue a value from the front of the queue, and traverse:
        q.dequeue();
        q.traverse();
        System.out.println("-------------\n");
    }

    private Node root;
    private Node tail;

    public Queue(){
        root = null;
        tail = null;
    }

    public void printValue(Object value){
        System.out.println("[" + value + "]" + "\n");
    }

    public void traverse(){
        Node tempTail = tail;
        Node tempRoot = root;
        if(tempTail != null){
            while(tempTail != root){
                printValue(tempTail.getValue());
                tempTail = tempTail.next;
            }
            printValue(tempRoot.getValue());
        }
    }

    public void enqueue(Object value){
        if(root == null) {
            root = new Node(value);
            tail = root;
        }
        else{
            Node oldTail = tail;
            tail = new Node(value);
            tail.next = oldTail;
        }
    }

    public void dequeue(){
        Node tempRoot = root;
        Node tempTail = tail;
        if(tempRoot != null){
            while(tempTail.next.next != null){
                tempTail = tempTail.next;
            }
            root = tempTail;
        }
    }

    public class Node{

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