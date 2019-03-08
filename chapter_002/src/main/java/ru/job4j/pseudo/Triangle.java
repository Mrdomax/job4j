package ru.job4j.pseudo;

/**
 * @author Kasian Semenchenko
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+   \n");
        pic.append("++  \n");
        pic.append("+++ \n");
        pic.append("++++\n");
        return pic.toString();
    }
}