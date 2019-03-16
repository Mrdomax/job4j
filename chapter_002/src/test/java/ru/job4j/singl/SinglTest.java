package ru.job4j.singl;
import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SinglTest {

    @Test
    public void TrackerFirstSingleCheck() {
        TrackerFirst tracker = TrackerFirst.INSTANCE;
        TrackerFirst tracker2 = TrackerFirst.INSTANCE;
        boolean expect = true;
        assertThat(tracker == tracker2, is(expect));
    }

    @Test
    public void TrackerSecondSingleCheck() {
        TrackerSecond tracker = TrackerSecond.getInstance();
        TrackerSecond tracker2 = TrackerSecond.getInstance();
        boolean expect = true;
        assertThat(tracker == tracker2, is(expect));
    }

    @Test
    public void TrackerThirdSingleCheck() {
        TrackerThird tracker = TrackerThird.getInstance();
        TrackerThird tracker2 = TrackerThird.getInstance();
        boolean expect = true;
        assertThat(tracker == tracker2, is(expect));
    }

    @Test
    public void TrackerFourthSingleCheck() {
        TrackerFourth tracker = TrackerFourth.getInstance();
        TrackerFourth tracker2 = TrackerFourth.getInstance();
        boolean expect = true;
        assertThat(tracker == tracker2, is(expect));
    }


}
