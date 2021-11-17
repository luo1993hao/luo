package org.luo.arithmetic.tree;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class LinkedBinaryTree<E> {
    private Node<E> root;


    private static class Node<E> {
        private E data;
        private Node<E> rightChild;
        private Node<E> leftChild;

        public Node(E data) {
            this.data = data;
        }

        public Node() {
        }
    }
    /**
     * 建立二叉树 两种方式：
     * 1.给出自然顺序（没有值的按照null,其实就是完全二叉树或者满二叉树的输入）。
     *  2.给出先序+中序 or  中序+后序
     */
    /**
     * 自然顺序创建
     * ABC#DEF
     *
     * @param data
     * @param index
     * @return
     */
    public Node<E> create(List<E> data, int index) {
        Node<E> node = null;
        if (index < data.size() && data.get(index) != null) {
            node = new Node<>();
            node.data = data.get(index);
            node.leftChild = create(data, 2 * index + 1);
            node.rightChild = create(data, 2 * index + 2);
        }
        return node;
    }


    /**
     * 前序:根->左->右
     */
    public void preOrderTraversal(Node<E> node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序:左->根->右
     */
    public void inOrderTraversal(Node<E> node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后序：左->右->根
     */
    public void postOrderTraversal(Node<E> node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }


    public static void main(String[] args) {
        //自然顺序
        LinkedBinaryTree<String> linkedBinaryTree = new LinkedBinaryTree<>();
        List<String> strings = Lists.newArrayList("A", "B", "C", null, "D", "E", "F");
        linkedBinaryTree.create(strings, 0);
        // 先序创建

    }
}
