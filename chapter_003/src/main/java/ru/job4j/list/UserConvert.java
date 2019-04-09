package ru.job4j.list;

import java.util.List;

import java.util.HashMap;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userHashMap = new HashMap<>();
        for (User a : list) {
            userHashMap.put(a.getId(), a);
        }
        return userHashMap;
    }
}
