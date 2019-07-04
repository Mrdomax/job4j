package ru.job4j.collections.list;

public class SimpleQueue<T> {

    private SimpleStack<T> simpleStack = new SimpleStack();
    private SimpleStack<T> reversed = new SimpleStack();


    public T poll() {
        if (reversed.isEmpty()) {
            while (!simpleStack.isEmpty()) {
                reversed.push(simpleStack.poll());
            }
        }
        return reversed.poll();
    }

    public void push(T value) {
        simpleStack.push(value);
    }
}
