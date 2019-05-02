package ru.job4j.lyambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class FunctionCalcTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalc function = new FunctionCalc();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalc function = new FunctionCalc();
        List<Double> result = function.diapason(5, 8, x -> x * x + x + 1);
        List<Double> expected = Arrays.asList(31D, 43D, 57D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        FunctionCalc function = new FunctionCalc();
        List<Double> result = function.diapason(5, 8, x -> Math.log(x) / Math.log(x) + x);
        List<Double> expected = Arrays.asList(6D, 7D, 8D);
        assertThat(result, is(expected));
    }
}
