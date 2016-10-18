// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package LinkedList;

public class Node<T> {
    private T value;
    public Node<T> next;

    public Node(T v) {
        value = v;
    }

    public T getValue() {
        return value;
    }
}