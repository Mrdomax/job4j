package ru.job4j.collections.list;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class SimpleStackTest {

    @Test
    public void whenPollThanStackReturnValueAndDeleteValue() {
        SimpleStack simpleStack = new SimpleStack();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
    }

    @Test
    public void whenPushThanStackGetValue() {
        SimpleStack simpleStack = new SimpleStack();
        simpleStack.push(1);
        assertThat(simpleStack.getValue(0), is(1));
    }

    @Test
    public void whenEmptyThanReturnTrue() {
        SimpleStack simpleStack = new SimpleStack();
        assertThat(simpleStack.isEmpty(), is(true));
    }
}