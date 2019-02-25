package ru.job4j.condition;
/**
 * @author Semenchenko
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Периметр/2.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2; // вместо -1 нужно написать формулу вычисляющую полупериметр.
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть площадь, если треугольник существует, или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет, можно ли построить треугольник с такими длинами сторон.
     *
     * Подумайте, какое надо написать условие, чтобы определить можно ли построить треугольник.
     *
     * @param ab Длина от точки a до точки b.
     * @param ac Длина от точки a до точки c.
     * @param bc Длина от точки b до точки c.
     * @return
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab + bc != ac && ac + bc != ab && ac + ab != bc;
    }
}
