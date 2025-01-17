package structura;

public interface LinkedList<T>  {
    void add(T value);
    T get(int index);
    void remove(int index);
    int size();
    boolean contains(T value);
}
