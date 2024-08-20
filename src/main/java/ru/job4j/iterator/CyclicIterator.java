package ru.job4j.iterator;

import java.util.*;

public class CyclicIterator<T> implements Iterator<T> {
    private List<T> data;
    private Iterator<T> cursor;

    public CyclicIterator(List<T> data) {
        this.data = data;
        this.cursor = data.iterator();
    }

    @Override
    public boolean hasNext() {
        if (!data.isEmpty() && !cursor.hasNext()) {
            cursor = data.iterator();
        }
        return cursor.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }
}