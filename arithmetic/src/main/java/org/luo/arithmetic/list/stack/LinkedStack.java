package org.luo.arithmetic.list.stack;

import lombok.AllArgsConstructor;

public class LinkedStack<E> {
    private int length;
    private Node<E> top;

    @AllArgsConstructor
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public void push(E e) {
        Node<E> t = top;
        Node<E> eNode = new Node<>(e);
        if (t == null) {
            eNode.next = null;
        } else {
            eNode.next = top;
        }
        top = eNode;
        length++;
    }

    public void pop() {
        top = top.next;
        length--;
    }

    public static void main(String[] args) {
        LinkedStack<String> test = new LinkedStack<>();
        test.push("1");
        test.push("2");
        test.push("3");
        test.pop();
        test.pop();
        test.pop();
    }
}
