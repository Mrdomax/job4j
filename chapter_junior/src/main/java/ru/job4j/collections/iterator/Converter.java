package ru.job4j.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            Iterator<Integer> inner = it.next();
            @Override
            public boolean hasNext() {
                while (!inner.hasNext() && it.hasNext()) {
                    inner = it.next();
                } return inner.hasNext();
            }

            @Override
            public Integer next() {
                hasNext();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return inner.next();
            }
        };
    }
}
