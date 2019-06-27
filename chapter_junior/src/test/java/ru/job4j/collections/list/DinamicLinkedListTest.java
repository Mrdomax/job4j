package ru.job4j.collections.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DinamicLinkedListTest {

    @Test
    public void whenAddIntegerThanMassiveGetThis() {
        DinamicLinkedList dinamicLinkedList = new DinamicLinkedList();
        dinamicLinkedList.add(10);
        assertThat(dinamicLinkedList.get(0), is(10));
    }

    @Test
    public void whenGetThanReturnElement() {
        DinamicLinkedList dinamicLinkedList = new DinamicLinkedList();
        dinamicLinkedList.add(10);
        dinamicLinkedList.add(11);
        dinamicLinkedList.add(12);
        assertThat(dinamicLinkedList.get(1), is(11));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModifiedListThanIteratorThrowCME() {
        DinamicLinkedList dinamicLinkedList = new DinamicLinkedList();
        DinamicLinkedList.MyIterator myIterator = dinamicLinkedList.new MyIterator();
        dinamicLinkedList.add(10);
        myIterator.next();
        dinamicLinkedList.add(10);
        myIterator.next();
    }

    @Test
    public void iteratorHasNextTest() {
        DinamicLinkedList dinamicLinkedList = new DinamicLinkedList();
        dinamicLinkedList.add(10);
        DinamicLinkedList.MyIterator myIterator = dinamicLinkedList.new MyIterator();
        assertThat(myIterator.hasNext(), is(true));
    }

    @Test
    public void iteratorNextTest() {
        DinamicLinkedList dinamicLinkedList = new DinamicLinkedList();
        dinamicLinkedList.add(10);
        dinamicLinkedList.add(11);
        DinamicLinkedList.MyIterator myIterator = dinamicLinkedList.new MyIterator();
        assertThat(myIterator.hasNext(), is(true));
        assertThat(myIterator.next(), is(11));
        assertThat(myIterator.hasNext(), is(true));
        assertThat(myIterator.next(), is(10));
        assertThat(myIterator.hasNext(), is(false));
    }

    @Test
    public void whenDeleteThanDeletedAndReturnData() {
        DinamicLinkedList dinamicLinkedList = new DinamicLinkedList();
        dinamicLinkedList.add(10);
        dinamicLinkedList.add(11);
        assertThat(dinamicLinkedList.delete(), is(11));
        DinamicLinkedList.MyIterator myIterator = dinamicLinkedList.new MyIterator();
        assertThat(myIterator.hasNext(), is(true));
        assertThat(myIterator.next(), is(10));
        assertThat(myIterator.hasNext(), is(false));
    }
}