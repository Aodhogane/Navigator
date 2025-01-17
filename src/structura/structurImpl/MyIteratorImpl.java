package structura.structurImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class MyIteratorImpl<T> implements Iterator<T> {

    private MyArrayListIml<T> list;
    private final Predicate<T> filter;
    private int currentIndex;

    public MyIteratorImpl(MyArrayListIml<T> list, Predicate<T> filter) {
        this.list = list;
        this.filter = filter;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        int peekIndex = currentIndex;
        while (peekIndex < list.size()) {
            T currentT = list.get(peekIndex);
            if (filter.test(currentT)) {
                return true;
            }
            peekIndex++;
        }
        return false;
    }

    @Override
    public T next() {
        while (currentIndex < list.size()) {
            T currentT = list.get(currentIndex);
            if (filter.test(currentT)) {
                currentIndex++;
                return currentT;
            }
            currentIndex++;
        }
        throw new NoSuchElementException();
    }
}
