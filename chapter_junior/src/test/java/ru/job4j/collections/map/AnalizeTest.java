package ru.job4j.collections.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;

public class AnalizeTest {

    @Test
    public void diffTest() {
        Analize analize = new Analize();
        Analize.User one = new Analize.User();
        one.id = 000001;
        one.name = "One";
        Analize.User two = new Analize.User();
        two.id = 000002;
        two.name = "Two";
        Analize.User three = new Analize.User();
        three.id = 000003;
        three.name = "Tree";
        Analize.User modTwo = new Analize.User();
        modTwo.id = 000002;
        modTwo.name = "modTwo";
        List<Analize.User> previous = new ArrayList<>();
        previous.add(one);
        previous.add(two);
        List<Analize.User> current = new ArrayList<>();
        current.add(three);
        current.add(modTwo);
        Analize.Info result = analize.diff(previous, current);
        assertThat(result.added, is(1));
        assertThat(result.changed, is(1));
        assertThat(result.deleted, is(1));
    }
}