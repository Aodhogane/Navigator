package com.example.navigation.structura.structurImpl;

import com.example.navigation.structura.HashSet;

public class MyHashSetImpl<T> implements HashSet<T> {

    private static final int FIXED_CAPACITY = 16;
    private final MyLinkedListImpl[] segments;
    private final int capacity;
    private int count;

    public MyHashSetImpl() {
        this(FIXED_CAPACITY);
    }

    public MyHashSetImpl(int capacity) {
        this.capacity = capacity;
        this.segments =  new MyLinkedListImpl[capacity];
        for (int i = 0; i < capacity; i++) {
            segments[i] = new MyLinkedListImpl<>();
        }
    }

    private int hashCode(T key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % capacity);
    }

    @Override
    public void add(T value) {
        int index = hashCode(value);
        MyLinkedListImpl bucket = segments[index];
        if (!bucket.contains(value)) {
            bucket.add(value);
            count++;
        }
    }

    @Override
    public boolean contains(T value) {
        int index = hashCode(value);
        MyLinkedListImpl bucket = segments[index];
        return bucket.contains(value);
    }

    @Override
    public void remove(T value) {
        int index = hashCode(value);
        MyLinkedListImpl bucket = segments[index];
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
        for (MyLinkedListImpl segment : segments) {
            for (int i = 0; i < segment.size(); i++) {
                T element = (T) segment.get(i);
                if (currentIndex == index) {
                    return element;
                }
                currentIndex++;
            }
        }
        throw new IllegalStateException("Элемент с  " + index + " не найден.");
    }
}