package util;

/**
 * Container implementation used for returning value-index pairs.
 */
public class ItemIndex<T> {
    private T value;
    private int index;

    public ItemIndex() {}

    public ItemIndex(T value, int index) {
        this.value = value;
        this.index = index;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
