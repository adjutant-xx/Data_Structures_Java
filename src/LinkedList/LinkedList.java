// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package LinkedList;

public class LinkedList<T> {

    public LinkedList(){
        root = null;
    }

    private Node<T> root;

    public Node<T> getRoot(){
        return root;
    }

    public int getSize(){
        Node<T> temp = root;
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
        Node<T> temp = root;
        if(temp != null){
            while(temp.next != null){
                temp = temp.next;
            }
        }
    }

    public boolean contains(T searchValue){
        Node<T> temp = root;
        if(temp != null){
            while(temp.next != null){
                if(temp.getValue() == searchValue){
                    return true;
                }
                else {
                    temp = temp.next;
                }
            }
            if(temp.getValue() == searchValue){
                return true;
            }
            return false;
        }
        else{
            return false;
        }
    }

    public int find(T searchValue){
        Node<T> temp = root;
        if(temp != null){
            int index = 0;
            while(temp.next != null){
                if(temp.getValue() == searchValue){
                    return index;
                }
                else {
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

    public boolean insert(T value){
        try {
            if(root == null){
                root = new Node<T>(value);
                return true;
            }
            else{
                Node<T> newNode = new Node<T>(value);
                newNode.next = root;
                root = newNode;
                return true;
            }
        }
        catch(Exception ex){
            return false;
        }
    }

    public boolean insertEnd(T value){
        try{
            if(root == null){
                root = new Node<T>(value);
                return true;
            }
            else{
                while(root.next != null){
                    root = root.next;
                }
                root.next = new Node<T>(value);
                return true;
            }
        }
        catch(Exception ex){
            return false;
        }
    }

    public boolean insertAt(T value, int index){
        try{
            if(root == null){
                root = new Node<T>(value);
                return true;
            }
            else{
                int i = 0;
                while(root.next != null){
                    if(i == index - 1){
                        Node<T> newNode = new Node<T>(value);
                        newNode.next = root.next;
                        root.next = newNode;
                        break;
                    }
                    else{
                        root = root.next;
                        i++;
                    }
                }
                return true;
            }
        }
        catch(Exception ex){
            return false;
        }
    }

    public boolean remove(T value){
        try{
            if(root != null){
                while(root.next != null){
                    if(root.getValue() == value){
                        root.next = root.next.next;
                        return true;
                    }
                    else{
                        root = root.next;
                    }
                }
                if(root.getValue() == value){
                    root = root.next;
                    return true;
                }
                return false;
            }
            else{
                return false;
            }
        }
        catch(Exception ex){
            return false;
        }
    }

    public boolean removeFront(){
        try{
            if(root != null) {
                root = root.next;
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

    public boolean removeEnd(){
        try{
            Node<T> temp = root;
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

    public boolean removeAt(int index){
        try{
            Node<T> temp = root;
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