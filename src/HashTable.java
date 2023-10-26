import java.util.ArrayList;
import java.util.List;
public class HashTable<T> implements SymbolTable<T> {
    private static final int INITIAL_CAPACITY = 100;
    private List<Entry<T>>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = (List<Entry<T>>[]) new List[INITIAL_CAPACITY];
    }

    @Override
    public void add(String key, T value) {
        int idx = hash(key);
        if (table[idx] == null) table[idx] = new ArrayList<>();
        table[idx].add(new Entry<>(key, value));
        size++;

        if (size > table.length * 0.75) resize();
    }

    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newSize = table.length * 2;
        List<Entry<T>>[] oldTable = table;
        table = (List<Entry<T>>[]) new List[newSize];
        size = 0;

        for (List<Entry<T>> bucket : oldTable) {
            if (bucket != null) {
                for (Entry<T> entry : bucket) {
                    add(entry.key, entry.value);
                }
            }
        }
    }

    @Override
    public boolean find(String key) {
        return get(key) != null;
    }

    @Override
    public T get(String key) {
        int idx = hash(key);
        if (table[idx] != null) {
            for (Entry<T> entry : table[idx]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    private static class Entry<T> {
        String key;
        T value;

        Entry(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }
}
