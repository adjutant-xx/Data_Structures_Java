package LinkedList;

public class LinkedList {
    public static void main(String[] args){

        LinkedList ll = new LinkedList();

        //Populate a new list:
        ll.insert(1);
        ll.insert(125);
        ll.insert(555847);
        ll.insert(325);

        //Traverse the list:
        ll.traverse();
        System.out.println("-------------\n");

        //Add a new node to the front of the list, and traverse:
        ll.insert(50);
        ll.traverse();
        System.out.println("-------------\n");

        //Add a new node to the end of the list, and traverse:
        ll.insertEnd(500);
        ll.traverse();
        System.out.println("-------------\n");

        //Add a new node at a specific index, and traverse:
        ll.insertAt(117, 2);
        ll.traverse();
        System.out.println("-------------\n");

        //Get the size of the linked list:
        int size = ll.getSize();
        System.out.println("Size: [" + size + "]");
        System.out.println("-------------\n");

        //Remove a node from the front of the list, and traverse:
        ll.remove();
        ll.traverse();
        System.out.println("-------------\n");

        //Remove a node from the end of the list, and traverse:
        ll.removeEnd();
        ll.traverse();
        System.out.println("-------------\n");

        //Remove a node from a specific index, and traverse:
        ll.removeAt(3);
        ll.traverse();
        System.out.println("-------------\n");
    }

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

    static class Node {
        private Object value;
        private Node next;

        public Node(Object v) {
            value = v;
        }

        public Object getValue() {
            return value;
        }
    }
}