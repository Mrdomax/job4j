package ru.job4j.array;

        import org.hamcrest.Matchers;
        import org.junit.Test;

        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;
/**
 * @author Semenchenko
 */
public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort turner = new BubbleSort();
        int[] input = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = turner.sort(input);
        int[] expect = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, Matchers.is(expect));
    }
}