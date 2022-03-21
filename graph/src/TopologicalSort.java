import java.util.*;

public class TopologicalSort {
    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }
    private class Vertex {
        private String label;
        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
    private List<Vertex> vertexList = new ArrayList<>();
    private  int[][] adjacencyMatrix;
    private GraphType graphType;
    private int numVertices; //current number of vertices
    public TopologicalSort(GraphType graphType, int numVertices) {
        this.graphType = graphType;
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    //Adding vertex
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    //Adding Edge
    public void addEdge(String from, String to) {
        int fromIndex = getVertexIndex(from);
        int toIndex = getVertexIndex(to);
        if (fromIndex >= numVertices || fromIndex < 0 || toIndex >= numVertices || toIndex < 0)
            throw new IllegalArgumentException("Vertex number is not  valid ");

        adjacencyMatrix[fromIndex][toIndex] = 1;
        if (graphType == GraphType.UNDIRECTED)
            adjacencyMatrix[toIndex][fromIndex] = 1;
    }

    private int getVertexIndex(String label) {
        for (int i = 0; i < numVertices; i++) {
            if (vertexList.get(i).label.equals(label))
                return i;
        }
        return -1;
    }


    //Topological sort
    public List<String> topologicalSort() {
        Deque<Vertex> queue = new ArrayDeque<>();
        Map<Vertex, Integer> indegreeMap = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            var vertex = vertexList.get(i);
            int indegree = getIndegree(vertex);
            indegreeMap.put(vertex, indegree);
            if (indegree == 0)
                queue.add(vertex);
        }
        List<String> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            var vertex = queue.pollLast();
            sortedList.add(vertex.label);
            ArrayList<Vertex> neighbours = getNeighbors(vertex);
            for (var neighbour : neighbours) {
                int updatedIndegree = indegreeMap.get(neighbour) - 1;
                indegreeMap.put(neighbour, updatedIndegree);
                if (updatedIndegree == 0)
                    queue.add(neighbour);
            }
        }
        if (sortedList.size() != numVertices)
            throw new RuntimeException("The graph has a cycle : ");
        return sortedList;
    }
    //Indegree gives how many arrow points to this vertex
    private int getIndegree(Vertex vertex) {
        int vertexIndex = getVertexIndex(vertex.label);
        if (vertexIndex < 0 || vertexIndex >= numVertices)
            throw new IllegalArgumentException("Vertex is not valid ");
        int indegree = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[i][vertexIndex] != 0)
                indegree++;
        }
        return indegree;
    }
    private ArrayList<Vertex> getNeighbors(Vertex node) {
        ArrayList<Vertex> neighbors = new ArrayList<>();
        int nodeIndex = getIndex(node);
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1)
                neighbors.add(vertexList.get(i));
        }
        return neighbors;
    }

    private int getIndex(Vertex node) {
        for (int i = 0; i <= numVertices; i++) {
            if (vertexList.get(i).label.equals(node.label))
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        TopologicalSort  graph=new TopologicalSort(GraphType.DIRECTED, 5);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("C","E");
        graph.addEdge("E","B");
        graph.addEdge("B","D");
        graph.addEdge("E","D");

        System.out.println("Topological sort  :" );
        List<String> result=graph.topologicalSort();
        System.out.println(result);
    }

}
