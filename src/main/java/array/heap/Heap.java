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
    public void push(T data) throws HeapException {
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
    public T peek() throws HeapException {
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
    public T pop() throws HeapException {
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
    protected void upHeap() {
        int currentIndex = this.size;
        while(currentIndex > 0) {
            int parentIndex = (currentIndex % 2 == 0) ? (currentIndex / 2) - 1 : currentIndex / 2;
            if(upHeapComparator(currentIndex, parentIndex)) {
                break;
            }
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    /**
     * Percolates-down an item from the top of the heap (head of the array) into it's appropriate spot, following the rules of the underlying heap class.
     */
    protected void downHeap() {
        int currentIndex = 0;
        while(true) {
            int leftChildIndex = (2 * currentIndex) + 1;
            int rightChildIndex = (2 * currentIndex) + 2;
            if(leftChildIndex < this.size && rightChildIndex < this.size) {
                int extremeIndex = findExtremeIndex(leftChildIndex, rightChildIndex);
                if(downHeapComparator(currentIndex, extremeIndex)){
                    swap(currentIndex, extremeIndex);
                    currentIndex = extremeIndex;
                } else {
                    break;
                }
            }
            else if(leftChildIndex < this.size) {
                if(downHeapComparator(currentIndex, leftChildIndex)) {
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
     * Comparison method used with up-heap operations, to be overridden within inheriting class.
     * @param xIndex first index to use within comparison.
     * @param yIndex second index to use within comparison.
     * @return true or false based on the inheriting class' implementation.
     */
    protected abstract boolean upHeapComparator(int xIndex, int yIndex);

    /**
     * Comparison method used with down-heap operations, to be overridden within inheriting class.
     * @param xIndex first index to use within comparison.
     * @param yIndex second index to use within comparison.
     * @return true or false based on the inheriting class' implementation.
     */
    protected abstract boolean downHeapComparator(int xIndex, int yIndex);

    /**
     * Comparison method used when finding an extreme value, to be overridden within inheriting class.
     * @param xIndex first index to use within comparison.
     * @param yIndex second index to use within comparison.
     * @return true or false based on the inheriting class' implementation.
     */
    protected abstract boolean extremeComparator(int xIndex, int yIndex);

    /**
     * Compares two values within the underlying heap array and returns the index of the maximum.
     * @param xIndex index of first item to use in comparison.
     * @param yIndex index of second item to use in comparison.
     * @return integer representing index of the maximum value from the comparison.
     * @throws IndexOutOfBoundsException
     */
    protected int findExtremeIndex(int xIndex, int yIndex) throws IndexOutOfBoundsException {
        if(xIndex >= this.size || yIndex >= this.size) {
            throw new IndexOutOfBoundsException(Constants.INDEX_OUT_OF_BOUNDS_EXCEPTION_INDEX_INVALID);
        }
        return (extremeComparator(xIndex, yIndex)) ? xIndex : yIndex;
    }

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
