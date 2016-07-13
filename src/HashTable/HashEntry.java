package HashTable;

public class HashEntry {

    public HashEntry(Object v, String k){
        value = v;
        key = k;
    }

    private Object value;
    private String key; //Assumes that keys will be represented by String variables

    public Object getValue(){
        return value;
    }

    public Object getKey() {
        return key;
    }
}
