package list;

/**
 * Contains operation implementations for the Singly-Linked List data structure.
 */
public class SinglyLinkedList<T> {

    private ListNode<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = new ListNode<T>();
    }

    public void insertFront(T data) {
        ListNode<T> newNode = new ListNode(new ListNode.Builder().data(data));
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }

    public void insertEnd(T data) {
        ListNode<T> newNode = new ListNode(new ListNode.Builder().data(data));
        ListNode<T> temp = this.head;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
        this.size++;
    }

    public void insertAt(int index, T data) {
        ListNode<T> newNode = new ListNode(new ListNode.Builder().data(data));
        ListNode<T> temp = this.head;
        int i = 0;
        while(i != index && temp.getNext() != null) {
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        this.size++;
    }

    public void removeFront() {
        if(this.head.getNext() != null) {
            this.head = this.head.getNext();
        } else {
            this.head = null;
        }
        this.size--;
    }

    public void removeEnd() {
        ListNode<T> temp = this.head;
        ListNode<T> prev = null;
        while(temp.getNext() != null) {
            prev = temp;
            temp = temp.getNext();
        }
        temp = prev;
        prev.setNext(null);
        this.size--;
    }

    public void removeAt(int index) {
        ListNode<T> temp = this.head;
        ListNode<T> prev = null;
        int i = 0;
        while(i != index && temp.getNext() != null) {
            temp = temp.getNext();
            i++;
        }
        ListNode oldNext = temp.getNext();
        temp = prev;
        temp.setNext(oldNext);
        this.size--;
    }

    public T getElementAtFront() {
        return this.head.getData();
    }

    public T getElementAtEnd() {
        ListNode<T> temp = this.head;
        while(this.head.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public T getElementAt(int index) {
        ListNode<T> temp = this.head;
        int i = 0;
        while(i != index && temp.getNext() != null) {
            temp = temp.getNext();
            i++;
        }
        return temp.getData();
    }

    public int find(T data) {
        ListNode<T> temp = this.head;
        int i = 0;
        while(!temp.getNext().equals(null)) {
            if(temp.getData() == data) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int getSize() {
        return this.size;
    }

}
