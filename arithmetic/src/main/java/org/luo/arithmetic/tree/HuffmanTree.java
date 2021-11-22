package org.luo.arithmetic.tree;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class HuffmanTree {
    private Node root;

    @Data
    private static class Node implements Comparable<Node> {
        private int weight;
        private String name;
        private Node leftChild;
        private Node rightChild;
        private boolean isRead;

        public Node(int weight, String name) {
            this.weight = weight;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public void create(List<Node> nodes) {
        this.root = this.init(nodes);
    }

    private Node init(List<Node> nodes) {
        if (null == nodes || nodes.isEmpty()) {
            return null;
        }
        Node result = null;

        while (nodes.stream().filter(x -> !x.isRead).count() > 1) {
            List<Node> notReadNodes = nodes.stream().filter(x -> !x.isRead).sorted().collect(Collectors.toList());
            Node minNode = notReadNodes.remove(0);
            Node secondMinNode = notReadNodes.remove(0);
            minNode.setRead(true);
            secondMinNode.setRead(true);
            int newNodeWeight = minNode.getWeight() + secondMinNode.getWeight();
            Node newNode = new Node(newNodeWeight, String.valueOf(newNodeWeight));
            newNode.leftChild = minNode;
            newNode.rightChild = secondMinNode;
            nodes.add(newNode);
            nodes = nodes.stream().sorted().collect(Collectors.toList());
            result = newNode;
        }


        return result;
    }

    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.create(Lists.newArrayList(
                new Node(60, "A"),
                new Node(45, "B"),
                new Node(13, "C"),
                new Node(69, "D"),
                new Node(14, "E"),
                new Node(8, "F")
        ));
        System.out.println(huffmanTree.getRoot().getWeight());

    }

}
