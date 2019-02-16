package ru.job4j.array;
/**
 * Тест Класс для заполнения матрицы таблицей умножения.
 * @author Semenchenko
 * @since 16.02.2019
 * @version 1
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }
}