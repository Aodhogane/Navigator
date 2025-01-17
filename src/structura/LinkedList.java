package structura;

public interface LinkedList<T>  {
    void add(T value);
    T get(int index);
    void remove(T value);
    int size();
    boolean contains(T value);
    MyIterator<T> iterator();
}
