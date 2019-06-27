package ru.job4j.collections.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicLinkedList<E> implements Iterable {
    private int size;
    private Node<E> node;
    private int modCount = 0;


    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.node;
        this.node = newLink;
        this.size++;
        modCount++;
    }

    public E get(int index) {
        Node<E> result = this.node;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public E delete() {
        Node<E> temp = node;
        node = node.next;
        this.size--;
        return temp.data;
    }

    public class MyIterator implements Iterator<E> {
        private int position = 0;
        private int expectedModCount = modCount;
        private E nextObject;
        private Node<E> nextNode = node;

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            } else if (position < size) {
                result = true;
            }
            return result;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = nextNode.data;
            nextNode = nextNode.next;
            position++;
            return data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
