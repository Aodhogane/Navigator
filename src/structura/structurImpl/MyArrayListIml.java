package structura.structurImpl;

import structura.Iterator;
import structura.MyList;
import java.util.Arrays;
import java.util.Objects;

public class MyArrayListIml<T> implements MyList<T> {

    private Object[] elements;
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 16;

    public MyArrayListIml() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T value) {
        if (size == elements.length){
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = value;
    }

    @Override
    public T get(int index) {
       return (T) elements[index];
    }

    @Override
    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], value)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[--size] = null;
                return;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new MyIteratorImpl<>(this, t-> true);
    }
}
