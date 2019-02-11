package ru.job4j.max;
/**
 * @author Semenchenko
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstLessSecondlessThird() {
        Max maxim = new Max();
        int result = maxim.max(6, 5, 4);
        assertThat(result, is(6));
    }
}
