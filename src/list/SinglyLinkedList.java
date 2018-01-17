package list;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.omg.CORBA.DynAnyPackage.Invalid;

/**
 * Contains operation implementations for the Singly-Linked List data structure.
 */
public class SinglyLinkedList<T> {

    private ListNode<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = new ListNode<T>();
        this.size = 0;
    }

    public void insertFront(T data) {
        ListNode<T> newNode = new ListNode(new ListNode.Builder().data(data));
        if(isEmpty()) {
            this.head = newNode;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    public void insertEnd(T data) {
        ListNode<T> newNode = new ListNode(new ListNode.Builder().data(data));
        if(isEmpty()) {
            this.head = newNode;
        } else {
            ListNode<T> temp = this.head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        this.size++;
    }

    public void insertAt(int index, T data) {
        if(index >= 0) {
            ListNode<T> newNode = new ListNode(new ListNode.Builder().data(data));
            if(isEmpty()) {
                this.head = newNode;
            } else if(index == 0) {
                insertFront(data);
            } else {
                ListNode<T> temp = this.head;
                for(int i = 1; i < index; i++) {
                    temp = temp.getNext();
                }
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
            }
            this.size++;
        }
    }

    public void removeFront() {
        if(!isEmpty()) {
            if (this.head.getNext() != null) {
                this.head = this.head.getNext();
            } else {
                this.head = null;
            }
            this.size--;
        }
    }

    public void removeEnd() {
        if(!isEmpty()) {
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
    }

    public void removeAt(int index) {
        if(index >= 0) {
            if(!isEmpty()) {
                if(index == 0) {
                    removeFront();
                }
                else {
                    ListNode<T> temp = this.head;
                    ListNode<T> prev = null;
                    int i = 1;
                    while (i != index && temp.getNext() != null) {
                        prev = temp;
                        temp = temp.getNext();
                        i++;
                    }
                    ListNode oldNext = temp.getNext();
                    temp = prev;
                    temp.setNext(oldNext);
                    this.size--;
                }
            }
        }
    }

    public T getElementAtFront() {
        return this.head.getData();
    }

    public T getElementAtEnd() {
        ListNode<T> temp = this.head;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public T getElementAt(int index) {
        if(index >= 0) {
            ListNode<T> temp = this.head;
            int i = 0;
            while(i < index) {
                temp = temp.getNext();
                i++;
            }
            return temp.getData();
        }
        return null;
    }

    public int find(T data) {
        if(!isEmpty()) {
            ListNode<T> temp = this.head;
            int i = 0;
            while (temp != null) {
                if (temp.getData() == data) {
                    return i;
                }
                temp = temp.getNext();
                i++;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

}
