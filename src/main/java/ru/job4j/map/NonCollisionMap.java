package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        boolean result = false;
        int hashCode = Objects.hashCode(key);
        int i = indexFor(hash(hashCode));
        if (table[i] == null) {
            table[i] = new MapEntry<>(key, value);
            count++;
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public V get(K key) {
        int hashCode = Objects.hashCode(key);
        int i = indexFor(hash(hashCode));
        MapEntry<K, V> first = table[i];
        return checkEquals(first, key) ? first.value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int hashCode = Objects.hashCode(key);
        int i = indexFor(hash(hashCode));
        MapEntry<K, V> first = table[i];
        if (checkEquals(first, key)) {
            table[i] = null;
            count--;
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModCount = modCount;
            private int index;

            private void checkModCount() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                checkModCount();
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return table.length > 0 && index < table.length && table[index] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : (hashCode) ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> mapEntry : table) {
            if (mapEntry != null) {
                int i = indexFor(hash(Objects.hashCode(mapEntry.key)));
                newTable[i] = mapEntry;
            }
        }
        table = newTable;
    }

    private boolean checkEquals(MapEntry<K, V> first, K key) {
        return first != null
                && Objects.hashCode(first.key) == Objects.hashCode(key)
                && Objects.equals(first.key, key);
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}