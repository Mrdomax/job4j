package ru.job4j.collections.map;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        HashMap<Integer, String> map = new HashMap<>();
        Info result = new Info();
        result.added = 0;
        result.changed = 0;
        result.deleted = 0;
        for (User user : previous) {
            map.put(user.id, user.name);
        }
        for (User user : current) {
            Object value = map.get(user.id);
            if (value == null) {
                result.added++;
            } else if (!user.name.equals(value)) {
                result.changed++;
                map.remove(user.id);
            } else {
                map.remove(user.id);
            }
        }
        result.deleted = map.size();
        return result;
    }

    public static class User {
        int id;
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {

        int added;
        int changed;

        int deleted;

    }

}
