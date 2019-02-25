package ru.job4j.loop;
/**
 * @author Kasian Semenchenko (kasian.job@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     *
     * @param width
     * @param height
     * @return возвращает "шахматную" доску
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 1; i <= height; i++) {
            for (int index = 1; index <= width; index++) {
                if ((index + i) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}