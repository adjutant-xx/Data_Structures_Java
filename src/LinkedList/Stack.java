// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package LinkedList;


/*
* SUMMARY:  Represents a Stack data structure.
*           Utilizes an underlying Linked List structure in order to implement the Stack.
* */
public class Stack<T> {

    private LinkedListNode<T> root;

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
    *
    * NOTE:     Will refactor this at a later date to use a class variable to keep track of the stack size,
    *               instead of using a method that requires iteration.
    * */
    public int getSize(){
        LinkedListNode<T> temp = root;
        int count = 0;
        if(temp == null){
            return count;
        }
        else{
            while(temp.next != null){
                count++;
                temp = temp.next;
            }
            count++;
            return count;
        }
    }

    /*
    * SUMMARY:  Inserts a new value onto the top of the stack.
    *           Returns true if the insert was successful, false if the value failed to insert.
    * */
    public boolean push(T value){
        try{
            if(root == null){
                root = new LinkedListNode<T>(value);
                return true;
            }
            else{
                LinkedListNode<T> newNode = new LinkedListNode<T>(value);
                newNode.next = root;
                root = newNode;
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
    public LinkedListNode<T> pop(){
        try{
            if(root != null){
                LinkedListNode<T> temp = root;
                root = root.next;
                return temp;
            }
            return null;
        }
        catch(Exception ex) {
            return null;
        }
    }
}