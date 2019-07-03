package ru.job4j.collections.list;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable {

    // тут композиция
    private DynamicList dynamicList = new DynamicList();

    private int count = 0;

    @Override
    public Iterator<E> iterator() {
        return dynamicList.iterator();
    }

    public boolean findDuplicates(E e) {
        boolean result = false;
        for (int i = 0; i != count; i++) {
            if (dynamicList.get(i).equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void add(E e) {
        if (!findDuplicates(e)) {
            dynamicList.add(e);
            count++;
        }
    }
}
