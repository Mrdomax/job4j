package ru.job4j.condition;
/**
 * @author Semenchenko
 * @version $Id$
 * @since 0.1
 */
        import org.junit.Test;
        import static org.hamcrest.number.IsCloseTo.closeTo;
        import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // создаем 2 объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);

        // Вычисляем расстояние
        double result = a.distanceTo(b);
        // Задаем ожидаемый результат.
        double expected = 2;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 2));
    }
}
