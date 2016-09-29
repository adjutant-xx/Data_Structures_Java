package Tree;

public class TrieNode<T> extends Node<T> {

    public TrieNode(){}

    public TrieNode(T v, int s){
        this.value = v;
        size = s;
        this.children = new Node[size];
    }

    private int size;
}
