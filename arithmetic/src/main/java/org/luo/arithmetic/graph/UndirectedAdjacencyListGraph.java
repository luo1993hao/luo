package org.luo.arithmetic.graph;

import java.util.Objects;

public class UndirectedAdjacencyListGraph<E> implements Graph<E> {
    private Vertex<E>[] vertexes;
    private int vertexNumber;
    private int edgeNumber;

    private static class Edge {
        private final int vertexIndex;
        private Edge nextEdge;

        public Edge(int vertexIndex) {
            this.vertexIndex = vertexIndex;
        }
    }

    public UndirectedAdjacencyListGraph(int vertexes) {
        this.vertexes = new Vertex[vertexes];
    }

    private static class Vertex<E> {
        private final E data;
        private Edge firstEdge;

        public Vertex(E data) {
            this.data = data;
        }

        public Integer getEdgeCount() {
            if (firstEdge == null) {
                return 0;
            }
            int result = 1;
            Edge firstEdge = this.firstEdge;
            while (firstEdge.nextEdge != null) {
                result++;
                firstEdge.nextEdge = firstEdge.nextEdge.nextEdge;
            }
            return result;
        }

        public void addEdge(Integer toIndex) {
            Edge edge = new Edge(toIndex);
            if (this.firstEdge == null) {
                this.firstEdge = edge;
            } else {
                Edge next = this.firstEdge;
                while (next.nextEdge != null) {
                    next = next.nextEdge;
                }
                next.nextEdge = edge;
            }
        }

        public void removeEdge(Integer toIndex) {
            if (firstEdge == null) {
                return;
            }
            if (firstEdge.vertexIndex == toIndex) {
                this.firstEdge = this.firstEdge.nextEdge;
                return;
            }
            Edge removeEdge = this.firstEdge;
            while (removeEdge.nextEdge != null) {
                if (removeEdge.nextEdge.vertexIndex == toIndex) {
                    removeEdge.nextEdge = removeEdge.nextEdge.nextEdge;
                } else {
                    removeEdge = removeEdge.nextEdge;
                }
            }
        }
    }

    @Override
    public boolean insertVex(E e) {
        Vertex<E> newVertex = new Vertex<>(e);
        vertexes[vertexNumber++] = newVertex;
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
    public boolean addEdge(E from, E to) {
        Integer fromIndex = this.getVertexIndex(from);
        Integer toIndex = this.getVertexIndex(to);
        if (Objects.nonNull(fromIndex) && Objects.nonNull(toIndex)) {
            Vertex<E> fromVertex = vertexes[fromIndex];
            fromVertex.addEdge(toIndex);
            Vertex<E> toVertex = vertexes[toIndex];
            toVertex.addEdge(fromIndex);
            edgeNumber++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(E from, E to, int weight) {
        return false;
    }

    @Override
    public boolean removeEdge(E from, E to) {
        Integer fromIndex = this.getVertexIndex(from);
        Integer toIndex = this.getVertexIndex(to);
        if (Objects.nonNull(fromIndex) && Objects.nonNull(toIndex)) {
            Vertex<E> fromVertex = vertexes[fromIndex];
            fromVertex.removeEdge(toIndex);
            Vertex<E> toVertex = vertexes[toIndex];
            toVertex.removeEdge(fromIndex);
            edgeNumber--;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVertex(E e) {
        //handle vertex
        Integer removeIndex = this.getVertexIndex(e);
        if (Objects.isNull(removeIndex)) {
            return false;
        }
        this.edgeNumber = this.edgeNumber - vertexes[removeIndex].getEdgeCount();
        int newVertexNumber = vertexNumber - 1;
        Vertex<E>[] newVertex = new Vertex[newVertexNumber];
        for (int i = 0; i < removeIndex; i++) {
            newVertex[i] = vertexes[i];
        }
        for (int i = removeIndex; i < vertexes.length - 1; i++) {
            newVertex[i] = vertexes[i + 1];
        }
        this.vertexes = newVertex;
        this.vertexNumber = newVertexNumber;

        //handle edge
        for (Vertex<E> vertex : newVertex) {
            Edge firstEdge = vertex.firstEdge;
            if (firstEdge != null) {
                if (firstEdge.vertexIndex == removeIndex) {
                    vertex.firstEdge = firstEdge.nextEdge;
                    continue;
                }

                while (firstEdge.nextEdge != null) {
                    if (firstEdge.nextEdge.vertexIndex == removeIndex) {
                        firstEdge.nextEdge = firstEdge.nextEdge.nextEdge;
                    } else {
                        firstEdge = firstEdge.nextEdge;
                    }
                }
            }

        }
        return true;
    }

    @Override
    public void display() {

    }

    private Integer getVertexIndex(E e) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i].data == e) {
                return i;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph<String> undirectedAdjacencyListGraph = new UndirectedAdjacencyListGraph<>(4);
        undirectedAdjacencyListGraph.insertVex("A");
        undirectedAdjacencyListGraph.insertVex("B");
        undirectedAdjacencyListGraph.insertVex("C");
        undirectedAdjacencyListGraph.insertVex("D");
        undirectedAdjacencyListGraph.addEdge("A", "B");
        undirectedAdjacencyListGraph.addEdge("A", "C");
        undirectedAdjacencyListGraph.addEdge("A", "D");
        undirectedAdjacencyListGraph.addEdge("B", "D");
        undirectedAdjacencyListGraph.addEdge("C", "D");
//        undirectedAdjacencyListGraph.removeEdge("A", "C");
        undirectedAdjacencyListGraph.removeVertex("A");
    }
}
