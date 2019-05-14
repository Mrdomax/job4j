package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenTreeSetThanSortedByAge() {
        List<User> list = List.of(
        new User("Petr", 26),
        new User("Viktor", 25),
        new User("Olga", 24)
        );
        SortUser treeSort1 = new SortUser();
        Set<User> result = treeSort1.sort1(list);
        assertThat(result.iterator().next().getName(), is("Olga"));
    }

    @Test
    public void whenListThanSortedByNameLength() {
        List<User> list = List.of(
        new User("Vika", 22),
        new User("Viktor", 23),
        new User("Vik", 21)
        );
        ArrayList<User> list1 = new ArrayList<>(list);
        SortUser sortedNameLength = new SortUser();
        List<User> result = sortedNameLength.sortNameLength(list1);
        assertThat(result.iterator().next().getName(), is("Vik"));
    }

    @Test
    public void whenListThanSortedByAllFields() {
        List<User> list = List.of(
        new User("Vika", 22),
        new User("Vika", 21),
        new User("Viktor", 23)
        );
        ArrayList<User> list1 = new ArrayList<>(list);
        SortUser sortedNameAge = new SortUser();
        List<User> result = sortedNameAge.sortByAllFields(list1);
        assertThat(result.iterator().next().getAge(), is(21));
    }
}
