package ru.job4j.list;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public Set<User> sort1 (List<User> list) {
        Set<User> treeSort = new TreeSet<>();
        for (User a : list) {
            treeSort.add(a);
        }
        return treeSort;
    }
}
