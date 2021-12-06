package org.luo.arithmetic.graph;

public abstract class AdjacencyMatrixGraph<E> implements Graph<E> {
    private E[] vertexes;
    protected int[][] edges = new int[20][20];
    private int vertexNumber;
    private int edgeNumber;

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
        return vertexes.length;
    }


    @Override
    public boolean removeEdge(E from, E to) {
        return false;
    }

    @Override
    public boolean removeVertex(E e) {
        return false;
    }

    protected int getVertexIndex(E e) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == e) {
                return i;
            }
        }
        throw new RuntimeException("vertex not exist");
    }

    @Override
    public void display() {
        for (E vertex : vertexes) {
            System.out.print(" "+vertex);
        }
        System.out.println();
        for (int i = 0; i < vertexes.length; i++) {
            System.out.print(vertexes[i]+" ");
            for (int j = 0; j < vertexes.length; j++) {
                System.out.print(edges[i][j]);
            }
            System.out.println();
        }
    }
}
