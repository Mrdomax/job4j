package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListToHashMap() {
        UserConvert one = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(1111, "Petr", "Ghy") );
        HashMap<Integer, User> result = one.process(list);
        String expect = "Petr";
        assertThat(result.get(1111).getName(), is(expect));
    }
}
