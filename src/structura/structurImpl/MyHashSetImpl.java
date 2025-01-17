package structura.structurImpl;

import structura.HashSet;
import structura.Iterator;
import structura.MyList;

public class MyHashSetImpl<T> implements MyList<T>, HashSet<T> {
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
    public T get(int index) {
        int currentIndex = 0;
        for (MyLinkedListImpl<T> bucket : buckets) {
            Iterator<T> iterator = new MyIteratorImpl<>(bucket, t -> true);
            while (iterator.hasNext()) {
                if (currentIndex == index) {
                    return iterator.next();
                }
                currentIndex++;
                iterator.next();
            }
        }
        throw new IndexOutOfBoundsException("Индех: " + index + ", Размер: " + count);
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

    public MyArrayListIml<T> toList() {
        MyArrayListIml<T> list = new MyArrayListIml<>();
        for (MyLinkedListImpl<T> bucket : buckets) {
            Iterator<T> iterator = new MyIteratorImpl<>(bucket, t -> true);
            while (iterator.hasNext()){
                list.add(iterator.next());
            }
        }
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIteratorImpl<>(toList(), t-> true);
    }
}