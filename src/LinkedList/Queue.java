// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package LinkedList;

import java.util.NoSuchElementException;

/*
* SUMMARY:  Represents a Queue data structure.
*           Utilizes an underlying Linked List structure in order to implement the Queue.
* */
public class Queue<T> {

    private LinkedListNode<T> _front;
    private LinkedListNode<T> _rear;
    private int _size;

    /*
    * SUMMARY:  Default constructor, initializes both the front and back of the queue to null.
    * */
    public Queue(){
        _front = null;
        _rear = null;
        _size = 0;
    }

    /*
    * SUMMARY:  Traverses the Queue.
    * */
    public void traverse(){
        LinkedListNode<T> tempTail = _rear;
        if(tempTail != null){
            while(tempTail != _front){
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
            if(_rear != null){
                _rear.next = newNode;
            }
            _rear = newNode;
            if(_front == null){
                _front = _rear;
            }
            _size++;
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    /*
    * SUMMARY:  Removes the front-most value from the queue, and returns it's value.
    * */
    public T dequeue(){
        try{
            if(_front == null){
                throw new NoSuchElementException();
            }
            T returnValue = _front.getValue();
            _front = _front.next;
            if(_front == null){
                _rear = null;
            }
            _size--;
            return returnValue;
        }
        catch(Exception ex){
            return null;
        }
    }

    /*
    * SUMMARY:  Determines whether or not the queue is empty.
    * */
    public boolean isEmpty(){
        if(_size < 1){
            return true;
        }
        return false;
    }
}