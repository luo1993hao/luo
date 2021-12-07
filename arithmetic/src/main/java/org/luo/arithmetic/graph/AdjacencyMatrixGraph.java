package org.luo.arithmetic.graph;

import java.util.Objects;

public abstract class AdjacencyMatrixGraph<E> implements Graph<E> {
    private E[] vertexes;
    protected int[][] edges = new int[4][4];
    private int vertexNumber;
    protected int edgeNumber;

    public AdjacencyMatrixGraph(int maxVertexes) {
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
    public boolean removeVertex(E e) {

        Integer vertexIndex = this.getVertexIndex(e);
        if (Objects.isNull(vertexIndex)) {
            return false;
        }
        //handle vertex
        E[] newVertex = (E[]) new Object[vertexes.length - 1];

        for (int i = vertexIndex; i < vertexes.length - 1; i++) {
            newVertex[i] = vertexes[i + 1];
        }
        for (int i = 0; i < vertexIndex; i++) {
            newVertex[i] = vertexes[i];
        }
        //handle edge
        //row
        for (int i = vertexIndex; i < vertexes.length - 1; i++) {
            for (int j = 0; j < vertexes.length; j++) {

                edges[i][j] = edges[i + 1][j];
            }
        }
        //list
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = vertexIndex; j < vertexes.length - 1; j++) {
                edges[i][j] = edges[i][j + 1];
            }
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
        for (E vertex : vertexes) {
            System.out.print(" " + vertex);
        }
        System.out.println();
        for (int i = 0; i < vertexes.length; i++) {
            System.out.print(vertexes[i] + " ");
            for (int j = 0; j < vertexes.length; j++) {
                System.out.print(edges[i][j]);
            }
            System.out.println();
        }
    }
}
