package structura.structurImpl;

import structura.MyIterator;
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
    public void sort(T value) {
        Arrays.sort((T []) elements, 0, size, (a, b) ->{
            if(Objects.equals(a, value)){
                return -1;
            }
            if (Objects.equals(b, value)){
                return 1;
            }
            return 0;
        });
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
}
