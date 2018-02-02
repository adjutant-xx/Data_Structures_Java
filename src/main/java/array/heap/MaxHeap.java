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
    protected boolean upHeapComparator(int xIndex, int yIndex) {
        return this.heap[xIndex].compareTo(this.heap[yIndex]) < 0;
    }

    @Override
    protected boolean downHeapComparator(int xIndex, int yIndex) {
        return compare(this.heap[xIndex], this.heap[yIndex]) <= 0;
    }

    @Override
    protected boolean extremeComparator(int xIndex, int yIndex) {
        return this.heap[xIndex].compareTo(this.heap[yIndex]) > 0;
    }

}
