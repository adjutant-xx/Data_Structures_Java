package list;

/**
 * Contains implementation for a ListNode object, to be used with Linked List data structures.
 */
public class ListNode<T> {
    private T data;
    private ListNode<T> next;

    public ListNode() {}

    public ListNode(Builder<T> builder) {
        this.data = builder.data;
        this.next = builder.next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    static class Builder<T> {
        private T data;
        private ListNode<T> next;

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public Builder next(ListNode<T> next) {
            this.next = next;
            return this;
        }
    }
}
