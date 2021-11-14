package org.luo.arithmetic.list.circle;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.Objects;

public class CircleList<E> {
    private Node<E> first;
    private int length;

    public void add(E e) {
        if (null == first) {
            first = new Node<>(e);
            first.next = first;
        } else {
            Node<E> temp = first;
            while (temp.next != first) {
                temp = temp.next;
            }
            temp.next = new Node<>(e, first);
        }
        length++;
    }

    public boolean remove(E e) {
        Node<E> x = first;
        int count = 0;
        while (count <= length) {
            if (Objects.equals(e, x.next.data)) {
                x.next = x.next.next;
                length--;
                return true;
            }
            x = x.next;
            count++;
        }
        return false;
    }


    @AllArgsConstructor
    private static class Node<E> {
        private E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        CircleList<String> circleList = new CircleList<>();
        circleList.add("A");
        circleList.add("B");
        circleList.add("C");
        circleList.remove("A");
//        circleList.remove("B");
//        circleList.remove("C");
        System.out.println(circleList);
    }
}
