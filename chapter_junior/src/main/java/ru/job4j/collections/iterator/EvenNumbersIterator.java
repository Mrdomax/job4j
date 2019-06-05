package ru.job4j.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор по четным числам массива произвольных чисел
 */
public class EvenNumbersIterator implements Iterator {

    private final int[] massive;
    private int index = 0;

    public EvenNumbersIterator(int[] massive) {
        this.massive = massive;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i != massive.length; i++) {
            if (massive[i] % 2 == 0) {
                result = true;
                index = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        Object nextObject;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        nextObject = massive[index];
        index++;
        return nextObject;
    }
}
