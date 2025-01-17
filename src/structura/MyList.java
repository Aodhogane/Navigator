package structura;

import java.util.Iterator;

public interface MyList<T> {
    void add(T value);
    T get(int index);
    void remove(T value);
    void sort(T value);
    int size();
    boolean contains(T value);
}
