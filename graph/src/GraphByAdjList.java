import java.util.*;
import java.util.HashMap;
import java.util.Stack;

public class GraphByAdjList {
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

    private GraphType graphType;

    private final Map<String, Vertex> vertices = new HashMap<>();
    private final Map<Vertex, List<Vertex>> adjacencyList = new HashMap<>();

    public GraphByAdjList(GraphType graphType) {
        this.graphType = graphType;
    }

    public void addVertex(String label) {
        var node = new Vertex(label);
        vertices.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = vertices.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = vertices.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
        if (graphType == GraphType.UNDIRECTED)
            adjacencyList.get(toNode).add(fromNode);
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label) {
        var node = vertices.get(label);
        if (node == null)
            return;

        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        vertices.remove(label);
    }

    public void removeEdge(String from, String to) {
        var fromNode = vertices.get(from);
        var toNode = vertices.get(to);

        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    //Depth first traversal recursive
    public void traverseDepthFirstRec(String root) {
        var node = vertices.get(root);
        if (node == null)
            return;

        traverseDepthFirstRec(node, new HashSet<>());
    }

    private void traverseDepthFirstRec(Vertex root, Set<Vertex> visited) {
        System.out.println(root);
        visited.add(root);

        for (var node : adjacencyList.get(root))
            if (!visited.contains(node))
                traverseDepthFirstRec(node, visited);
    }

    //DFS iterative
    public void traverseDepthFirst(String root) {
        var node = vertices.get(root);
        if (node == null)
            return;

        Set<Vertex> visited = new HashSet<>();

        Stack<Vertex> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            var current = stack.pop();

            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (var neighbour : adjacencyList.get(current))
                if (!visited.contains(neighbour))
                    stack.push(neighbour);
        }
    }

    public void traverseBreadthFirst(String root) {
        var node = vertices.get(root);
        if (node == null)
            return;

        Set<Vertex> visited = new HashSet<>();

        Queue<Vertex> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            var current = queue.remove();

            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (var neighbour : adjacencyList.get(current))
                if (!visited.contains(neighbour))
                    queue.add(neighbour);
        }
    }

    public List<String> topologicalSort() {
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new HashSet<>();
        for (var node : vertices.values())
            topologicalSort(node, visited, stack);
        List<String> sorted = new ArrayList<>();
        while (!stack.empty())
            sorted.add(stack.pop().label);
        return sorted;
    }

    private void topologicalSort(
            Vertex vertex, Set<Vertex> visited, Stack<Vertex> stack) {
        if (visited.contains(vertex))
            return;

        visited.add(vertex);
        for (var neighbour : adjacencyList.get(vertex))
            topologicalSort(neighbour, visited, stack);

        stack.push(vertex);
    }

    //Detect cycle in directed graph
    public boolean hasCycle() {
        Set<Vertex> all = new HashSet<>();
        all.addAll(vertices.values());

        Set<Vertex> visiting = new HashSet<>();
        Set<Vertex> visited = new HashSet<>();

        while (!all.isEmpty()) {
            var current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Vertex vertex, Set<Vertex> all, Set<Vertex> visiting, Set<Vertex> visited) {
        all.remove(vertex);
        visiting.add(vertex);

        for (var neighbour : adjacencyList.get(vertex)) {
            if (visited.contains(neighbour))
                continue;

            if (visiting.contains(neighbour))
                return true;

            if (hasCycle(neighbour, all, visiting, visited))
                return true;
        }

        visiting.remove(vertex);
        visited.add(vertex);

        return false;
    }

    //Detect cycle using BFS in undirected graph
    public boolean isCyclicBFS(String source){
        var sourceNode=vertices.get(source);
        if (sourceNode==null)
            return false;
        Map<Vertex, Boolean>visited=new HashMap<>();
        Map<Vertex, Vertex>parent=new HashMap<>();
        Queue<Vertex>queue=new LinkedList<>();
        queue.add(sourceNode);
        visited.put(sourceNode, true);
        parent.put(sourceNode, sourceNode);

        while (!queue.isEmpty()){
            var currentNode=queue.remove();
            for (var neighbour:adjacencyList.get(currentNode)){
                if (visited.containsKey(neighbour) && parent.get(currentNode)!=neighbour)
                    return true;
                else if(!visited.containsKey(neighbour)){
                    visited.put(neighbour, true);
                    parent.put(neighbour, currentNode);
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        GraphByAdjList graph = new GraphByAdjList(GraphType.DIRECTED);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("C", "E");
        graph.addEdge("E", "B");
        graph.addEdge("B", "D");
        graph.addEdge("E", "D");

        graph.traverseBreadthFirst("A");

        /*List<String>res=graph.topologicalSort();
        System.out.println(res);*/


    }


}
