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

    @Test
    public void WhenListThanSortedByNameLength() {
        List<User> list = new ArrayList<>();
        list.add(new User ("Vika", 22));
        list.add(new User ("Viktor", 23));
        list.add(new User ("Vik", 21));
        SortUser sortedNameLenrth = new SortUser();
        List<User> result = sortedNameLenrth.sortNameLength(list);
        assertThat(result.iterator().next().getName(), is("Vik"));
    }

    @Test
    public void WhenListThanSortedByAllFields() {
        List<User> list = new ArrayList<>();
        list.add(new User ("Vika", 22));
        list.add(new User ("Vika", 21));
        list.add(new User ("Viktor", 23));
        SortUser sortedNameAge = new SortUser();
        List<User> result = sortedNameAge.sortByAllFields(list);
        assertThat(result.iterator().next().getAge(), is(21));
    }
}
