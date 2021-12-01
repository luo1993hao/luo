package org.luo.arithmetic.tree;

public class LinkedAvlTree {
    private Node root;

    private Node rotateRight(Node node) {
        Node newParent = node.leftNode;
        Node newLeft = newParent.rightNode;
        newParent.rightNode = node;
        node.leftNode = newLeft;
        //update height
        this.updateHeight(node);
        this.updateHeight(newParent);
        if (node == root) {
            root = newParent;
        }
        return newParent;
    }

    private void updateHeight(Node node) {
        if (node.isLeft()) {
            node.height = 0;
        } else {
            node.height = 1 + Math.max(getHeight(node.leftNode), getHeight(node.rightNode));
        }
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private Node rotateLeft(Node node) {
        Node newParent = node.rightNode;
        Node newRight = newParent.leftNode;
        newParent.leftNode = node;
        node.rightNode = newRight;
        //update height
        this.updateHeight(node);
        this.updateHeight(newParent);
        if (node == root) {
            root = newParent;
        }
        return newParent;
    }

    private boolean isBalanced() {
        if (root == null) {
            return true;
        }
        return Math.abs(this.getBalanceFactor(root)) <= 1;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = node.leftNode == null ? -1 : node.leftNode.height;
        int rightHeight = node.rightNode == null ? -1 : node.rightNode.height;
        return leftHeight - rightHeight;

    }


    public void add(Integer data) {
        this.root = this.add(root, data);
    }

    private Node add(Node node, Integer data) {
        if (node == null) {
            return new Node(data);
        }
        if (node.data < data) {
            node.rightNode = add(node.rightNode, data);
        }
        if (node.data > data) {
            node.leftNode = add(node.leftNode, data);
        }
        this.updateHeight(node);
        int balanceFactor = this.getBalanceFactor(node);
        //右旋
        if (balanceFactor > 1 && this.getBalanceFactor(node.leftNode) > 0) {
            return this.rotateRight(node);
        }
        //左旋
        if (balanceFactor < -1 && this.getBalanceFactor(node.rightNode) < 0) {
            return this.rotateLeft(node);
        }
        //lr
        if (balanceFactor > 1 && this.getBalanceFactor(node.leftNode) < 0) {
            node.leftNode = rotateLeft(node.leftNode);
            return rotateRight(node);
        }
        //rl
        if (balanceFactor < -1 && this.getBalanceFactor(node.rightNode) > 0) {
            node.rightNode = rotateRight(node.rightNode);
            return rotateLeft(node);
        }
        return node;
    }

    private static class Node {
        private int data;
        private int height;
        private Node leftNode;
        private Node rightNode;

        private boolean isLeft() {
            return this.leftNode == null && this.rightNode == null;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        //{3.2，1,4,5，6，7，10,9,8}
        LinkedAvlTree linkedAvlTree = new LinkedAvlTree();
        linkedAvlTree.add(3);
        linkedAvlTree.add(2);
        //3 右旋
        linkedAvlTree.add(1);
        linkedAvlTree.add(4);
        //3 左旋
        linkedAvlTree.add(5);
        //2 左旋
        linkedAvlTree.add(6);
        // 5 左旋
        linkedAvlTree.add(7);
        linkedAvlTree.add(10);
        //rl(10右旋 7左旋)
        linkedAvlTree.add(9);
       //rl (9右旋，6左旋)
        linkedAvlTree.add(8);
    }
}
