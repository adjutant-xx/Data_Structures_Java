package LinkedList;

public class Stack<T> {

    private Node<T> root;

    public Stack(){
        root = null;
    }

    public void printValue(T value){
        System.out.println("[" + value + "]" + "\n");
    }

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
                printValue(temp.getValue());
                temp = temp.next;
            }
            printValue(temp.getValue());
        }
    }

    public boolean push(T value){
        try{
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