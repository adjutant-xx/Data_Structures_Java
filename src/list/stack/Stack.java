package list.stack;

import list.DoublyLinkedList;

/**
 * Contains operational implementations for the List-based Stack data structure.
 */
public class Stack<T> extends DoublyLinkedList<T> {

    public Stack() {
        super();
    }

    /**
     * Adds a new element to the top of the stack.
     * @param data element to add.
     */
    public void push(T data) {
        super.insertFront(data);
    }

    /**
     * Deletes and returns the element at the top of the stack.
     * @return element at the top of the stack.
     */
    public T pop() {
        T data = super.getElementAtFront();
        super.removeFront();
        return data;
    }

    /**
     * Returns the element at the top of the stack.
     * @return element at the top of the stack.
     */
    public T peek() {
        return super.getElementAtFront();
    }

    /**
     * Determines whether the stack is empty or not.
     * @return true if the stack is empty, false if otherwise.
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Returns the current size of the stack.
     * @return integer representing current stack size.
     */
    @Override
    public int getSize() {
        return super.getSize();
    }
}
