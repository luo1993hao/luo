package org.luo.arithmetic.graph;

import java.util.Objects;

public abstract class AbstractAdjacencyMatrixGraph<E> implements Graph<E> {
    private E[] vertexes;
    protected int[][] edges = new int[4][4];
    private int vertexNumber;
    protected int edgeNumber;

    public AbstractAdjacencyMatrixGraph(int maxVertexes) {
        this.vertexes = (E[]) new Object[maxVertexes];
    }

    @Override
    public boolean insertVex(E e) {
        vertexes[vertexNumber++] = e;
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
        return edgeNumber;
    }

    @Override
    public boolean removeEdge(E from, E to) {
        Integer fromIndex = this.getVertexIndex(from);
        Integer toIndex = this.getVertexIndex(to);
        if (Objects.nonNull(from) && Objects.nonNull(toIndex)) {
            this.changeEdges(fromIndex, toIndex);
            edgeNumber--;
            return true;
        }
        return false;
    }

    public abstract void changeEdges(Integer fromIndex, Integer toIndex);

    @Override
    public boolean removeVertex(E e) {

        Integer vertexIndex = this.getVertexIndex(e);
        if (Objects.isNull(vertexIndex)) {
            return false;
        }
        //handle vertex
        E[] newVertex = (E[]) new Object[vertexes.length - 1];

        if (vertexes.length - 1 - vertexIndex >= 0)
            System.arraycopy(vertexes, vertexIndex + 1, newVertex, vertexIndex, vertexes.length - 1 - vertexIndex);
        if (vertexIndex >= 0) System.arraycopy(vertexes, 0, newVertex, 0, vertexIndex);
        //handle edge
        //row
        for (int i = vertexIndex; i < vertexes.length - 1; i++) {
            System.arraycopy(edges[i + 1], 0, edges[i], 0, vertexes.length);
        }
        //list
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes.length - 1 - vertexIndex >= 0)
                System.arraycopy(edges[i], vertexIndex + 1, edges[i], vertexIndex, vertexes.length - 1 - vertexIndex);
        }

        vertexNumber--;
        vertexes = newVertex;
        return true;
    }

    protected Integer getVertexIndex(E e) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == e) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void display() {
        System.out.print("  ");
        for (E vertex : vertexes) {
            System.out.print(" " + vertex);
        }
        System.out.println();
        for (int i = 0; i < vertexes.length; i++) {
            System.out.print(vertexes[i] + " ");
            for (int j = 0; j < vertexes.length; j++) {
                System.out.print(" "+edges[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void dfs() {

    }

    @Override
    public void bfs() {

    }
}
