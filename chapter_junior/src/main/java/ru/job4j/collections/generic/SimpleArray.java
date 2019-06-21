package ru.job4j.collections.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private int size;
    private int count = 0;
    private int index = 0;

    private Object[] objects;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }
    /**
     * добавляет указанный элемент (model) в первую свободную ячейку
     * @param model параметр
     */
    public void add(T model) {
        this.objects[index++] = model;
        count++;
    }

    /**
     * заменяет указанным элементом (model) элемент, находящийся по индексу index
     * @param index параметр
     * @param model параметр
     */
    public void set(int index, T model) {
        if (index < count) {
            this.objects[index] = model;
        }
    }

    /**
     *  удаляет элемент по указанному индексу, все находящиеся справа элементы.
     *  При этом необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);
     * @param index параметр
     */
    public void remove(int index) {
        if (index < count) {
            System.arraycopy(objects, index + 1, objects, index, count - index - 1);
            objects[objects.length - 1] = null;
            count--;
        }
    }

    /**
     * возвращает элемент, расположенный по указанному индексу
     * @param index параметр
     */
    public T get(int index) {
        return (T) this.objects[index];
    }

    public class MyIterator implements Iterator<T> {
        private int position = 0;
        @Override
        public boolean hasNext() {
            boolean result = false;
            if (position < count) {
                result = true;
            }
            return result;
        }

        @Override
        public T next() {
            T nextObject;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            nextObject = (T) objects[position++];
            return nextObject;
        }
    }

    /**
     * метод iterator() возвращает итератор, предназначенный для обхода данной структуры.
     * @return параметр
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
}