package ru.job4j.array;
/**
 * Class Класс для заполнения матрицы таблицей умножения.
 * @author Semenchenko
 * @since 16.02.2019
 * @version 1
 */
public class Matrix {
    /**
     *
     * @param size
     * @return
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int out = 0; out != size; out++) {
            for (int inner = 0; inner != size; inner++) {
                table [out][inner] = (out + 1) * (inner + 1);
            }
        }
        return table;
    }
}