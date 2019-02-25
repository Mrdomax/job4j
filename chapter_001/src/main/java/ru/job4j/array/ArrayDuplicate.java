package ru.job4j.array;
/**
 * Semenchenko
 * @Class удаляет повторяющиеся элементы в массиве.
 */

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * @param array
     * @return возвращает массив без дубликатов элементов.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
