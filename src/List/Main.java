// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package List;

import List.LinkedList.LinkedList;
import List.LinkedList.LinkedListNode;
import List.Queue.Queue;
import List.Stack.Stack;

public class Main {
    public static void main(String[] args){

        //Run tests for Linked List:
        System.out.println("--------------------------\n");
        System.out.println("Linked List");
        System.out.println("-------------\n");

        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        //Populate a new list:
        linkedList.insert(1);
        linkedList.insert(125);
        linkedList.insert(555847);
        linkedList.insert(325);

        //Traverse the list:
        linkedList.traverse();
        System.out.println("-------------\n");

        //Add a new node to the front of the list, and traverse:
        linkedList.insert(50);
        linkedList.traverse();
        System.out.println("-------------\n");

        //Add a new node to the end of the list, and traverse:
        linkedList.insertEnd(500);
        linkedList.traverse();
        System.out.println("-------------\n");

        //Add a new node at a specific index, and traverse:
        linkedList.insertAt(117, 2);
        linkedList.traverse();
        System.out.println("-------------\n");

        //Get the size of the linked list:
        int size = linkedList.getSize();
        System.out.println("Size: [" + size + "]");
        System.out.println("-------------\n");

        //Remove a node from the front of the list, and traverse:
        linkedList.removeFront();
        linkedList.traverse();
        System.out.println("-------------\n");

        //Remove a node from the end of the list, and traverse:
        linkedList.removeEnd();
        linkedList.traverse();
        System.out.println("-------------\n");

        //Remove a node from a specific index, and traverse:
        linkedList.removeAt(3);
        linkedList.traverse();
        System.out.println("--------------------------\n");

        //Run tests for Queue:
        System.out.println("--------------------------\n");
        System.out.println("Queue");
        System.out.println("-------------\n");

        Queue<Character> queue = new Queue<Character>();

        //Populate new queue:
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');

        //Traverse the queue:
        queue.traverse();
        System.out.println("-------------\n");

        //Enqueue a value to the rear of the queue, and traverse:
        queue.enqueue('e');
        queue.traverse();
        System.out.println("-------------\n");

        //Dequeue a value from the front of the queue, print the value (to prove it's being returned properly), and traverse:
        Character f = queue.dequeue();
        System.out.println("front value: [" + f + "]\n");
        queue.traverse();
        System.out.println("-------------\n");

        //Traverse the final list:
        queue.traverse();
        System.out.println("-------------\n");
        System.out.println("--------------------------\n");

        //Run tests for Stack:
        System.out.println("--------------------------\n");
        System.out.println("Stack");
        System.out.println("-------------\n");

        Stack stack = new Stack();

        //Populate a new stack:
        stack.push("dog");
        stack.push("cat");
        stack.push("fish");
        stack.push("bunny");

        //Push a new value onto the stack:
        stack.push("zebra");
        System.out.println("-------------\n");

        //Pop off the top value of the stack:
        LinkedListNode<Integer> popped = stack.pop();
        System.out.println("-------------\n");

        //Get the size of the stack:
        int stackSize = stack.getSize();
        System.out.println("Size: [" + stackSize + "]");
        System.out.println("-------------\n");
        System.out.println("--------------------------\n");
    }
}