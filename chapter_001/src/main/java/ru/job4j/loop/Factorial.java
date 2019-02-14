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
        if (n <= 1)
            return 1;
        else
            for (int i = 2; i <= n ; i++) {
            a = a*i;
            } return a;
        }
    }
