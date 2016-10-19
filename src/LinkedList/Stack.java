// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package LinkedList;

public class Stack<T> {

    private LinkedListNode<T> root;

    public Stack(){
        root = null;
    }

    public LinkedListNode<T> getRoot(){
        return root;
    }

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

    public void traverse(){
        LinkedListNode<T> temp = root;
        if(temp != null){
            while(temp.next != null){
                temp = temp.next;
            }
        }
    }

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

    public boolean pop(){
        try{
            if(root != null){
                root = root.next;
                return true;
            }
            return false;
        }
        catch(Exception ex) {
            return false;
        }
    }
}