package ru.job4j.loop;
/**
 * @author Semenchenko
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Metod
     * @param start
     * @param finish
     * @return возвращает большее из двух
     */
    public int add(int start, int finish) {
        int sum = 0;
       for (int index = start; index <= finish; index++) {
           if (index % 2 == 0) {
               sum = sum + index;
           }
        } return sum;
    }
}
