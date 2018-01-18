package list;

/**
 * Contains operational implementations for the Doubly-Linked List data structure.
 */
public class DoublyLinkedList<T> extends SinglyLinkedList<T>{

//    private ListNode<T> head;
//    private int size;

    DoublyLinkedList() {
        this.head = new ListNode<>();
        this.size = 0;
    }

    @Override
    public void insertFront(T data) {
        ListNode<T> newNode = new ListNode(new ListNode.ListNodeBuilder().data(data));
        if(isEmpty()) {
            this.head = newNode;
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
        } else {

        }
    }

    @Override
    public void insertAt(int index, T data) {
        super.insertAt(index, data);
    }

    @Override
    public void removeFront() {
        super.removeFront();
    }

    @Override
    public void removeEnd() {
        super.removeEnd();
    }

    @Override
    public void removeAt(int index) {
        super.removeAt(index);
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
        return super.getElementAt(index);
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
