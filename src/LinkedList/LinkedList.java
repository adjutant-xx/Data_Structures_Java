package LinkedList;

public class LinkedList<T> {



    public LinkedList(){
        root = null;
    }

    private Node<T> root;

    public void printValue(Object value){
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
            return false;
        }
        else{
            return false;
        }
    }

    public void insert(T value){
        if(root == null){
            root = new Node<T>(value);
        }
        else{
            Node<T> newNode = new Node<T>(value);
            newNode.next = root;
            root = newNode;
        }
    }

    public void insertEnd(T value){
        Node<T> temp = root;
        if(temp == null){
            temp = new Node<T>(value);
        }
        else{
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node<T>(value);
        }
    }

    public void insertAt(T value, int index){
        Node<T> temp = root;
        if(temp == null){
            temp = new Node<T>(value);
        }
        else{
            int i = 0;
            while(temp.next != null){
                if(i == index - 1){
                    Node<T> newNode = new Node<T>(value);
                    newNode.next = temp.next;
                    temp.next = newNode;
                    break;
                }
                else{
                    temp = temp.next;
                    i++;
                }
            }
        }
    }

    public void remove(){
        if(root != null) {
            root = root.next;
        }
    }

    public void removeEnd(){
        Node<T> temp = root;
        if(temp != null){
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void removeAt(int index){
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
        }
    }
}