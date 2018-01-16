package list;

/**
 * Contains implementation for the Singly-Linked List data structure.
 */
public class SinglyLinkedList<T> {

    private ListNode<T> head;

    public SinglyLinkedList() {
        this.head = new ListNode<T>();
    }

    public void insertFront(T data) {
        ListNode newNode = new ListNode(new ListNode.Builder().data(data));
        newNode.setNext(this.head);
        this.head = newNode;
    }

    public void insertEnd(T data) {
        ListNode newNode = new ListNode(new ListNode.Builder().data(data));
        ListNode temp = this.head;
        while(!temp.getNext().equals(null)) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }

    public void insertAt(int index, T data) {
        ListNode newNode = new ListNode(new ListNode.Builder().data(data));
        int i = 0;
        ListNode temp = this.head;
        while(i != index && !temp.getNext().equals(null)) {
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
    }

    public void removeFront() {
        if(!this.head.getNext().equals(null)) {
            this.head = this.head.getNext();
        } else {
            this.head = null;
        }
    }

    public void removeEnd() {
        ListNode temp = this.head;
        ListNode prev = null;
        while(!temp.getNext().equals(null)) {
            prev = temp;
            temp = temp.getNext();
        }
        temp = prev;
        prev.setNext(null);
    }

    public void removeAt(int index) {
        ListNode temp = this.head;
        ListNode prev = null;
        int i = 0;
        while(i != index && !temp.getNext().equals(null)) {
            temp = temp.getNext();
        }
        ListNode oldNext = temp.getNext();
        temp = prev;
        temp.setNext(oldNext);
    }

}
