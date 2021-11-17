package org.luo.arithmetic.tree;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LinkedThreadBinaryTree<E> {
    private Node<E> pre;
    private Node<E> root;

    private static class Node<E> {
        private E data;
        private PointerTag leftTag = PointerTag.CHILD;
        private Node<E> leftChild;
        private PointerTag rightTag = PointerTag.CHILD;
        private Node<E> rightChild;


    }

    private enum PointerTag {
        CHILD, THREAD;
    }

    public void create(List<E> data) {
        this.root = create(data, 0);
    }

    public void inThreadOrder(Node<E> root) {
        if (root == null) {
            return;
        }
        inThreadOrder(root.leftChild);
        if (root.leftChild == null) {
            root.leftChild = pre;
            root.leftTag = PointerTag.THREAD;
        }
        if (pre != null && pre.rightChild == null) {
            pre.rightChild = root;
            pre.rightTag = PointerTag.THREAD;
        }
        pre = root;
        inThreadOrder(root.rightChild);
    }


    private Node<E> create(List<E> data, int index) {
        Node<E> node = null;
        if (index < data.size() && data.get(index) != null) {
            node = new Node<>();
            node.data = data.get(index);
            node.leftChild = create(data, 2 * index + 1);
            node.rightChild = create(data, 2 * index + 2);
        }
        return node;
    }


    public static void main(String[] args) {
        //ABCD#EF#G
        List<String> strings = Lists.newArrayList("A", "B", "C", null, "D", "E", "F");
        LinkedThreadBinaryTree<String> objectLinkedThreadBinaryTree = new LinkedThreadBinaryTree<>();
        objectLinkedThreadBinaryTree.create(strings);

        objectLinkedThreadBinaryTree.inThreadOrder(objectLinkedThreadBinaryTree.getRoot());

    }

}
