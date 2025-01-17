package structura.structurImpl;

import structura.MyList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MyArrayListIml<T> implements MyList<T>, Iterable<T> {

    private Object[] elements;
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 16;

    public MyArrayListIml() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T value) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
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
    public void sort(T value) {
        for (int i =0; i < size - 1; i++){
            for (int j = 0; j < size - 1; i++){
                T first = (T) elements[j];
                T second = (T) elements[j + 1];
                if (((Comparable<T>) first).compareTo(second) > 0) {

                    elements[j] = second;
                    elements[j + 1] = first;
                }
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIteratorImpl<>(this, t -> true);
    }
}

