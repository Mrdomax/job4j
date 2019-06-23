package ru.job4j.collections.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<E> implements Iterable<E> {
    private final int arraySize = 10;
    private Object[] container = new Object[arraySize];
    private int pointer = 0;
    private int modCount = 0;

    public void add(E value) {
        if (pointer == container.length - 1) {
        grow(container);
        }
       container[pointer++] = value;
        modCount++;
    }

    public Object[] grow(Object[] container) {
        Object[] newArray = new Object[container.length * 2];
        System.arraycopy(container, 0, newArray, 0, pointer);
        this.container = newArray;
        return this.container;
    }

    public E get(int index) {
        return (E) container[index];
    }

    public int getSize() {
        return container.length;
    }

    public class MyIterator implements Iterator<E> {
        private int position = 0;
        private int expectedModCount = modCount;
        @Override
        public boolean hasNext() {
            boolean result = false;
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            } else if (position < pointer) {
                result = true;
            }
            return result;
        }

        @Override
        public E next() {
            E nextObject;
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            } else if (!hasNext()) {
                throw new NoSuchElementException();
            }
            nextObject = (E) container[position++];
            return nextObject;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }
}
