import java.util.*;
public class BFSForSSSP {
    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }
    private class Vertex {
        private String label;
        private Vertex  parent;
        private boolean isVisited=false;

        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
    private final GraphType graphType=GraphType.UNDIRECTED;
    private final Map<String, Vertex> vertices = new HashMap<>();
    private final Map<Vertex, List<Vertex>> adjacencyList = new HashMap<>();
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
        if (graphType== GraphType.UNDIRECTED)
            adjacencyList.get(toNode).add(fromNode);
    }


    public void findShortestPath(String source){
        var sourceVertex=vertices.get(source);
        Queue<Vertex>queue=new LinkedList<>();
        queue.add(sourceVertex);

        while (!queue.isEmpty()){
            var currentNode=queue.remove();
            currentNode.isVisited=true;
            System.out.println("Printing  shortest Path for the vertex  "+currentNode.label+" from   "+source);
            printPath(currentNode);
            //Below code will print single path from source to dest
           /* if (currentNode.label.equals(dest)) {
                System.out.println("Shortest path between "+source+"  and "+dest);
                printPath(currentNode);
            }*/
            System.out.println();
            for(var neighbour: adjacencyList.get(currentNode)){
                if (!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited=true;
                    neighbour.parent=currentNode;
                }
            }
        }
    }

    private void printPath(Vertex vertex) {           // This will print  path from current vertex till source node
        if (vertex.parent!=null)
            printPath(vertex.parent);
        System.out.print(vertex+"    ");
    }

    public static void main(String[] args) {
        BFSForSSSP  graph=new BFSForSSSP();
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

        graph.findShortestPath("A");


    }
}
