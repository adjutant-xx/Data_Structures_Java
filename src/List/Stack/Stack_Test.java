package List.Stack;

import org.junit.Test;

public class Stack_Test {

    private Stack<Integer> _stack = new Stack<Integer>();
    private int[] _stackElements = {117,21,5,2,0,99999,25,55};

    @Test
    public void testStackPush() throws Exception{
        for(Integer item : _stackElements){
            boolean isPushed = _stack.push(item);
            assert(isPushed);
        }
    }

    @Test
    public void testStackPop() throws Exception{
        testStackPush();
        int listPopValue = _stackElements[_stackElements.length - 1], actualPopValue = _stack.pop();
        assert(listPopValue == actualPopValue);
    }

    @Test
    public void testStackGetSize() throws Exception{
        testStackPush();
        assert(_stack.getSize() == _stackElements.length);
        int removalCount = 0;
        while(!_stack.isEmpty()){
            _stack.pop();
            removalCount++;
            assert(_stack.getSize() == _stackElements.length - removalCount);
        }
        int insertionCount = 0;
        for(Integer item : _stackElements){
            _stack.push(item);
            insertionCount++;
            assert(_stack.getSize() == insertionCount);
        }
    }

    @Test
    public void testStackIsEmpty() throws Exception{
        testStackPush();
        assert(!_stack.isEmpty());
        while(!_stack.isEmpty()){
            assert(!_stack.isEmpty());
            _stack.pop();
        }
        assert(_stack.isEmpty());
    }
}