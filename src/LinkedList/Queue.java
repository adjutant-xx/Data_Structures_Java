// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package LinkedList;

/*
* SUMMARY:  Represents a Queue data structure.
*           Utilizes an underlying Linked List structure in order to implement the Queue.
* */
public class Queue<T> {

    private LinkedListNode<T> front;
    private LinkedListNode<T> rear;

    /*
    * SUMMARY:  Default constructor, initializes both the front and back of the queue to null.
    * */
    public Queue(){
        front = null;
        rear = null;
    }

    /*
    * SUMMARY:  Traverses the Queue.
    * */
    public void traverse(){
        LinkedListNode<T> tempTail = rear;
        LinkedListNode<T> tempRoot = front;
        if(tempTail != null){
            while(tempTail != front){
                tempTail = tempTail.next;
            }
        }
    }

    /*
    * SUMMARY:  Inserts a value to the end of the queue.
    * */
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

    /*
    * SUMMARY:  Removes the front-most value from the queue.
    * */
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