package LinkedList;

public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;

    public Queue(){
        front = null;
        rear = null;
    }

    public void printValue(T value){
        System.out.println("[" + value + "]" + "\n");
    }

    public void traverse(){
        Node<T> tempTail = rear;
        Node<T> tempRoot = front;
        if(tempTail != null){
            while(tempTail != front){
                printValue(tempTail.getValue());
                tempTail = tempTail.next;
            }
            printValue(tempRoot.getValue());
        }
    }

    public void enqueue(T value){
        if(front == null) {
            front = new Node<T>(value);
            rear = front;
        }
        else{
            Node<T> oldTail = rear;
            rear = new Node(value);
            rear.next = oldTail;
        }
    }

    public Node<T> dequeue(){
        Node<T> tempRoot = front;
        Node<T> tempRear = rear;
        if(tempRoot != null){
            while(tempRear.next.next != null) {
                tempRear = tempRear.next;
            }
            Node<T> item = tempRear.next;
            front = tempRear;
            return item;
        }
        else{
            return null;
        }
    }
}