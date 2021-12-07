package org.luo.arithmetic.graph;

import java.util.Objects;

public class DirectedAdjacencyMatrixGraph<E> extends AdjacencyMatrixGraph<E> {

    public DirectedAdjacencyMatrixGraph(int maxVertexes) {
        super(maxVertexes);
    }

    @Override
    public boolean addEdge(E from, E to) {
        Integer fromIndex = this.getVertexIndex(from);
        Integer toIndex = this.getVertexIndex(to);
        if (Objects.nonNull(from) && Objects.nonNull(toIndex)) {
            this.edges[fromIndex][toIndex] = 1;
            edgeNumber++;
            return true;
        }
        return false;


    }

    @Override
    public boolean removeEdge(E from, E to) {
        Integer fromIndex = this.getVertexIndex(from);
        Integer toIndex = this.getVertexIndex(to);
        if (Objects.nonNull(from) && Objects.nonNull(toIndex)) {
            this.edges[fromIndex][toIndex] = 0;
            edgeNumber--;
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(E from, E to, int weight) {
        throw new UnsupportedOperationException();
    }


    public static void main(String[] args) {
        Graph<String> directedAdjacencyMatrixGraph = new DirectedAdjacencyMatrixGraph<>(4);
        directedAdjacencyMatrixGraph.insertVex("A");
        directedAdjacencyMatrixGraph.insertVex("B");
        directedAdjacencyMatrixGraph.insertVex("C");
        directedAdjacencyMatrixGraph.insertVex("D");
        directedAdjacencyMatrixGraph.addEdge("A", "B");
        directedAdjacencyMatrixGraph.addEdge("A", "C");
        directedAdjacencyMatrixGraph.addEdge("B", "D");
        directedAdjacencyMatrixGraph.addEdge("C", "D");

//        System.out.println(directedAdjacencyMatrixGraph.getVertexNum());
//        System.out.println(directedAdjacencyMatrixGraph.getEdgeNum());

        directedAdjacencyMatrixGraph.removeVertex("D");
        directedAdjacencyMatrixGraph.display();
    }

}
