package ru.job4j.max;
/**
 * @author Semenchenko
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Metod
     * @param first
     * @param second
     * @return возвращает большее из двух
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * Metod
     * @param first
     * @param second
     * @param third
     * @return возвращает большее из трёх
     */
    public int max(int first, int second, int third) {
        int temp = this.max(this.max(first, second),third);
        return temp;
    }

}
