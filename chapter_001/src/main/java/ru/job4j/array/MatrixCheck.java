package ru.job4j.array;
/**
 * Class Класс для сравнения значений по диагонали
 * @author Semenchenko
 * @since 17.02.2019
 * @version 1
 */
public class MatrixCheck {
    /**
     *  Проверка диагоналей.
     *  Они не обязательно равны.
     *  Они не обязательно имеют общие ячейки.
     * @param data
     * @return  boolean одинаковые/нет диагонали массива
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int out = 0; out != data.length - 2; out++) {
            for (int inner = 0; inner != data.length - 2; inner++) {
                if (data[out][inner] != data[out + 1][inner + 1]) {
                    result = false;
                    break;
                }
                if (data[out][data.length - 1 - out] != data[out + 1][data.length - 1 - (out + 1)]) {
                    result = false;
                    break;
                }
            }
        } return result;
    }

}

