// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package List.Stack;

import List.LinkedList.LinkedListNode;

/*
* SUMMARY:  Represents a Stack data structure.
*           Utilizes an underlying Linked List structure in order to implement the Stack.
* */
public class Stack<T> {

    private LinkedListNode<T> root;
    private int _size;

    /*
    * SUMMARY:  Default constructor, initializes the top of the stack to null.
    * */
    public Stack(){
        root = null;
    }

    /*
    * SUMMARY:  Returns the root, or top, of the stack.
    * */
    public LinkedListNode<T> getRoot(){
        return root;
    }

    /*
    * SUMMARY:  Returns the size, or number of elements, of the stack.
    * */
    public int getSize(){
        return _size;
    }

    /*
    * SUMMARY:  Inserts a new value onto the top of the stack.
    *           Returns true if the insert was successful, false if the value failed to insert.
    * */
    public boolean push(T value){
        try{
            if(root == null){
                root = new LinkedListNode<T>(value);
                _size++;
                return true;
            }
            else{
                LinkedListNode<T> newNode = new LinkedListNode<T>(value);
                newNode.next = root;
                root = newNode;
                _size++;
                return true;
            }
        }
        catch(Exception ex){
            return false;
        }
    }

    /*
    * SUMMARY:  Removes the top-most value from the stack and returns it.
    *           Returns null if the stack is empty, or otherwise failed to return top-most value.
    * */
    public T pop(){
        try{
            if(root != null){
                LinkedListNode<T> temp = root;
                root = root.next;
                _size--;
                return temp.getValue();
            }
            return null;
        }
        catch(Exception ex) {
            return null;
        }
    }

    /*
    * SUMMARY: Determines whether or not the stack is empty.
    * */
    public boolean isEmpty(){
        if(_size < 1){
            return true;
        }
        return false;
    }
}