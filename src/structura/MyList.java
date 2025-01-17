package structura;

public interface MyList<T> {
    void add(T value);
    T get(int index);
    void remove(T value);
    int size();
}
