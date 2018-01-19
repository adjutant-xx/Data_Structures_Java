package list;

/**
 * Contains operational implementations for the Doubly-Linked List data structure.
 */
public class DoublyLinkedList<T> extends SinglyLinkedList<T>{

    public DoublyLinkedList() {
        this.head = new ListNode<>();
        this.size = 0;
    }

    /**
     * Inserts data element at the front of the list.
     * @param data data to insert.
     */
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

    /**
     * Inserts data element at the end of the list.
     * @param data data to insert.
     */
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

    /**
     * Inserts element at a specific index within the list.
     * @param index position at which to insert.
     * @param data element to insert.
     */
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

    /**
     * Removes head element of list.
     */
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

    /**
     * Removes tail element of list.
     */
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

    /**
     * Removes element at a specific index from list.
     * @param index position at which to remove element.
     */
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

    /**
     * Returns the head element of the list.
     * @return the element at the head of the list
     */
    @Override
    public T getElementAtFront() {
        return super.getElementAtFront();
    }

    /**
     * Returns the tail element of the list.
     * @return the tail element of the list.
     */
    @Override
    public T getElementAtEnd() {
        return super.getElementAtEnd();
    }

    /**
     * Returns the element at a specific index within the list.
     * @param index position at which to search for / return element.
     * @return the element located at the given index.
     */
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

    /**
     * Finds the index of a specific element within the list, if it exists.
     * @param data the element to search for within the list.
     * @return the index of the queried element, -1 if element does not exist within list.
     */
    @Override
    public int find(T data) {
        return super.find(data);
    }

    /**
     * Returns contents of list in an array format.
     * @param clazz class of underlying generic type.
     * @return the array containing all list elements.
     */
    @Override
    public T[] toArray(Class<T> clazz) {
        return super.toArray(clazz);
    }

    /**
     * Determines whether the underlying list structure is empty or not.
     * @return true if list is empty, false if otherwise.
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Returns the current size of the list.
     * @return integer representing current list size.
     */
    @Override
    public int getSize() {
        return super.getSize();
    }

}
