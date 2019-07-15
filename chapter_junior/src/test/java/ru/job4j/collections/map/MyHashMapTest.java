package ru.job4j.collections.map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class MyHashMapTest {


    @Test
    public void whenInsertThanMapGetIt() {
        MyHashMap map = new MyHashMap();
        assertThat(map.insert("Key", 10), is(true));
        assertThat(map.get("Key"), is(10));
    }

    @Test
    public void whenDeleteThanMapReturnTrue() {
        MyHashMap map = new MyHashMap();
        assertThat(map.insert("Key", 10), is(true));
        assertThat(map.get("Key"), is(10));
        assertThat(map.delete("Key"), is(true));
    }

    @Test
    public void whenHasNextThanTrue() {
        MyHashMap map = new MyHashMap();
        map.insert("Key", 10);
        MyHashMap.MyIterator iterator = map.new MyIterator();
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void iteratorNextTest() {
        MyHashMap map = new MyHashMap();
        map.insert("Aey", 10);
        map.insert("Beey", 11);
        MyHashMap.MyIterator iterator = map.new MyIterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(10));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(11));
        assertThat(iterator.hasNext(), is(false));
    }
}