package ru.job4j.collections.generic;


import java.util.Iterator;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    private int size;
    public SimpleArray<T> simpleArray = new SimpleArray<>(size);

    public Integer getIndex(T model) {
        Integer result = -1;
        int count = 0;
        Iterator iterator = simpleArray.iterator();
        while (iterator.hasNext()) {
            count++;
            if (iterator.next().equals(model)) {
                result = count - 1;
                break;
            }
        } return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T user : simpleArray) {
            if (user != null && user.getId().equals(id)) {
                result = user;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = getIndex(findById(id));
        if (index != -1) {
            simpleArray.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = getIndex(findById(id));
        if (index != -1) {
            simpleArray.set(index, model);
            result = true;
        }
        return result;
    }
}
