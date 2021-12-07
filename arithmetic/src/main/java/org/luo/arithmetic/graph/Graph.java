package org.luo.arithmetic.graph;

public interface Graph<E> {
    boolean insertVex(E e);

    boolean deleteVex(E e);

    int getVertexNum();

    int getEdgeNum();

    boolean addEdge(E from, E to);

    boolean addEdge(E from, E to, int weight);

    boolean removeEdge(E from, E to);

    boolean removeVertex(E e);

    void display();


}
