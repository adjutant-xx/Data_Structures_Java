package LinkedList;

public class Queue {

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
}