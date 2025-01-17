package structura.structurImpl;

import structura.Iterator;
import structura.MyList;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class MyIteratorImpl<T> implements Iterator<T> {

    private MyList<T> list;
    private final Predicate<T> filter;
    private int currentIndex;

    public MyIteratorImpl(MyList<T> list, Predicate<T> filter) {
        this.list = list;
        this.filter = filter;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < list.size()){
            T currentT = list.get(currentIndex);
            if (filter.test(currentT)){
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public T next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        return list.get(currentIndex++);
    }
}
