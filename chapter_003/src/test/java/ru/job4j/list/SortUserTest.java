package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void WhenTreeSetThanSortedByAge() {
        List<User> list = new ArrayList<>();
        list.add(new User ("Petr", 26));
        list.add(new User ("Viktor", 25));
        list.add(new User ("Olga", 24));
        SortUser treeSort1 = new SortUser();
        Set<User> result = treeSort1.sort1(list);
        assertThat(result.iterator().next().getName(), is("Olga"));
    }
}
