package org.luo.arithmetic.graph;

import java.util.Objects;

public class DirectedAdjacencyWeightMatrixGraph<E> extends AdjacencyMatrixGraph<E> {

    public DirectedAdjacencyWeightMatrixGraph(int maxVertexes) {
        super(maxVertexes);
        //网图理论上应该实用正无穷表示无法到达的点
//        for (int i = 0; i < edges.length; i++) {
//            for (int j = 0; j < edges.length; j++) {
//                if (i != j) {
//                    edges[i][j] = Integer.MAX_VALUE;
//                }
//            }
//        }
    }

    @Override
    public boolean addEdge(E from, E to) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeEdge(E from, E to) {
        Integer fromIndex = this.getVertexIndex(from);
        Integer toIndex = this.getVertexIndex(to);
        if (Objects.nonNull(from) && Objects.nonNull(toIndex)) {
            //理论上应该置为正无穷
            this.edges[fromIndex][toIndex] =0;
            edgeNumber--;
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(E from, E to, int weight) {

        Integer fromIndex = this.getVertexIndex(from);
        Integer toIndex = this.getVertexIndex(to);
        if (Objects.nonNull(from) && Objects.nonNull(toIndex)) {
            this.edges[fromIndex][toIndex] = weight;
            edgeNumber++;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Graph<String> directedAdjacencyMatrixGraph = new DirectedAdjacencyWeightMatrixGraph<>(4);
        directedAdjacencyMatrixGraph.insertVex("A");
        directedAdjacencyMatrixGraph.insertVex("B");
        directedAdjacencyMatrixGraph.insertVex("C");
        directedAdjacencyMatrixGraph.insertVex("D");
        directedAdjacencyMatrixGraph.addEdge("A", "B", 1);
        directedAdjacencyMatrixGraph.addEdge("A", "C", 2);
        directedAdjacencyMatrixGraph.addEdge("B", "D", 3);
        directedAdjacencyMatrixGraph.addEdge("C", "D", 4);

//        System.out.println(directedAdjacencyMatrixGraph.getVertexNum());
//        System.out.println(directedAdjacencyMatrixGraph.getEdgeNum());

//        directedAdjacencyMatrixGraph.removeVertex("D");
        directedAdjacencyMatrixGraph.display();
    }

}
