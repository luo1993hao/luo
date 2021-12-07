package org.luo.arithmetic.graph;

import java.util.Objects;

public class UndirectedAdjacencyMatrixGraph<E> extends AdjacencyMatrixGraph<E> {

    public UndirectedAdjacencyMatrixGraph(int maxVertexes) {
        super(maxVertexes);
    }

    @Override
    public boolean addEdge(E from, E to) {
        Integer fromIndex = this.getVertexIndex(from);
        Integer toIndex = this.getVertexIndex(to);
        if (Objects.nonNull(from) && Objects.nonNull(toIndex)) {
            this.edges[fromIndex][toIndex] = 1;
            this.edges[toIndex][fromIndex] = 1;
            edgeNumber++;
            return true;
        }
        return false;


    }


    @Override
    public void changeEdges(Integer fromIndex, Integer toIndex) {
        this.edges[fromIndex][toIndex] = 0;
        this.edges[toIndex][fromIndex] = 0;
    }

    @Override
    public boolean addEdge(E from, E to, int weight) {
        throw new UnsupportedOperationException();
    }


    public static void main(String[] args) {
        Graph<String> undirectedAdjacencyMatrixGraph = new UndirectedAdjacencyMatrixGraph<>(4);
        undirectedAdjacencyMatrixGraph.insertVex("A");
        undirectedAdjacencyMatrixGraph.insertVex("B");
        undirectedAdjacencyMatrixGraph.insertVex("C");
        undirectedAdjacencyMatrixGraph.insertVex("D");
        undirectedAdjacencyMatrixGraph.addEdge("A", "B");
        undirectedAdjacencyMatrixGraph.addEdge("A", "C");
        undirectedAdjacencyMatrixGraph.addEdge("B", "D");
        undirectedAdjacencyMatrixGraph.addEdge("C", "D");

//        System.out.println(undirectedAdjacencyMatrixGraph.getVertexNum());
//        System.out.println(undirectedAdjacencyMatrixGraph.getEdgeNum());

        undirectedAdjacencyMatrixGraph.removeVertex("D");
        undirectedAdjacencyMatrixGraph.display();
    }

}
