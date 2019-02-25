package ru.job4j.array;

/**
 * @author Semenchenko
 */
public class Square {
    /**
     * @Metod заполняем массив
     * @param bound
     * @return возвращает значение массива в квадрате.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; ++i) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}