package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array1) {
    List<Integer> list = new ArrayList<>();
    int index = 0;
    for (int[] a : array1) {
        for (int x : a) {
            list.add(index, x);
            index++;
        }
    }
    return list;
}
}