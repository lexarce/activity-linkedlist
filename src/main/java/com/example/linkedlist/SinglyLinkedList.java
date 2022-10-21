package com.example.linkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList <E> implements LinkedList<E>{

    private Node head;
    private Node tail;

    @Override
    public void addFirst(E element) {

        Node node = new Node(element, head); // steps 1 & 2

        // Creating aliases for the same thing
        // Adding to the front
        if (head == null) {
            head = node; // Step 3
            tail = head;
        } else {
            head = node; // Step 3
        }

    }

    @Override
    public void addLast(E element) {

        Node node = new Node(element, null); // Step 1

        //Adding to tail
        if (tail == null) {
            tail = node; // Step 3
            head = tail; // Step 3
        } else {
            tail.next = node; // Step 2
            tail = node; // Step 3
        }

    }

    @Override
    public E pollFirst() {

        E element;

        if (head == null) {
            element = null; // Step 1
        } else {
            element = head.element; // Step 1

            Node next = head.next; // Step 2
            head.next = null; // Step 3
            head = next; // Step 4
        }

        return element;
    }

    @Override
    public E pollLast() {

        E element;
        if (tail == null) { // No elements
            element = null;
        } else {
            element = tail.element; // Step 1

            if (head == tail) { // Only one element
                head = null;
                tail = null;
            } else {

                Node current = head;
                Node previous = head;

                while (current.next != null) { // Step 2
                    previous = current;
                    current = current.next;
                }
                tail = previous; // Step 3
                tail.next = null; // Step 4
            }
        }

        return element;
    }

    @Override
    public E peekFirst() {
        return head.element;
    }

    @Override
    public E peekLast() {
        return tail.element;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    // Algorithm for outputting small list to toString method
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        StringJoiner joiner = new StringJoiner(", ");
        Node current = head;

        while (current != null) {
            joiner.add(current.element.toString());
            current = current.next;
        }

        builder.append(joiner);
        builder.append("]");

        return builder.toString();
    }

    private class Node{

        Node next;
        E element;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

    }
}
