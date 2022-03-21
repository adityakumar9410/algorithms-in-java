import java.util.*;

public class ShortestPathBFSByDistanceTable {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }
    private class Vertex {
        private String label;
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


    private class DistanceInfo{
        private int distance;
        private Vertex lastVertex;

        public DistanceInfo() {
             distance=-1;
             lastVertex = null;
        }
    }

    private Map<Vertex, DistanceInfo>buildDistanceTable(String  name){
        Map<Vertex, DistanceInfo>distanceTable=new HashMap<>();
        for(var  vertex :vertices.values())
            distanceTable.put(vertex, new DistanceInfo());
        var sourceNode=vertices.get(name);
        distanceTable.get(sourceNode).distance=0;
        distanceTable.get(sourceNode).lastVertex=sourceNode;
        Queue<Vertex>queue=new LinkedList<>();
        queue.add(sourceNode);
        while (!queue.isEmpty()){
            var currentVertex=queue.remove();
            for(var neighbour:adjacencyList.get(currentVertex)){
                int currentDistance=distanceTable.get(neighbour).distance;
                if (currentDistance==-1){
                    currentDistance=1+distanceTable.get(currentVertex).distance;
                    distanceTable.get(neighbour).distance=currentDistance;
                    distanceTable.get(neighbour).lastVertex=currentVertex;
                }
                if (!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited=true;
                }
            }
        }
        return distanceTable;
    }

    public void shortestPath(String source , String destination){
        Map<Vertex, DistanceInfo>distanceTable=buildDistanceTable(source);
        Stack<Vertex>stack=new Stack<>();
        var destNode=vertices.get(destination);
        stack.push(destNode);
        var prevVertex=distanceTable.get(destNode).lastVertex;
        while (prevVertex!=null && prevVertex!=vertices.get(source) ){
            stack.push(prevVertex);
            prevVertex=distanceTable.get(prevVertex).lastVertex;
        }

        if (prevVertex==null)
            System.out.println("There is no path from vertex "+source+"  to  "+destination);
        else {
            System.out.print("Smallest path is "+vertices.get(source));
            while (!stack.isEmpty())
                System.out.print("  -->   "+stack.pop().label);
        }
    }

    public static void main(String[] args) {
        ShortestPathBFSByDistanceTable graph=new ShortestPathBFSByDistanceTable();
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

        graph.shortestPath("A", "D");
    }


}
