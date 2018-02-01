package array.heap;

import util.Constants;

import java.lang.reflect.Array;

/**
 * Contains operational implementations for the array-based Min Heap data structure.
 */
public class MinHeap<T extends Comparable<T>> {

    private T[] heap;
    private final int maxSize;
    private int size;

    public MinHeap(Class<T> clazz, int maxSize) {
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
     * Returns the current minimum value within the heap.
     * @return object representing current minimum value.
     * @throws HeapException
     */
    public T getMin() throws HeapException {
        if(isEmpty()) {
            throw new HeapException(String.format(Constants.EXCEPTION_MESSAGE_STRUCTURE_EMPTY, "Heap"));
        }
        return this.heap[0];
    }

    /**
     * Returns and removes the current minimum value from within the heap, replacing the old minimum with the next-smallest value.
     * @return object representing minimum value.
     * @throws HeapException
     */
    public T removeMin() throws HeapException {
        if(isEmpty()) {
            throw new HeapException(String.format(Constants.EXCEPTION_MESSAGE_STRUCTURE_EMPTY, "Heap"));
        }
        T min = this.heap[0];
        this.heap[0] = this.heap[this.size - 1];
        this.heap[this.size - 1] = null;
        this.size--;
        downHeap();
        return min;
    }

    /**
     * 'Bubbles-up' an item from the bottom of the heap (tail of the array) into it's appropriate spot, following the rules of a Min Heap.
     */
    private void upHeap() {
        int currentIndex = this.size;
        while(currentIndex > 0) {
            int parentIndex = (currentIndex % 2 == 0) ? (currentIndex / 2) - 1 : currentIndex / 2;
            if(this.heap[currentIndex].compareTo(this.heap[parentIndex]) >= 0) {
                break;
            }
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    /**
     * Percolates an item from the top of the heap (head of the array) into it's appropriate spot, following the rules of a Min Heap.
     */
    private void downHeap() {
        int currentIndex = 0;
        while(true) {
            int leftChildIndex = (2 * currentIndex) + 1;
            int rightChildIndex = (2 * currentIndex) + 2;
            if(leftChildIndex < this.size && rightChildIndex < this.size) {
                int minIndex = findMinIndex(leftChildIndex, rightChildIndex);
                if(compare(this.heap[currentIndex], this.heap[minIndex]) > 0) {
                    swap(currentIndex, minIndex);
                    currentIndex = minIndex;
                } else {
                    break;
                }
            }
            else if(leftChildIndex < this.size) {
                if(compare(this.heap[currentIndex], this.heap[leftChildIndex]) > 0) {
                    swap(currentIndex, leftChildIndex);
                    currentIndex = leftChildIndex;
                } else {
                    break;
                }
            }
            else {
                break;
            }
        }
    }

    /**
     * Quick method used to swap two items within the underlying heap array.
     * @param xIndex index of first item to swap.
     * @param yIndex index of second item to swap.
     * @throws IndexOutOfBoundsException
     */
    private void swap(int xIndex, int yIndex) throws IndexOutOfBoundsException {
        if(xIndex > this.size || yIndex > this.size) {
            throw new IndexOutOfBoundsException(Constants.INDEX_OUT_OF_BOUNDS_EXCEPTION_INDEX_INVALID);
        }
        T temp = this.heap[xIndex];
        this.heap[xIndex] = this.heap[yIndex];
        this.heap[yIndex] = temp;
    }

    /**
     * Compares two values within the underlying heap array and returns the index of the minimum.
     * @param xIndex index of first item to use in comparison.
     * @param yIndex index of second item to use in comparison.
     * @return integer representing index of the minimum value from the comparison.
     * @throws IndexOutOfBoundsException
     */
    private int findMinIndex(int xIndex, int yIndex) throws IndexOutOfBoundsException {
        if(xIndex >= this.size || yIndex >= this.size) {
            throw new IndexOutOfBoundsException(Constants.INDEX_OUT_OF_BOUNDS_EXCEPTION_INDEX_INVALID);
        }
        return (this.heap[xIndex].compareTo(this.heap[yIndex]) <= 0) ? xIndex : yIndex;
    }

    /**
     * Compares two values.
     * @param x first value to use in comparison.
     * @param y second value to use in comparison.
     * @return
     */
    private int compare(T x, T y) {
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
