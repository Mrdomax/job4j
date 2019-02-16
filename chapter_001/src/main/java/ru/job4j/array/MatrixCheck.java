package ru.job4j.array;
/**
 * Class Класс для сравнения значений по диагонали
 * @author Semenchenko
 * @since 17.02.2019
 * @version 1
 */
public class MatrixCheck {
    /**
     *
     * @param data
     * @return
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
         /**
         *  Проверка диагоналей.
         *  Они не обязательно равны.
         *  Они не обязательно имеют общие ячейки.
         */
        for (int out = 0; out != data.length - 2; out++) {
            for (int inner = 0; inner != data.length - 2; inner++) {
                /**
                 * Проверка первой диагонали
                 */
                if (data[out][inner] != data[out + 1][inner + 1]) {
                    result = false;
                    break;

                }
                /**
                 * Проверка второй диагонали
                 */
                if (data[out][data.length - 1 - out] != data[out + 1][data.length - 1 - (out + 1)]) {
                    result = false;
                    break;
                }
            }
        } return result;
    }

}

