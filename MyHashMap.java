public class MyHashMap<K,V> {
    
    // instance variables
    private Object[] hashArray;
    private int size;
    private MyHashSet<K> keySet;

    // constructor
    public MyHashMap() {
        size = 0;
        hashArray = new Object[676];
        keySet = new MyHashSet<>();
    }
    
    // put method
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {

        int index = key.hashCode();
        V val = (V) hashArray[index]; // make the value equal to the value that was originally in the spot (to return)

        if (val == null) { 
            size ++;
        }

        hashArray[index] = value; 
        keySet.add(key);
        return val; // original value
    }

    // get method
    public V get(Object key) {
        int index = key.hashCode();
        return (V) hashArray[index];
    }

    // remove method
    public V remove(Object key) {

        int index = key.hashCode();
        V val = (V) hashArray[index];

        if (val != null) {
            hashArray[index] = null;
            keySet.remove((K) key);
            size --;
        }
        return val;
    }

    // size method
    public int size() {
        return size;
    }

    // key set method
    public MyHashSet<K> keySet() {
        return keySet;
    }
}

/**+put(K,V) : V- Takes in a key and value. Insert into the keySet and hashArray.  Adjust the size accordingly.  Return the previous value or null if there is none.  Because you might be casting an array to generic, you may want to add the @SuppressWarnings("unchecked"). 
+get(Object) : V - Returns the value given a key object.  Because you will be casting an array to generic, you may want to add the @SuppressWarnings("unchecked"). 
+remove(Object) : V - Takes in a key object. Remove the given key and corresponding value from the keySet and hashArray, respectively.  Adjust the size. Return the value that was removed or null otherwise.  You may want to add the @SuppressWarnings("unchecked").
+size() : int - Return the size.
+keySet() : MyHashSet<K> - Return a set of keys. 
 */