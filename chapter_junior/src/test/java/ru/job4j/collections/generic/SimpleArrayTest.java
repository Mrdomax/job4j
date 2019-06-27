package ru.job4j.collections.generic;


import org.junit.Test;


import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    @Test
    public void whenAddIntegerThanMassiveGetThis() {
        SimpleArray simpleArray = new SimpleArray(1);
        simpleArray.add(10);
        assertThat(simpleArray.get(0), is(10));
    }

    @Test
    public void whenAddStringThanMassiveGetThis() {
        SimpleArray simpleArray = new SimpleArray(1);
        simpleArray.add("Test");
        assertThat(simpleArray.get(0), is("Test"));
    }

    @Test
    public void whenSetThanMassiveGetThis() {
        SimpleArray simpleArray = new SimpleArray(1);
        simpleArray.add("Test");
        simpleArray.set(0, "NewTest");
        assertThat(simpleArray.get(0), is("NewTest"));
    }

    @Test
    public void whenRemoveThanMassiveDontHaveThis() {
        SimpleArray simpleArray = new SimpleArray(2);
        simpleArray.add("Test");
        simpleArray.add("Test2");
        simpleArray.remove(0);
        assertThat(simpleArray.get(0), is("Test2"));
    }

    @Test
    public void whenGetThanReturnThisValue() {
        SimpleArray simpleArray = new SimpleArray(2);
        simpleArray.add(10);
        assertThat(simpleArray.get(0), is(10));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenMassiveOverloadThanThrowException() {
        SimpleArray simpleArray = new SimpleArray(0);
        simpleArray.add(10);
        simpleArray.add(11);
    }

    @Test
    public void  iteratorShouldReturnFalseIfNoAnyEvenNumbers() {
        SimpleArray simpleArray = new SimpleArray(0);
        assertThat(simpleArray.iterator().hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorShouldThrowException() {
        SimpleArray simpleArray = new SimpleArray(0);
        simpleArray.iterator().next();
    }

    @Test
    public void iteratorHasNextTest() {
        SimpleArray simpleArray = new SimpleArray(2);
        simpleArray.add(10);
        simpleArray.add(11);
        assertThat(simpleArray.iterator().hasNext(), is(true));
    }

    @Test
    public void iteratorNextTest() {
        SimpleArray simpleArray = new SimpleArray(2);
        Iterator iterator = simpleArray.iterator();
        simpleArray.add(10);
        simpleArray.add(11);
        assertThat(iterator.next(), is(10));
        assertThat(iterator.next(), is(11));
    }
}