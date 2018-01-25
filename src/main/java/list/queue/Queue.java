package list.queue;

import list.DoublyLinkedList;

/**
 * Contains operational implementations for the List-based Queue data structure.
 */
public class Queue<T> extends DoublyLinkedList<T> {

    public Queue() {
        super();
    }

    /**
     * Adds a new element to the tail of the queue.
     * @param data element to add.
     */
    public void enqueue(T data) {
        super.insertEnd(data);
    }

    /**
     * Deletes and returns the element at the head of the queue.
     * @return element at the head of the queue.
     */
    public T dequeue() {
        T data = super.getElementAtFront();
        super.removeFront();
        return data;
    }

    /**
     * Returns the element at the head of the queue.
     * @return element at the head of the queue.
     */
    public T peek() {
        return super.getElementAtFront();
    }

    /**
     * Determines whether the queue is empty or not.
     * @return true if the queue is empty, false if otherwise.
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Returns the current size of the queue.
     * @return integer representing current queue size.
     */
    @Override
    public int getSize() {
        return super.getSize();
    }

}
