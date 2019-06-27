package ru.job4j.collections.list;

public class Cycle<T> {

    Node first = new Node(1);
    Node two = new Node(2);
    Node third = new Node(3);
    Node four = new Node(4);

    public Cycle() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
    }
    boolean hasCycle(Node first) {
        Node slow = first;
        Node fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static class Node<T> {

        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

}
