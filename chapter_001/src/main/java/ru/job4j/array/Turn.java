package ru.job4j.array;
/**
 * @author Semenchenko
 */
public class Turn {
    /**
     *
     * @param array
     * @return
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; ++i) {
            int k = array[i];
            array[i] = array[array.length - i -1];
            array[array.length - 1 - i] = k;
            }

         return array;
    }
}