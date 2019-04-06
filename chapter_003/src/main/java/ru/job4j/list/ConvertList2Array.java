package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    /**
     * Внутри методов использовать foreach.
     *
     * public int[][] toArray (List<Integer> list, int rows) {} - метод toArray должен равномерно разбить лист на количество строк двумерного массива.
     * В методе toArray должна быть проверка - если количество элементов не кратно количеству строк - оставшиеся значения в массиве заполнять нулями.
     *
     * Например в результате конвертации листа со значениями (1,2,3,4,5,6,7)
     * с разбиением на 3 строки должен получиться двумерный массив {{1, 2, 3} {4, 5, 6} {7, 0 ,0}}
     * @param list
     * @param rows
     * @return
     */

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() - (list.size() / rows) * rows > 0) {
            cells = list.size() / rows + 1;
        }
        int[][] array1 = new int[rows][cells];
        int i = 0;
        int j = 0;
            for (Integer a : list) {
                array1[i][j] = a;
                j++;
                if (j == cells) {
                    i++;
                    j = 0;
                }
            }
        return array1;
    }
}
