package ru.job4j.collections.list;

public class SimpleStack<T> {

    private DinamicLinkedList<T> dinamicLinkedList = new DinamicLinkedList<>();

    public T poll() {
        return dinamicLinkedList.delete();
    }

    public void push(T value) {
        dinamicLinkedList.add(value);
    }

    public T getValue(int index) {
        return dinamicLinkedList.get(index);
    }

    public boolean isEmpty() {
        return  !dinamicLinkedList.iterator().hasNext();
    }

}