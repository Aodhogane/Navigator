package structura.structurImpl;

import structura.HashSet;
import structura.MyIterator;

public class MyHashSetImpl<T> implements HashSet<T> {

    private static final int FIXED_CAPACITY = 16;
    private MyLinkedListImpl<T>[] buckets;
    private int capacity;
    private int count;

    public MyHashSetImpl() {
        this(FIXED_CAPACITY);
    }

    public MyHashSetImpl(int capacity) {
        this.capacity = capacity;
        this.buckets = new MyLinkedListImpl[capacity];
        for (int i = 0; i < capacity; i++) {
            this.buckets[i] = new MyLinkedListImpl<>();
        }
        this.count = 0;
    }

    private int hashCode(T key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % capacity);
    }

    @Override
    public void add(T value) {
        int index = hashCode(value);
        MyLinkedListImpl<T> bucket = buckets[index];
        if (!bucket.contains(value)) {
            bucket.add(value);
            count++;
        }
    }

    @Override
    public boolean contains(T value) {
        int index = hashCode(value);
        MyLinkedListImpl<T> bucket = buckets[index];
        return bucket.contains(value);
    }

    @Override
    public void remove(T value) {
        int index = hashCode(value);
        MyLinkedListImpl<T> bucket = buckets[index];
        if (bucket.contains(value)) {
            bucket.remove(value);
            count--;
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public T get(int index) {
        int currentIndex = 0;
        for (MyLinkedListImpl<T> bucket : buckets) {
            for (int i = 0; i < bucket.size(); i++) {
                T element = bucket.get(i);
                if (currentIndex == index) {
                    return element;
                }
                currentIndex++;
            }
        }
        throw new IllegalStateException("Element at index " + index + " not found.");
    }
}