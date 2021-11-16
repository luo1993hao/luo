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

    public void create(List<E> input) {
        this.root = createBinaryTreeWithPreOrder(input);
    }

    public void create1(List<E> input) {
        this.root = createBinaryTreeWithInOrder(input);
    }

    /**
     * 前序方式创建二叉树
     */
    private Node<E> createBinaryTreeWithPreOrder(List<E> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Node<E> node = null;
        E value = inputList.remove(0);
        if (value != null) {
            node = new Node<>(value);
            node.leftChild = createBinaryTreeWithPreOrder(inputList);
            node.rightChild = createBinaryTreeWithPreOrder(inputList);
        }
        return node;
    }

    /**
     * 中序方式创建二叉树
     */
    private Node<E> createBinaryTreeWithInOrder(List<E> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Node<E> node = null;
        E value = inputList.remove(0);
        if (value != null) {
            node = new Node<>();
            node.leftChild = createBinaryTreeWithInOrder(inputList);
            node.data = value;
            node.rightChild = createBinaryTreeWithInOrder(inputList);
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
        LinkedBinaryTree<String> linkedBinaryTree = new LinkedBinaryTree<>();

        ArrayList<String> preOrderList = Lists.newArrayList("A", "B", null, "D", null, null, "C", null, null);
        ArrayList<String> inOrderList = Lists.newArrayList(null, "B", null, "D", null, "A", null, "C", null);
//        linkedBinaryTree.create(preOrderList);
        linkedBinaryTree.create1(inOrderList);
//        linkedBinaryTree.preOrderTraversal(linkedBinaryTree.getRoot());
        linkedBinaryTree.inOrderTraversal(linkedBinaryTree.getRoot());
    }
}
