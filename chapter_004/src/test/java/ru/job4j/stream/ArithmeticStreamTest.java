package ru.job4j.stream;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;

public class ArithmeticStreamTest {
    @Test
    public void whenConvertIntegerThanReturnArithmeticInt() {
        ArithmeticStream arithmeticStream = new ArithmeticStream();
        Integer[] massive = {1, 2, 3, 4, 5, 6, 7};
        int expected = 56;
        int result = arithmeticStream.convert(massive);
        assertThat(result, is(expected));
    }
}
