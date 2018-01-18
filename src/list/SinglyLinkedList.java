package list;

/**
 * Contains operational implementations for the Singly-Linked List data structure.
 */
public class SinglyLinkedList<T> {
    protected ListNode<T> head;
    protected ListNode<T> tail;
    protected int size;

    public SinglyLinkedList() {
        this.head = new ListNode<>();
        this.size = 0;
    }

    /**
     * Inserts data element at the front of the list.
     * @param data data to insert.
     */
    public void insertFront(T data) {
        ListNode<T> newNode = new ListNode(new ListNode.ListNodeBuilder().data(data));
        if(isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    /**
     * Inserts element at the end of the list.
     * @param data data to insert.
     */
    public void insertEnd(T data) {
        ListNode<T> newNode = new ListNode(new ListNode.ListNodeBuilder().data(data));
        if(isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            ListNode<T> temp = this.tail;
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
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        this.size++;
    }

    /**
     * Removes head element from list.
     */
    public void removeFront() {
        if(!isEmpty()) {
            if (this.head.getNext() != null) {
                this.head = this.head.getNext();
            } else {
                this.head = null;
                this.tail = null;
            }
            this.size--;
        }
    }

    /**
     * Removes last element from list.
     */
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
            this.tail = prev;
            this.size--;
        }
    }

    /**
     * Removes element at a specific index from list.
     * @param index position at which to remove element.
     */
    public void removeAt(int index) {
        if(!isEmpty()) {
            if(index == 0) {
                removeFront();
            } else if(index == this.size - 1) {
                removeEnd();
            } else {
                ListNode<T> temp = this.head;
                ListNode<T> prev = null;
                int i = 1;
                while(i <= index) {
                    prev = temp;
                    temp = temp.getNext();
                    i++;
                }
                ListNode<T> oldNext = temp.getNext();
                if(prev != null) {
                    temp = prev;
                }
                if(oldNext != null) {
                    temp.setNext(oldNext);
                }
                this.size--;
            }
        }
    }

    /**
     * Returns the head element of the list.
     * @return the element at the head of the list.
     */
    public T getElementAtFront() {
        if(!isEmpty()) {
            return this.head.getData();
        }
        return null;
    }

    /**
     * Returns the tail element in the list.
     * @return the tail element of the list.
     */
    public T getElementAtEnd() {
        if(!isEmpty()) {
            return this.tail.getData();
        }
        return null;
    }

    /**
     * Returns the element at a specific index within the list.
     * @param index position at which to search for / return element.
     * @return the element located at the given index.
     */
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
    public int find(T data) {
        if(!isEmpty()) {
            ListNode<T> temp = this.head;
            int i = 0;
            while (temp != null) {
                if (temp.getData().equals(data)) {
                    return i;
                }
                temp = temp.getNext();
                i++;
            }
        }
        return -1;
    }

    /**
     * Determines whether the underlying list structure is empty or not.
     * @return true if list is empty, false if otherwise.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the current size of the list.
     * @return integer representing current list size.
     */
    public int getSize() {
        return this.size;
    }

}
