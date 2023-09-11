import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 * A class capable of storing cache
 * @author Karter Melad
 * @version Fall 2023
 */
public class Cache <K, V extends KeyInterface<K>> {
    private LinkedList<V> data;
    private int size;
    private int hits;
    private int misses;
    private int references;

    public Cache(int size) {
        this.size = size;
        this.hits = 0;
        this.misses = 0;
        this.references = 0;
        data = new LinkedList<V>();
    }

    /**
     * Searches the list for a matching object
     * @param key
     * @return null if key does not exist or key value if list contains key
     */
    public V get(K key) {
        references++;
        V returnValue = null;
        if(!data.isEmpty()) {
            for(int i = 0; i < data.size(); i++) {
                if(data.get(i).getKey().equals(key)) {
                    returnValue = data.get(i);
                    data.remove(i);
                    data.addFirst(returnValue);
                    hits++;
                }
            }
        }
        if(returnValue == null) {
            misses++;
        }
        return returnValue;
    }




    /**
     * Adds a key to the cache if the cache is full, the earliest loaded 
     * cache is removed and returned to the user.
     * @param key
     * @return removed key
     */
    public V add(V value) {
        V removed = null;
        if (data.size() == size) {
            removed = data.removeLast();
            data.addFirst(value);
        }
        else {
            data.addFirst(value);
        }
        return removed;
    }

    /**
     * Removes the object if the key is contained in the list
     * @param key
     * @return the removed object, or null if not present
     */
    public V remove(K key) {
        V removed = null;
        if(!data.isEmpty()) {
            for(int i = 0; i < size; i++) {
                if(data.get(i).getKey().equals(key)) {
                    removed = data.get(i);
                    data.remove(i);
                }
            }
        }
        return removed;
    }

    /**
     * Clears the cache
     */
    public void clear() {
        data.clear();
    }

    /**
     * Outputs a string containing statistics about the cache
     */
    public String toString() {
        double ratio = ((double)hits/(double)references)*100;
        DecimalFormat decRatio = new DecimalFormat("0.00");
        StringBuilder str = new StringBuilder();
        str.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        str.append("Cache with " + size + " entries has been created\n");
        str.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        str.append("Total number of references:        " + references + "\n");
        str.append("Total number of cache hits:        " + hits + "\n");
        str.append("Cache hit percent:                 " + decRatio.format(ratio) + "%\n");
        return str.toString();
    }
}
