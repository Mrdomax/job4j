package ru.job4j.loop;
/**
 * @author Kasian Semenchenko (kasian.job@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Metod !
     * @param n
     * @param
     * @return
     */
    public int calc(int n) {
        int a = 1;
        for (int i = 1; i <= n ; i++) {

            if (n == 0) {
                return 1;
            }else a = a*i;
        }return a;
    }
}