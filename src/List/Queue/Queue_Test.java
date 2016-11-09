package List.Queue;

import org.junit.Test;

public class Queue_Test {

    private Queue<Integer> _queue = new Queue<Integer>();
    private int[] _queueElements = {117,21,5,2,0,99999,25,55};

    @Test
    public void testEnqueue() throws Exception{
        for(Integer item : _queueElements){
            boolean isEnqueued = _queue.enqueue(item);
            assert(isEnqueued);
        }
    }

}