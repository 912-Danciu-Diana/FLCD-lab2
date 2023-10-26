public interface SymbolTable<T> {
    void add(String key, T value);
    boolean find(String key);
    T get(String key);
}
