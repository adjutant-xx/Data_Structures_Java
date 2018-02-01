package array.heap;

import util.Constants;

import java.lang.reflect.Array;

/**
 * Contains operational implementations for the array-based Max Heap data structure.
 */
public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    public MaxHeap(Class<T> clazz, int maxSize) {
        super(clazz, maxSize);
    }

    @Override
    protected void upHeap() {
        int currentIndex = this.size;
        while(currentIndex > 0) {
            int parentIndex = (currentIndex % 2 == 0) ? (currentIndex / 2) - 1 : currentIndex / 2;
            if(this.heap[currentIndex].compareTo(this.heap[parentIndex]) < 0) {
                break;
            }
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    @Override
    protected void downHeap() {
        int currentIndex = 0;
        while(true) {
            int leftChildIndex = (2 * currentIndex) + 1;
            int rightChildIndex = (2 * currentIndex) + 2;
            if(leftChildIndex < this.size && rightChildIndex < this.size) {
                int maxIndex = findMaxIndex(leftChildIndex, rightChildIndex);
                if(compare(this.heap[currentIndex], this.heap[maxIndex]) <= 0) {
                    swap(currentIndex, maxIndex);
                    currentIndex = maxIndex;
                } else {
                    break;
                }
            }
            else if(leftChildIndex < this.size) {
                if(compare(this.heap[currentIndex], this.heap[leftChildIndex]) <= 0) {
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
     * Compares two values within the underlying heap array and returns the index of the maximum.
     * @param xIndex index of first item to use in comparison.
     * @param yIndex index of second item to use in comparison.
     * @return integer representing index of the maximum value from the comparison.
     * @throws IndexOutOfBoundsException
     */
    private int findMaxIndex(int xIndex, int yIndex) throws IndexOutOfBoundsException {
        if(xIndex >= this.size || yIndex >= this.size) {
            throw new IndexOutOfBoundsException(Constants.INDEX_OUT_OF_BOUNDS_EXCEPTION_INDEX_INVALID);
        }
        return (this.heap[xIndex].compareTo(this.heap[yIndex]) > 0) ? xIndex : yIndex;
    }

}
