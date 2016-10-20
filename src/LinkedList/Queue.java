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
    private int size;

    /*
    * SUMMARY:  Default constructor, initializes both the front and back of the queue to null.
    * */
    public Queue(){
        front = null;
        rear = null;
        size = 0;
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
            LinkedListNode<T> newNode = new LinkedListNode<T>(value);
            if(rear != null){
                rear.next = newNode;
            }
            rear = newNode;
            if(front == null){
                front = rear;
            }
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    /*
    * SUMMARY:  Removes the front-most value from the queue.
    * */
    public T dequeue(){
        try{
            LinkedListNode<T> tempFront = front;
            LinkedListNode<T> tempRear = rear;
            if(tempFront != null){
                if(!(tempFront == tempRear)){
                    while(tempRear.next.next != null) {
                        tempRear = tempRear.next;
                    }
                }
                T returnItem = tempRear.next.getValue();
                front = tempRear;
                size--;
                return returnItem;
            }
            else{
                return null;
            }
        }
        catch(Exception ex){
            return null;
        }
    }

    /*
    * SUMMARY:  Determines whether or not the queue is empty.
    * */
    public boolean isEmpty(){
        if(size < 1){
            return true;
        }
        return false;
    }
}