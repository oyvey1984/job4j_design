package ru.job4j.collection;

import java.util.*;
import java.util.Iterator;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    private Node<T> node(int index) {
        Node<T> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    public void add(T value) {
        Node<T> x = head;
        final Node<T> newNode = new Node<>(value, null);
        if (x == null) {
            head = newNode;
        } else {
            while (x.next != null) {
                x = x.next;
            }
            x.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return node(index).item;
    }

    public T deleteFirst() {
        final Node<T> f = head;
        if (f == null) {
            throw new NoSuchElementException();
        }
        final T element = f.item;
        final Node<T> next = f.next;
        f.item = null;
        f.next = null;
        head = next;
        size--;
        modCount++;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> lastReturned;
            private Node<T> next = head;
            final int expectedModCount = modCount;
            private int nextIndex;

            private void checkModCount() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                checkModCount();
                return nextIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = next;
                next = next.next;
                nextIndex++;
                return lastReturned.item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}
