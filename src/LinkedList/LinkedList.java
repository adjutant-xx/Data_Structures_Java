package LinkedList;

public class LinkedList {

    private Node root;

    public LinkedList(){
        root = null;
    }

    public void printValue(Object value){
        System.out.println("[" + value + "]" + "\n");
    }

    public Node getRoot(){
        return root;
    }

    public int getSize(){
        Node temp = root;
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
        Node temp = root;
        if(temp != null){
            while(temp.next != null){
                printValue(temp.getValue());
                temp = temp.next;
            }
            printValue(temp.getValue());
        }
    }

    public void insert(Object value){
        if(root == null){
            root = new Node(value);
        }
        else{
            Node newNode = new Node(value);
            newNode.next = root;
            root = newNode;
        }
    }

    public void insertEnd(Object value){
        Node temp = root;
        if(temp == null){
            temp = new Node(value);
        }
        else{
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(value);
        }
    }

    public void insertAt(Object value, int index){
        Node temp = root;
        if(temp == null){
            temp = new Node(value);
        }
        else{
            int i = 0;
            while(temp.next != null){
                if(i == index - 1){
                    Node newNode = new Node(value);
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
        Node temp = root;
        if(temp != null){
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void removeAt(int index){
        Node temp = root;
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