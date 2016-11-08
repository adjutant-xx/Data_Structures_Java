// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package List.LinkedList;

/*
* SUMMARY:  Represents a singly-linked list data structure.
*           Provides support for any data type.
* */
public class LinkedList<T> {

    /*
    * SUMMARY:  Default constructor that assigns the root of the list to null, before any values are added.
    * */
    public LinkedList(){
        _root = null;
    }

    private LinkedListNode<T> _root;

    /*
    * SUMMARY:  Returns the root of the list.
    *           Root variable has private access within the class, requires this method in order to access.
    * */
    public LinkedListNode<T> getRoot(){
        return _root;
    }

    /*
    * SUMMARY:  Returns the total size of the list.
    *
    * NOTE:     Will rework this in a future commit to be included as a class variable, instead of a method that
    *               requires iterating through the list.
    * */
    public int getSize(){
        LinkedListNode<T> temp = _root;
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
    * SUMMARY:  Traverses through the linked list.
    * */
    public boolean traverse(){
        try{
            LinkedListNode<T> temp = _root;
            if(temp != null){
                while(temp.next != null){
                    temp = temp.next;
                }
            }
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    /*
    * SUMMARY:  Determines whether or not the list contains a given value
    *           Returns true if the value is present within the list, false if it is not present or otherwise fails
    *               to be found.
    * */
    public boolean contains(T searchValue){
        LinkedListNode<T> temp = _root;
        if(temp != null){
            while(temp.next != null){
                if(temp.getValue().equals(searchValue)){
                    return true;
                }
                else {
                    temp = temp.next;
                }
            }

            if(temp.getValue().equals(searchValue)){
                return true;
            }
            return false;
        }
        else{
            return false;
        }
    }

    /*
    * SUMMARY:  Returns the first index of a given search term within the list.
    *           Returns -1 if the value cannot be found within the list.
    * */
    public int find(T searchValue){
        LinkedListNode<T> temp = _root;
        if(temp != null){
            int index = 0;
            while(temp != null){
                if(temp.getValue().equals(searchValue)){
                    return index;
                }
                else{
                    temp = temp.next;
                    index++;
                }
            }
            return -1;
        }
        else{
            return -1;
        }
    }

    /*
    * SUMMARY:  Inserts a given value into the front of the linked list.
    *           Returns true if the value was successfully inserted, false if the value otherwise failed to insert.
    * */
    public boolean insert(T value){
        try {
            if(_root == null){
                _root = new LinkedListNode<T>(value);
                return true;
            }
            else{
                LinkedListNode<T> newNode = new LinkedListNode<T>(value);
                newNode.next = _root;
                _root = newNode;
                return true;
            }
        }
        catch(Exception ex){
            return false;
        }
    }

    /*
    * SUMMARY:  Inserts a value onto the end of the linked list.
    *           Returns true if the value was successfully inserted, false if the value otherwise failed to insert.
    * */
    public void insertEnd(T value, LinkedListNode<T> header){
        LinkedListNode<T> temp = header;
        if(header == null){
            temp = new LinkedListNode<T>(value);
            _root = temp;
        }

       else {
            while (header.next != null) {
                header = header.next;
            }
            header.next = new LinkedListNode<T>(value);
            _root = temp;

        }
    }

    /*
    * SUMMARY:  Inserts a value at a specific index within the linked list.
    *           Returns true if the value was successfully inserted, false if the value otherwise failed to insert.
    * */
    public void insertAt(T value, int index, LinkedListNode<T> header){
        LinkedListNode<T> temp = header;
        if(header == null){
            temp = new LinkedListNode<T>(value);
            _root = temp;
        }
        else{
            int i = 1;
            while(header.next != null){
                if(i == index){
                    LinkedListNode<T> newNode = new LinkedListNode<T>(value);
                    newNode.next = header.next;
                    header.next = newNode;
                    break;
                }
                else{
                    header = header.next;
                    i++;
                }
            }
            _root = temp;
        }
    }

    /*
    * SUMMARY:  Removes the first instance of a value from the linked list.
    *           Returns true if the value was successfully removed, false if the list is empty, the value
    *               was not found, or otherwise failed to remove.
    * */
    public boolean remove(T value){
        if(_root != null){
            while(_root.next != null){
                if(_root.getValue() == value){
                    _root.next = _root.next.next;
                    return true;
                }
                else{
                    _root = _root.next;
                }
            }
            if(_root.getValue() == value){
                _root = _root.next;
                return true;
            }
            return false;
        }
        else{
            return false;
        }
    }


    /*
    * SUMMARY:  Removes the front-most value from the linked list.
    *           Returns true if removal was successful, false if the list is empty or otherwise failed to remove.
    * */
    public boolean removeFront(){
        if(_root != null) {
            _root = _root.next;
            return true;
        }
        else{
            return false;
        }
    }

    /*
    * SUMMARY:  Removes the trailing value from the linked list.
    *           Returns true if the removal was successful, false if the list is empty or otherwise failed to remove.
    * */
    public boolean removeEnd(){
        try{
            LinkedListNode<T> temp = _root;
            if(temp != null){
                while(temp.next.next != null){
                    temp = temp.next;
                }
                temp.next = null;
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception ex){
            return false;
        }
    }

    /*
    * SUMMARY:  Removes a node at a specific index in the linked list.
    *           Returns true if the removal was successful, false if the list is empty, does not contain the
    *               value, or otherwise failed to remove.
    * */
    public boolean removeAt(int index){
        try{
            LinkedListNode<T> temp = _root;
            if(temp != null){
                int i = 0;
                while(temp.next != null){
                    if(i == index - 1){
                        temp.next = temp.next.next;
                        break;
                    }
                    else{
                        temp = temp.next;
                        i++;
                    }
                }
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception ex){
            return false;
        }
    }
}