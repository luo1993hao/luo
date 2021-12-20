package org.luo.arithmetic.graph;

import java.util.Objects;

public class OrthogonalListGraph<E> implements Graph<E> {
    private Vertex<E>[] vertices;
    private int vertexNumber;


    private static class Vertex<E> {
        private E data;
        Edge firstIn;
        Edge firstOut;

        public void handleOut(Integer fromIndex, Integer toIndex) {
            if (this.firstOut == null) {
                this.firstOut = new Edge(fromIndex, toIndex);
            }else {
//                this.f
            }
        }

        public void handleIn(Integer fromIndex, Integer toIndex) {

        }

        public Vertex(E data) {
            this.data = data;
        }
    }

    private static class Edge {
        private Integer tailVexIndex;
        private Integer headVexIndex;
        private Edge headLink;
        private Edge tailLink;

        public Edge(Integer tailVexIndex, Integer headVexIndex) {
            this.tailVexIndex = tailVexIndex;
            this.headVexIndex = headVexIndex;
        }
    }

    @Override
    public boolean insertVex(E e) {
        vertices[vertexNumber++] = new Vertex<>(e);
        return true;
    }

    @Override
    public boolean deleteVex(E e) {
        return false;
    }

    @Override
    public int getVertexNum() {
        return vertexNumber;
    }

    @Override
    public int getEdgeNum() {
        return 0;
    }

    @Override
    public boolean addEdge(E from, E to) {
        Integer fromIndex = this.getVertexIndex(from);
        Integer toIndex = this.getVertexIndex(to);
        if (Objects.nonNull(fromIndex) && Objects.nonNull(toIndex)) {

        }
        return false;
    }

    @Override
    public boolean addEdge(E from, E to, int weight) {
        return false;
    }

    @Override
    public boolean removeEdge(E from, E to) {
        return false;
    }

    @Override
    public boolean removeVertex(E e) {
        return false;
    }

    @Override
    public void display() {

    }

    @Override
    public void dfs() {

    }

    @Override
    public void bfs() {

    }

    private Integer getVertexIndex(E e) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].data == e) {
                return i;
            }
        }
        return null;
    }

}
