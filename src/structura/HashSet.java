package structura;

public interface HashSet<T> {
    void add(T value);
    boolean contains(T value);
    void remove(T value);
    int size();

    int capacity();

    Iterator<T> iterator();
}
