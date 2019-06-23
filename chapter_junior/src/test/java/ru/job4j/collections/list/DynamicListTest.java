package ru.job4j.collections.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynamicListTest {

    @Test
    public void whenAddIntegerThanMassiveGetThis() {
        DynamicList dynamicList = new DynamicList();
        dynamicList.add(10);
        assertThat(dynamicList.get(0), is(10));
    }

    @Test
    public void whenGetThanReturnElement() {
        DynamicList dynamicList = new DynamicList();
        dynamicList.add(10);
        dynamicList.add(11);
        dynamicList.add(12);
        assertThat(dynamicList.get(1), is(11));
    }

    @Test
    public void whenAddNewItemsThanLengthGrow() {
        DynamicList dynamicList = new DynamicList();
        dynamicList.add(10);
        dynamicList.add(11);
        dynamicList.add(12);
        dynamicList.add(10);
        dynamicList.add(11);
        dynamicList.add(12);
        dynamicList.add(10);
        dynamicList.add(11);
        dynamicList.add(12);
        dynamicList.add(12);
        assertThat(dynamicList.getSize(), is(20));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModifiedListThanIteratorThrowCME() {
        DynamicList dynamicList = new DynamicList();
        DynamicList.MyIterator myIterator = dynamicList.new MyIterator();
        dynamicList.add(10);
        myIterator.next();
        dynamicList.add(10);
        myIterator.next();
    }
}