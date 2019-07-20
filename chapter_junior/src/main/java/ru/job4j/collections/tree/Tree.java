package ru.job4j.collections.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private int pointer = 1;
    private Node<E> root;
    private int modCount = 0;

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> findParent = findBy(parent);
        if (findParent.isPresent() && findBy(child).isEmpty()) {
            findParent.get().leaves().add(new Node<>(child));
            pointer++;
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty(); // создает пустой Optional объект rsl
        Queue<Node<E>> data = new LinkedList<>(); // создаёт очередь data
        data.offer(root);                         // Метод offer() вставляет элемент this.root в очередь, если это не удалось - возвращает false.
        while (!data.isEmpty()) {                 // цикл выполняется до тех пор, пока очередь не пустая.
            Node<E> el = data.poll();             // создаёт переменную el и присваивает ей значение элемента из очереди Queue<Node<E>> data
            if (el.eqValue(value)) {              // если: сравнивает el и искомое value типа E
                rsl = Optional.of(el);            // Присваивает rsl значение el если оно не null и равно искомому.
                break;
            }
            for (Node<E> child : el.leaves()) {   // Для каждого child из связанного списка el(если el содержит не одну ноду, а связанный список)
                data.offer(child);                // Добавляем в очередь data все элементы связанного списка el
            }
        }
        return rsl;
    }

    public class MyIterator implements Iterator<E> {

        private int position = 0;
        private int expectedCount = modCount;
        Queue<Node<E>> data = new LinkedList<>();

        public MyIterator() {
            data.offer(root);
        }

        @Override
        public boolean hasNext() {
            return position < pointer;
        }

        @Override
        public E next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedCount != modCount) {
                throw new ConcurrentModificationException();
            }
            Node<E> node = data.poll();
            for (Node<E> child : node.leaves()) {
                data.offer(child);
            }
            position++;
            return node.get();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }
}
