package List.Queue;

import org.junit.Test;

public class Queue_Test {

    private Queue<Integer> _queue = new Queue<Integer>();
    private int[] _queueElements = {117,21,5,2,0,99999,25,55};

    @Test
    public void testEnqueue() throws Exception{
        int insertionCount = 0;
        for(Integer item : _queueElements){
            boolean isEnqueued = _queue.enqueue(item);
            assert(isEnqueued);
            insertionCount++;
            assert(_queue.getSize() == insertionCount);
        }
    }

    @Test
    public void testTraverse() throws Exception{
        testEnqueue();
        boolean isTraversed = _queue.traverse();
        assert(isTraversed);
    }

    @Test
    public void testDequeue() throws Exception{
        testEnqueue();
        int listFrontElement = _queueElements[0];
        int dequeueValue = _queue.dequeue();
        assert(_queue.getSize() == _queueElements.length - 1);
        assert(listFrontElement == dequeueValue);
        int removalCount = 1;
        while(!_queue.isEmpty()){
            _queue.dequeue();
            assert(_queue.getSize() == _queueElements.length - removalCount);
            removalCount++;
        }
        assert(_queue.dequeue() == null);
    }

}
