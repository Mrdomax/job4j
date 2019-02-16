package ru.job4j.array;
/**
 * @author Semenchenko
 */
public class Check {
    /**
     * Metod
     * @param data
     * @return
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; ++i) {
            if( data [0] != data [i]) { result = false; break; }

        }
        return result;
    }
}