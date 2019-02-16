package ru.job4j.array;

/**
 * @author Semenchenko
 */
public class BubbleSort {
    /**
     *
     * @param array
     * @return
     */
    public int[] sort(int[] array) {
        for (int a = 0; a < array.length - 1; a++) {
            for (int i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    int k = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = k;
                }
            }
        } return array;
    }

}
