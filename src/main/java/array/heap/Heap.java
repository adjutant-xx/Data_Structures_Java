package array.heap;

import util.Constants;

import java.lang.reflect.Array;

/**
 * Contains methods typical of a Heap-based implementation.
 */
public abstract class Heap<T extends Comparable<T>> {

    protected T[] heap;
    protected final int maxSize;
    protected int size;

    public Heap(Class<T> clazz, int maxSize) {
        this.maxSize = maxSize;
        this.heap = (T[]) Array.newInstance(clazz, this.maxSize);
        this.size = 0;
    }

    /**
     * Inserts an element into the heap.
     * @param data item to insert.
     * @throws HeapException
     */
    public void insert(T data) throws HeapException {
        if(this.size >= this.maxSize) {
            throw new HeapException(String.format(Constants.EXCEPTION_MESSAGE_STRUCTURE_FULL, "Heap"));
        }
        this.heap[this.size] = data;
        upHeap();
        this.size++;
    }

    /**
     * Returns the current extreme value within the heap.
     * @return object representing current extreme value.
     * @throws HeapException
     */
    public T getExtreme() throws HeapException {
        if(isEmpty()) {
            throw new HeapException(String.format(Constants.EXCEPTION_MESSAGE_STRUCTURE_EMPTY, "Heap"));
        }
        return this.heap[0];
    }

    /**
     * Returns and removes the current extreme value from within the heap, replacing the old extreme with the next candidate.
     * @return object representing extreme value.
     * @throws HeapException
     */
    public T removeExtreme() throws HeapException {
        if(isEmpty()) {
            throw new HeapException(String.format(Constants.EXCEPTION_MESSAGE_STRUCTURE_EMPTY, "Heap"));
        }
        T extreme = this.heap[0];
        this.heap[0] = this.heap[this.size - 1];
        this.heap[this.size - 1] = null;
        this.size--;
        downHeap();
        return extreme;
    }

    /**
     * 'Bubbles-up' an item from the bottom of the heap (tail of the array) into it's appropriate spot, following the rules of a Min Heap.
     */
    protected abstract void upHeap();

    /**
     * Percolates an item from the top of the heap (head of the array) into it's appropriate spot, following the rules of a Min Heap.
     */
    protected abstract void downHeap();

    /**
     * Quick method used to swap two items within the underlying heap array.
     * @param xIndex index of first item to swap.
     * @param yIndex index of second item to swap.
     * @throws IndexOutOfBoundsException
     */
    protected void swap(int xIndex, int yIndex) throws IndexOutOfBoundsException {
        if(xIndex > this.size || yIndex > this.size) {
            throw new IndexOutOfBoundsException(Constants.INDEX_OUT_OF_BOUNDS_EXCEPTION_INDEX_INVALID);
        }
        T temp = this.heap[xIndex];
        this.heap[xIndex] = this.heap[yIndex];
        this.heap[yIndex] = temp;
    }

    /**
     * Compares two values.
     * @param x first value to use in comparison.
     * @param y second value to use in comparison.
     * @return
     */
    protected int compare(T x, T y) {
        return x.compareTo(y);
    }

    /**
     * Returns the heap in array form.
     * @return array of generic objects representing the heap.
     */
    public T[] getHeap() {
        return this.heap;
    }

    /**
     * Returns the allotted maximum size of the underlying heap array.
     * @return an integer representing maximum size of the heap.
     */
    public int getMaxSize() {
        return this.maxSize;
    }

    /**
     * Returns the current number of elements present within the underlying heap array.
     * @return an integer representing the current number of elements within the heap.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Determines whether or not the heap contains any elements.
     * @return true if the heap is empty, false if otherwise.
     */
    public boolean isEmpty() {
        return this.size <= 0;
    }

}
