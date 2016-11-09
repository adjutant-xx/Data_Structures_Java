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

}
