package list;

/**
 * Contains operational implementations for the Doubly-Linked List data structure.
 */
public class DoublyLinkedList<T> extends SinglyLinkedList<T>{

    public DoublyLinkedList() {
        this.head = new ListNode<>();
        this.size = 0;
    }

    @Override
    public void insertFront(T data) {
        ListNode<T> newNode = new ListNode(new ListNode.ListNodeBuilder().data(data));
        if(isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.head.setPrev(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    @Override
    public void insertEnd(T data) {
        ListNode<T> newNode = new ListNode(new ListNode.ListNodeBuilder().data(data));
        if(isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            ListNode<T> temp = this.tail;
            newNode.setPrev(temp);
            temp.setNext(newNode);
            this.tail = temp.getNext();
        }
        this.size++;
    }

    @Override
    public void insertAt(int index, T data) {
        ListNode<T> newNode = new ListNode(new ListNode.ListNodeBuilder().data(data));
        if(isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
        } else if(index == 0) {
            insertFront(data);
        } else {
            ListNode<T> temp = this.head;
            for(int i = 1; i < index; i++) {
                temp = temp.getNext();
            }
            newNode.setPrev(temp);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        this.size++;
    }

    @Override
    public void removeFront() {
        if(!isEmpty()) {
            if(this.head.getNext() != null) {
                this.head = this.head.getNext();
            } else {
                this.head = null;
                this.tail = null;
            }
            this.size--;
        }
    }

    @Override
    public void removeEnd() {
        if(!isEmpty()) {
            if(this.tail.getPrev() != null) {
                this.tail = this.tail.getPrev();
            } else {
                this.tail = null;
                this.head = null;
            }
            this.size--;
        }
    }

    @Override
    public void removeAt(int index) {
        if(!isEmpty()) {
            if(index == 0) {
                removeFront();
            } else {
                ListNode<T> temp = this.head;
                for(int i = 0; i < index; i++) {
                    temp = temp.getNext();
                }
                temp.getPrev().setNext(temp.getNext());
                temp = temp.getPrev();
            }
            this.size--;
        }
    }

    @Override
    public T getElementAtFront() {
        return super.getElementAtFront();
    }

    @Override
    public T getElementAtEnd() {
        return super.getElementAtEnd();
    }

    @Override
    public T getElementAt(int index) {
        if(!isEmpty()) {
            if(index == 0) {
                return getElementAtFront();
            } else if(index == this.size - 1) {
                return getElementAtEnd();
            } else {
                ListNode<T> temp = this.head;
                for(int i = 0; i < index; i++) {
                    temp = temp.getNext();
                }
                return temp.getData();
            }
        }
        return null;
    }

    @Override
    public int find(T data) {
        return super.find(data);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

}
