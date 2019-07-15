package ru.job4j.collections.map;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashMap<K, V> implements Iterable {

    private final int arraySize = 10;
    private int pointer = 0;
    private Node[] massive = new Node[arraySize];

    public boolean insert(K key, V value) {
        boolean result;
        if (pointer == massive.length - 1) {
            Node[] newArray = new Node[massive.length * 2];
            System.arraycopy(massive, 0, newArray, 0, pointer);
            this.massive = newArray;
        }
        if (massive[hash(key) & (massive.length - 1)] != null) {
            result = false;
        } else {
            Node<V> node = new Node<>(value);
            massive[hash(key) & (massive.length - 1)] = node;
            pointer++;
            result = true;
        }
        return result;
    }


    public V get(K key) {
        return (V) massive[hash(key) & (massive.length - 1)].data;
    }

    public boolean delete(K key) {
        massive[hash(key) & (massive.length - 1)] = null;
        pointer--;
        return massive[hash(key) & (massive.length - 1)] == null;
    }

    /**
     * Метод для генерации хэшкода.
     */
    private static final int hash(Object key) {
        int h;
        int result;
        if (key == null) {
            result = 0;
        } else {
            h = key.hashCode();
            result = (h) ^ (h >>> 16);
        }
        return result;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    /**
     * Класс итератор.
     */
    public class MyIterator implements Iterator<V> {

        private int position = 0;
        private int index = 0;


        @Override
        public boolean hasNext() {
            return position < pointer;
        }

        @Override
        public V next() {
            V value = null;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            for (int i = index; i < massive.length - 1; i++) {
                if (massive[i] != null) {
                    value = (V) massive[i].data;
                    index = ++i;
                    position++;
                    break;
                }
            }
            return value;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new MyIterator();
    }

}

