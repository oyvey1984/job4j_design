package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;
    private static final int DEFAULT_CAPACITY = 10;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    private void increaseCapacity() {
        if (container.length == 0) {
            this.container = (T[]) new Object[DEFAULT_CAPACITY];
        } else if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    @Override
    public void add(T value) {
        increaseCapacity();
        container[size] = value;
        size++;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T oldValue = get(index);
        container[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        T oldValue = get(index);
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index - 1
        );
        container[container.length - 1] = null;
        modCount++;
        size--;
        return oldValue;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int expectedModCount = modCount;
            private int point;

            private void checkModCount() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                checkModCount();
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }
        };
    }
}