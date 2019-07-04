package ru.job4j.collections.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {


    @Test
    public void whenFindStringDuplicatesThanTrue() {
        SimpleSet simpleSet = new SimpleSet();
        simpleSet.add("Test");
        assertThat(simpleSet.findDuplicates("Test"), is(true));
    }

    @Test
    public void whenFindIntegerDuplicatesThanTrue() {
        SimpleSet simpleSet = new SimpleSet();
        simpleSet.add(10);
        assertThat(simpleSet.findDuplicates(10), is(true));
    }



    @Test
    public void whenAddDuplicatesThanNotAdded() {
        SimpleSet simpleSet = new SimpleSet();
        simpleSet.add(10);
        simpleSet.add(10);
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.next(), is(10));
        assertThat(iterator.hasNext(), is(false));
    }

}