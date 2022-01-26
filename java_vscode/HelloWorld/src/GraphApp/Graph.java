package java_vscode.HelloWorld.src.GraphApp;

import java.util.*;

public class Graph {
    public HashMap<String, Vertex> vertexes;
    public HashSet<Edge> edges;

    public Graph() {
        this.vertexes = new HashMap<>();
        this.edges = new HashSet<>();
    }

    public Graph(GraphMatrix graphMatrix) {
        this();
        graphFromMatrix(graphMatrix);
    }

    public void graphFromMatrix(GraphMatrix graphMatrix) {
        int[][] matrix = graphMatrix.getEdges();
        String[] nodes = graphMatrix.getVertexes();
        for (int i = 0, len = nodes.length; i < len; i++) {
            Vertex vertex = new Vertex(nodes[i]);
            this.vertexes.put(nodes[i], vertex);
        }
        for (int i = 0, len = matrix.length; i < len; i++) {
            for (int j = 0, innerLen = matrix[i].length; j < innerLen; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    // if there is a connection
                    Vertex from = this.vertexes.get(nodes[i]);
                    Vertex to = this.vertexes.get(nodes[j]);
                    from.out++;
                    to.in++;
                    Edge edge = new Edge(matrix[i][j], from, to);
                    this.edges.add(edge);
                    from.edges.put(to.value, edge);
                    from.nextVertexes.add(to);
                }
            }
        }
    }

    public GraphMatrix graphToMatrix() {
        int size = this.vertexes.size();
        int[][] matrix = new int[size][size];
        // initial the adjacent matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        String[] keySet = this.vertexes.keySet().toArray(new String[0]);
        for (String key : keySet) {
            // traverse all the vertex
            Vertex from = this.vertexes.get(key);
            int fromInd = Arrays.binarySearch(keySet, key);
            for (Vertex to : from.nextVertexes) {
                int toInd = Arrays.binarySearch(keySet, to.value);
                // find the corresponding weight
                Edge edge = from.edges.get(to.value);
                // fill in the weight
                matrix[fromInd][toInd] = edge.weight;
            }
        }
        return new GraphMatrix(matrix, keySet);
    }
}

class Vertex {
    public String value;
    public int in;
    public int out;
    public HashMap<String, Edge> edges;
    public ArrayList<Vertex> nextVertexes;

    public Vertex(String value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.edges = new HashMap<>();
        this.nextVertexes = new ArrayList<>();
    }
}

class Edge {
    public int weight;
    public Vertex from;
    public Vertex to;

    public Edge(int weight, Vertex from, Vertex to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
