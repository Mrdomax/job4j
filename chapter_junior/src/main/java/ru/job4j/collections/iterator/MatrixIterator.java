package ru.job4j.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор по двухмерному массиву
 */
public class MatrixIterator implements Iterator {

    private final int[][] massive;
    private int out = 0;
    private int inner = 0;



    public MatrixIterator(int[][] massive) {
        this.massive = massive;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (out <= massive.length - 1) {
            result = true;
        } else if (out == massive.length - 1 && inner == massive[out].length - 1) {
            result = false;
        }
        return result;
    }

    @Override
    public Object next() {
        Object nextObject;
        if (out >= massive.length) {
            throw new NoSuchElementException();
        } else {
            nextObject = massive[out][inner];
        }
        if (inner < massive[out].length - 1) {
            inner++;
        } else {
            inner = 0;
            out++;
        }
        return nextObject;
    }
}
