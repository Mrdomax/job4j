package ru.job4j.array;
/**
 * @author Semenchenko
 */
public class FindLoop {
    /**
     * Metod
     * @param data
     * @param el
     * @return номер ячейки массива
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index != data.length; ++index) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}