package ru.job4j.list;

import java.util.*;

public class SortUser {

    public Set<User> sort1 (List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength (List<User> list) {
        list.sort(
                new Comparator<User>(){
            @Override
            public int compare(User o1, User o2) {
                Integer o1Length = o1.getName().length();
                Integer o2Length = o2.getName().length();
                return o1Length.compareTo(o2Length);
            }
        });
        return list;
    }

    public List<User> sortByAllFields (List<User> list) {
        list.sort(
                new Comparator<User>(){
                    @Override
                    public int compare(User o1, User o2) {
                        int value = o1.getName().compareTo(o2.getName());
                        if (value == 0) {
                            value = o1.getAge().compareTo(o2.getAge());
                        }
                        return value;
                    }
                });
        return list;
    }
}
