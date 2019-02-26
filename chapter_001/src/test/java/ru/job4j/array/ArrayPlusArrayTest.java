package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Test;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Semenchenko
 */
public class ArrayPlusArrayTest {
    @Test
    public void whenArrayPlusArrayThenNewSortedArray() {
        ArrayPlusArray turner = new ArrayPlusArray();
        int[] input1 = new int[] {1, 3, 5, 7, 9};
        int[] input2 = new int[] {1, 2, 4, 6, 8, 10};
        int[] result = turner.integration(input1, input2);
        int[] expect = new int[] {1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, Matchers.is(expect));
    }
}