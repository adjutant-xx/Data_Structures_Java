// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package LinkedList;

public class Queue<T> {

    private LinkedListNode<T> front;
    private LinkedListNode<T> rear;

    public Queue(){
        front = null;
        rear = null;
    }

    public void printValue(T value){
        System.out.println("[" + value + "]" + "\n");
    }

    public void traverse(){
        LinkedListNode<T> tempTail = rear;
        LinkedListNode<T> tempRoot = front;
        if(tempTail != null){
            while(tempTail != front){
                printValue(tempTail.getValue());
                tempTail = tempTail.next;
            }
            printValue(tempRoot.getValue());
        }
    }

    public boolean enqueue(T value){
        try{
            if(front == null) {
                front = new LinkedListNode<T>(value);
                rear = front;
                return true;
            }
            else{
                LinkedListNode<T> oldTail = rear;
                rear = new LinkedListNode(value);
                rear.next = oldTail;
                return true;
            }
        }
        catch(Exception ex) {
            return false;
        }
    }

    public LinkedListNode<T> dequeue(){
        try{
            LinkedListNode<T> tempRoot = front;
            LinkedListNode<T> tempRear = rear;
            if(tempRoot != null){
                while(tempRear.next.next != null) {
                    tempRear = tempRear.next;
                }
                LinkedListNode<T> item = tempRear.next;
                front = tempRear;
                return item;
            }
            else{
                return null;
            }
        }
        catch(Exception ex){
            return null;
        }
    }
}