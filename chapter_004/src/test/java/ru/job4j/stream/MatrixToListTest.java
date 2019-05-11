package ru.job4j.stream;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;

public class MatrixToListTest {

    @Test
    public void WhenCollectIntegerThanReturnList() {
        MatrixToList newMatrix = new MatrixToList();
        Integer[][] matrix = {{1, 2},{3, 4}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = newMatrix.convert(matrix);
        assertThat(result, is(expected));
    }
}
