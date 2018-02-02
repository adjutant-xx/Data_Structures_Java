package array.heap;

/**
 * Contains operational implementations for the array-based Min Heap data structure.
 */
public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap(Class<T> clazz, int maxSize) {
        super(clazz, maxSize);
    }

    @Override
    protected boolean upHeapComparator(int xIndex, int yIndex) {
        return this.heap[xIndex].compareTo(this.heap[yIndex]) >= 0;
    }

    @Override
    protected boolean downHeapComparator(int xIndex, int yIndex) {
        return compare(this.heap[xIndex], this.heap[yIndex]) > 0;
    }

    @Override
    protected boolean extremeComparator(int xIndex, int yIndex) {
        return this.heap[xIndex].compareTo(this.heap[yIndex]) <= 0;
    }

}
