package org.luo.arithmetic.list;

import lombok.AllArgsConstructor;

import java.util.LinkedList;

public class DoubleLinkList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int length;

    @AllArgsConstructor
    private static class Node<E> {
        private E data;
        private Node<E> pre;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public void addFirst(E e) {
        Node<E> f = head;
        Node<E> eNode = new Node<>(e, null, f);
        if (f == null) {
            tail = eNode;
        } else {
            f.pre = eNode;
        }
        head = eNode;
        length++;

    }

    public void addLast(E e) {
        Node<E> l = tail;
        Node<E> eNode = new Node<>(e, tail, null);
        tail = eNode;
        if (l == null) {
            head = eNode;
        } else {
            l.next = eNode;
        }
        length++;

    }

    public void removeLast() {
        Node<E> pre = tail.pre;
        if (pre == null) {
            head = null;
        } else {
            pre.next = null;
        }
        tail = pre;
        length--;
    }

    public void removeFirst() {
        Node<E> f = head.next;
        head = f;
        if (f == null) {
            tail = null;
        } else {
            f.pre = null;
        }
        length--;
    }


    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>();
        a.addFirst("1");
        a.addFirst("2");
        a.removeLast();
        DoubleLinkList<String> doubleLinkList = new DoubleLinkList<>();
        doubleLinkList.addFirst("1");
        doubleLinkList.addFirst("2");
        doubleLinkList.removeFirst();

    }
}
