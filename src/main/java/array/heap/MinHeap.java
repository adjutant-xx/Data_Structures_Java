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


    public void insert(T data) throws HeapException {
        if(this.size >= this.maxSize) {
            throw new HeapException(String.format(Constants.EXCEPTION_MESSAGE_STRUCTURE_FULL, "Heap"));
        }
        this.heap[this.size] = data;
        upHeap();
        this.size++;
    }

    public T getMin() throws HeapException {
        if(isEmpty()) {
            throw new HeapException(String.format(Constants.EXCEPTION_MESSAGE_STRUCTURE_EMPTY, "Heap"));
        }
        return this.heap[0];
    }

    public T removeMin() throws HeapException {
        if(isEmpty()) {
            throw new HeapException(String.format(Constants.EXCEPTION_MESSAGE_STRUCTURE_EMPTY, "Heap"));
        }
        T min = this.heap[0];
        this.heap[0] = this.heap[this.size - 1];
        downHeap();
        this.size--;
        return min;
    }

    private void upHeap() {
        int currentIndex = this.size - 1;
        while(currentIndex > 0) {
            int parentIndex = currentIndex / 2;
            if(this.heap[currentIndex].compareTo(this.heap[parentIndex]) >= 0) {
                break;
            }
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    private void downHeap() {
        int currentIndex = 0;
        while(true) {
            int leftChildIndex = (2 * currentIndex) + 1;
            int rightChildIndex = (2 * currentIndex) + 2;
            if(leftChildIndex < this.size - 1 && rightChildIndex < this.size - 1) {
                int minIndex = findMinIndex(leftChildIndex, rightChildIndex);
                if(compare(this.heap[currentIndex], this.heap[minIndex]) > 0) {
                    swap(currentIndex, minIndex);
                    currentIndex = minIndex;
                }
            }
            else if(leftChildIndex < this.size - 1) {
                if(compare(this.heap[currentIndex], this.heap[leftChildIndex]) > 0) {
                    swap(currentIndex, leftChildIndex);
                    currentIndex = leftChildIndex;
                }
            }
            else {
                break;
            }
        }
    }

    private void swap(int xIndex, int yIndex) throws IndexOutOfBoundsException {
        if(xIndex >= this.size - 1 || yIndex >= this.size - 1) {
            throw new IndexOutOfBoundsException(Constants.INDEX_OUT_OF_BOUNDS_EXCEPTION_INDEX_INVALID);
        }
        T temp = this.heap[xIndex];
        this.heap[xIndex] = this.heap[yIndex];
        this.heap[yIndex] = temp;
    }

    private int findMinIndex(int xIndex, int yIndex) throws IndexOutOfBoundsException {
        if(xIndex >= this.size - 1 || yIndex >= this.size - 1) {
            throw new IndexOutOfBoundsException(Constants.INDEX_OUT_OF_BOUNDS_EXCEPTION_INDEX_INVALID);
        }
        return (this.heap[xIndex].compareTo(this.heap[yIndex]) <= 0) ? xIndex : yIndex;
    }

    private int compare(T x, T y) {
        return x.compareTo(y);
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

}
