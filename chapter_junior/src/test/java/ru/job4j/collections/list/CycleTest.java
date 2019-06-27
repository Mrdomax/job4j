package ru.job4j.collections.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CycleTest {

    @Test
    public void hasCycle() {
        Cycle cycle = new Cycle();
        assertThat(cycle.hasCycle(cycle.first), is(true));
    }
}