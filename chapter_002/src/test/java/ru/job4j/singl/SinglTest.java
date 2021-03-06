package ru.job4j.singl;
import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SinglTest {

    @Test
    public void trackerFirstSingleCheck() {
        TrackerFirst tracker = TrackerFirst.INSTANCE;
        TrackerFirst tracker2 = TrackerFirst.INSTANCE;
        boolean expect = true;
        assertThat(tracker == tracker2, is(expect));
    }

    @Test
    public void trackerSecondSingleCheck() {
        TrackerSecond tracker = TrackerSecond.getInstance();
        TrackerSecond tracker2 = TrackerSecond.getInstance();
        boolean expect = true;
        assertThat(tracker == tracker2, is(expect));
    }

    @Test
    public void trackerThirdSingleCheck() {
        TrackerThird tracker = TrackerThird.getInstance();
        TrackerThird tracker2 = TrackerThird.getInstance();
        boolean expect = true;
        assertThat(tracker == tracker2, is(expect));
    }

    @Test
    public void trackerFourthSingleCheck() {
        TrackerFourth tracker = TrackerFourth.getInstance();
        TrackerFourth tracker2 = TrackerFourth.getInstance();
        boolean expect = true;
        assertThat(tracker == tracker2, is(expect));
    }


}
