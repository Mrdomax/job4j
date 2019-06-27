package ru.job4j.collections.list;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class SimpleQueueTest {

    @Test
    public void whenPushAndPollThanFifoOrder() {
        SimpleQueue simpleQueue = new SimpleQueue();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
    }
}