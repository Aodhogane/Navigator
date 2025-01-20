package com.example.navigation.structura.structurImpl;

import com.example.navigation.structura.HashSet;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyHashSetImpl<T> implements HashSet<T> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private MyLinkedListImpl<T>[] segments;
    private int capacity;
    private int count;

    public MyHashSetImpl() {
        this(INITIAL_CAPACITY);
    }

    public MyHashSetImpl(int capacity) {
        this.capacity = capacity;
        this.segments = new MyLinkedListImpl[capacity];
        for (int i = 0; i < capacity; i++) {
            segments[i] = new MyLinkedListImpl<>();
        }
    }

    private int hashCode(T key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % capacity);
    }

    @Override
    public void add(T value) {
        if ((double) count / capacity >= LOAD_FACTOR) {
            rehash();
        }

        int index = hashCode(value);
        MyLinkedListImpl<T> bucket = segments[index];
        if (!bucket.contains(value)) {
            bucket.add(value);
            count++;
        }
    }

    private void rehash() {
        int newCapacity = capacity * 2;
        MyLinkedListImpl<T>[] newSegments = new MyLinkedListImpl[newCapacity];

        for (int i = 0; i < newCapacity; i++) {
            newSegments[i] = new MyLinkedListImpl<>();
        }

        for (MyLinkedListImpl<T> bucket : segments) {
            for (int i = 0; i < bucket.size(); i++) {
                T value = bucket.get(i);
                int newIndex = (value == null) ? 0 : Math.abs(value.hashCode() % newCapacity);
                newSegments[newIndex].add(value);
            }
        }

        this.segments = newSegments;
        this.capacity = newCapacity;
    }

    @Override
    public boolean contains(T value) {
        int index = hashCode(value);
        MyLinkedListImpl<T> bucket = segments[index];
        return bucket.contains(value);
    }

    @Override
    public void remove(T value) {
        int index = hashCode(value);
        MyLinkedListImpl<T> bucket = segments[index];
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
        for (MyLinkedListImpl<T> bucket : segments) {
            for (int i = 0; i < bucket.size(); i++) {
                T element = bucket.get(i);
                if (currentIndex == index) {
                    return element;
                }
                currentIndex++;
            }
        }
        throw new IllegalStateException("Элемент с индексом " + index + " не найден.");
    }
}
