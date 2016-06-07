package Queue;

public class Queue {

    public static void main(String[] args)
    {
        Queue q = new Queue();

        //Populate new queue:
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        q.enqueue('d');

        //Traverse the queue:
        q.traverse();
        System.out.println("-------------\n");

        //Enqueue a value to the rear of the queue, and traverse:
        q.enqueue('e');
        q.traverse();
        System.out.println("-------------\n");

        //Dequeue a value from the front of the queue, print the value (to prove it's being returned properly), and traverse:
        Node f = q.dequeue();
        System.out.println("front value: [" + f.value + "]\n");
        q.traverse();
        System.out.println("-------------\n");

        //Traverse the final list:
        q.traverse();
        System.out.println("-------------\n");
    }

    private Node front;
    private Node rear;

    public Queue(){
        front = null;
        rear = null;
    }

    public void printValue(Object value){
        System.out.println("[" + value + "]" + "\n");
    }

    public void traverse(){
        Node tempTail = rear;
        Node tempRoot = front;
        if(tempTail != null){
            while(tempTail != front){
                printValue(tempTail.getValue());
                tempTail = tempTail.next;
            }
            printValue(tempRoot.getValue());
        }
    }

    public void enqueue(Object value){
        if(front == null) {
            front = new Node(value);
            rear = front;
        }
        else{
            Node oldTail = rear;
            rear = new Node(value);
            rear.next = oldTail;
        }
    }

    public Node dequeue(){
        Node tempRoot = front;
        Node tempRear = rear;
        if(tempRoot != null){
            while(tempRear.next.next != null) {
                tempRear = tempRear.next;
            }
            Node item = tempRear.next;
            front = tempRear;
            return item;
        }
        else{
            return null;
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