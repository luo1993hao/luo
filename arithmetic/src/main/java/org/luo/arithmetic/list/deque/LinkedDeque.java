package org.luo.arithmetic.list.deque;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * 也就是java中的LinkedList
 */
public class LinkedDeque<E> {
    private Node<E> head;
    private Node<E> tail;
    private int length;

    @AllArgsConstructor
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> pre;

    }

    private void addLast(E e) {
        Node<E> t = tail;
        Node<E> eNode = new Node<>(e, null, t);
        if (t == null) {
            head = eNode;
        } else {
            t.next = eNode;
        }
        tail = eNode;
        length++;
    }

    private void addFirst(E e) {
        Node<E> h = head;
        Node<E> eNode = new Node<>(e, h, null);
        if (h == null) {
            tail = eNode;
        } else {
            h.pre = eNode;
        }
        head = eNode;
        length++;
    }

    private void deleteLast() {
        Node<E> l = tail;
        Node<E> pre = l.pre;
        if (null == pre) {
            head = null;
        } else {
            pre.next = null;
        }
        tail = pre;
        length--;

    }

    private void deleteFirst() {
        Node<E> next = head.next;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.pre = null;
        }
        length--;

    }

    public static void main(String[] args) {
        LinkedDeque<String> test = new LinkedDeque<>();
        test.addLast("1");
        test.addLast("2");
        test.addLast("3");
        test.deleteFirst();
        LinkedList<String> test1 = new LinkedList<>();
        test1.addLast("1");
        test1.addLast("2");
        test1.addLast("3");
        test1.removeFirst();
    }
}
