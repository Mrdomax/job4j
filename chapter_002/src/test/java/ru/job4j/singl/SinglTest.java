package ru.job4j.singl;
import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SinglTest {

    @Test
    public void TrackerFirstSingleCheck() {
        TrackerFirst tracker = TrackerFirst.INSTANCE;
        Item frst = new Item("test1", "testDescription0", 123L);
        tracker.add(frst);
        TrackerFirst tracker2 = TrackerFirst.INSTANCE;
        Item scnd = new Item("test1", "testDescription1", 1234L);
        tracker2.add(scnd);
        Item[] expect = {frst, scnd};
        assertThat(tracker.findAll(), is(expect));
    }

    @Test
    public void TrackerSecondSingleCheck() {
        TrackerSecond tracker = TrackerSecond.getInstance();
        Item frst = new Item("test1", "testDescription0", 123L);
        tracker.add(frst);
        TrackerSecond tracker2 = TrackerSecond.getInstance();
        Item scnd = new Item("test1", "testDescription1", 1234L);
        tracker2.add(scnd);
        Item[] expect = {frst, scnd};
        assertThat(tracker.findAll(), is(expect));
    }

    @Test
    public void TrackerThirdSingleCheck() {
        TrackerThird tracker = TrackerThird.getInstance();
        Item frst = new Item("test1", "testDescription0", 123L);
        tracker.add(frst);
        TrackerThird tracker2 = TrackerThird.getInstance();
        Item scnd = new Item("test1", "testDescription1", 1234L);
        tracker2.add(scnd);
        Item[] expect = {frst, scnd};
        assertThat(tracker.findAll(), is(expect));
    }

    @Test
    public void TrackerFourthSingleCheck() {
        TrackerFourth tracker = TrackerFourth.getInstance();
        Item frst = new Item("test1", "testDescription0", 123L);
        tracker.add(frst);
        TrackerFourth tracker2 = TrackerFourth.getInstance();
        Item scnd = new Item("test1", "testDescription1", 1234L);
        tracker2.add(scnd);
        Item[] expect = {frst, scnd};
        assertThat(tracker.findAll(), is(expect));
    }


}
