package Tree;

public class TrieNode<T> extends Node<T> {

    public TrieNode(){}

    public TrieNode(T d, int s){
        this.data = d;
        size = s;
        this.children = new Node[size];
        terminates = false;
    }

    public T data;
    public int size;
    public boolean terminates;
}
