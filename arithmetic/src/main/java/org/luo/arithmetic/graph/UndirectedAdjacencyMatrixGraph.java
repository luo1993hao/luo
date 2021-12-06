package org.luo.arithmetic.graph;

public class UndirectedAdjacencyMatrixGraph<E> extends AdjacencyMatrixGraph<E> {

    public UndirectedAdjacencyMatrixGraph(int maxVertexes) {
        super(maxVertexes);
    }

    @Override
    public boolean addEdge(E from, E to) {
        try {
            int fromIndex = this.getVertexIndex(from);
            int toIndex = this.getVertexIndex(to);
            this.edges[fromIndex][toIndex] = 1;
            this.edges[toIndex][fromIndex] = 1;
        } catch (RuntimeException exception) {
            return false;
        }
        return true;

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
        undirectedAdjacencyMatrixGraph.addEdge("A","B");
        undirectedAdjacencyMatrixGraph.addEdge("A","C");
        undirectedAdjacencyMatrixGraph.addEdge("B","D");
        undirectedAdjacencyMatrixGraph.addEdge("C","D");
        undirectedAdjacencyMatrixGraph.display();
    }

}
