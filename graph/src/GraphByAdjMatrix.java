import java.util.*;
public class GraphByAdjMatrix {
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
    private final List<Vertex> vertexList = new ArrayList<>();
    private final int[][] adjMat;
    private GraphType graphType;
    private final int numVertices; //current number of vertices
    public GraphByAdjMatrix(GraphType graphType, int numVertices) {
        this.graphType = graphType;
        this.numVertices = numVertices;
        adjMat = new int[numVertices][numVertices];
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

        adjMat[fromIndex][toIndex] = 1;
        if (graphType == GraphType.UNDIRECTED)
            adjMat[toIndex][fromIndex] = 1;
    }

    private int getVertexIndex(String label) {
        for (int i = 0; i < numVertices; i++) {
            if (vertexList.get(i).label.equals(label))
                return i;
        }
        return -1;
    }

    //DFS   TC: O(V+E) || SC: O(V+E)
    public void dfsIterative(String root) {
        var node = getNode(root);
        if (node == null) {
            System.out.println("This vertex is not present in graph ");
            return;
        }
        Set<Vertex> visited = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            var current = stack.pop();
            if (visited.contains(current))
                continue;
            System.out.print(current + "    ");
            visited.add(current);
            for (var neighbour : getNeighbors(current))
                if (!visited.contains(neighbour))
                    stack.push(neighbour);
        }
    }

    //Recursive DFS
    public void traverseDepthFirstRec(String root) {
        var node = getNode(root);
        if (node == null)
            return;
        traverseDepthFirstRec(node, new HashSet<>());
    }
    private void traverseDepthFirstRec(Vertex root, Set<Vertex> visited) {
        System.out.print(root + "    ");
        visited.add(root);
        for (var node : getNeighbors(root))
            if (!visited.contains(node))
                traverseDepthFirstRec(node, visited);
    }
    private Vertex getNode(String name) {
        for (Vertex vertex : vertexList) {
            if (vertex.label.equals(name))
                return vertex;
            else
                return null;
        }
        return null;
    }


    //BFS
    public void bfs() {
        var node = vertexList.get(0);
        if (node == null) {
            System.out.println("This vertex is not present in graph ");
            return;
        }
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            var currentNode = queue.remove();
            if (visited.contains(currentNode))
                continue;
            System.out.print(currentNode + "     ");
            visited.add(currentNode);
            ArrayList<Vertex> neighbours = getNeighbors(currentNode);
            for (var neighbour : neighbours)
                if (!visited.contains(neighbour))
                    queue.add(neighbour);

        }
    }

    private ArrayList<Vertex> getNeighbors(Vertex node) {
        ArrayList<Vertex> neighbors = new ArrayList<>();
        int nodeIndex = getIndex(node);
        for (int i = 0; i < numVertices; i++) {
            if (adjMat[nodeIndex][i] == 1)
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
                indegreeMap.remove(neighbour);
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
            if (adjMat[i][vertexIndex] != 0)
                indegree++;
        }
        return indegree;
    }




}
