package org.luo.arithmetic.tree;


import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedSortBinaryTree {
    private Node root;

    private static List<Node> inOrderTraversalNodes = new ArrayList<>();

    private static class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) {
            this.data = data;
        }
    }

    private boolean add(Integer data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return true;
        }
        if (this.isExist(data)) {
            newNode = null;
            return false;
        }
        Node current = root;
        while (true) {
            if (current.data > data) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    return true;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    return true;
                }
                current = current.rightChild;
            }


        }

    }

    private void init(int[] data) {
        for (int datum : data) {
            this.add(datum);
        }
    }

    private Pair<Node, Boolean> searchParentNode(Node node) {
        Node result = null;
        Node parent = root;
        boolean isLeft = false;
        while (parent != null &&
                (parent.leftChild != null || parent.rightChild != null)) {
            if (parent.leftChild != null && parent.leftChild.data == node.data) {
                result = parent;
                isLeft = true;
            }
            if (parent.rightChild != null && parent.rightChild.data == node.data) {
                result = parent;
            }
            if (parent.data > node.data) {
                parent = parent.leftChild;
                continue;
            }
            parent = parent.rightChild;
        }
        return Pair.of(result, isLeft);
    }

    private boolean delete(int data) {
        Node deletedNode = this.search(data);
        if (deletedNode == null) {
            return false;
        }
        Pair<Node, Boolean> parentNode = this.searchParentNode(deletedNode);
        //1.删除叶子节点
        if (deletedNode.leftChild == null && deletedNode.rightChild == null) {
            if (parentNode.snd) {
                parentNode.fst.leftChild = null;
            } else {
                parentNode.fst.rightChild = null;
            }
            return true;
        }
        //2.只有左子树或者只有右子树
        if (deletedNode.leftChild == null || deletedNode.rightChild == null) {
            deletedNode = deletedNode.leftChild == null ?
                    deletedNode.rightChild : deletedNode.leftChild;
            if (parentNode.snd) {
                parentNode.fst.leftChild = deletedNode;
            } else {
                parentNode.fst.rightChild = deletedNode;
            }
            return true;
        }

        //3.既有左子树又有右子树（中序排序后，找到直接前驱（后驱）。前驱（后驱）替换该节点。删除前驱（后驱））
        if (deletedNode.leftChild != null && deletedNode.rightChild != null) {
            Node pre = searchPreNodeByInOrderTraversal(deletedNode);
            if (pre != null) {
                Pair<Node, Boolean> parentNodePair = this.searchParentNode(pre);
                deletedNode.data = pre.data;
                Node preParentNode = parentNodePair.fst;
                if (preParentNode != null) {
                    if (parentNodePair.snd) {
                        preParentNode.leftChild = pre.leftChild == null ? pre.rightChild : pre.leftChild;
                    } else {
                        preParentNode.rightChild = pre.leftChild == null ? pre.rightChild : pre.leftChild;
                    }
                }
            }
            return true;

        }
        return false;
    }

    private Node searchPreNodeByInOrderTraversal(Node node) {
        initInOrderTraversalNodes(root);
        if (node == inOrderTraversalNodes.get(0)) {
            return null;
        }
        for (int i = 1; i < inOrderTraversalNodes.size(); i++) {
            if (Objects.equals(node.data, inOrderTraversalNodes.get(i).data)) {
                return inOrderTraversalNodes.get(i - 1);
            }
        }
        return null;
    }

    private void initInOrderTraversalNodes(Node root) {
        if (root == null) {
            return;
        }
        initInOrderTraversalNodes(root.leftChild);
        inOrderTraversalNodes.add(root);
        initInOrderTraversalNodes(root.rightChild);
    }


    private Node search(Integer data) {
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                return current;
            }
            if (current.data > data) {
                current = current.leftChild;
                continue;
            }
            current = current.rightChild;
        }
        return null;
    }

    private boolean isExist(Integer data) {
        return this.search(data) != null;
    }

    public static void main(String[] args) {
        int[] data = new int[]{62, 88, 58, 47, 35, 29, 37, 36, 51, 49, 56, 48, 50, 73, 99, 88, 93};
        LinkedSortBinaryTree linkedSortBinaryTree = new LinkedSortBinaryTree();
        linkedSortBinaryTree.init(data);
        linkedSortBinaryTree.delete(47);
//        linkedSortBinaryTree.delete(99);
//        linkedSortBinaryTree.delete(58);
        System.out.println(linkedSortBinaryTree.isExist(99));
    }
}
