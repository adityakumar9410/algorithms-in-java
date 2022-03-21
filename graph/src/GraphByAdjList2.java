import java.util.*;
public class GraphByAdjList2 {
    private class Node{
        private String label;
        private ArrayList<Node>neighbours=new ArrayList<>();
        private boolean isVisited=false;
        private Node  parent;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

    }
    private final Map<String, Node>vertices=new HashMap<>();
    //Add vertex
    public void addVertex(String  label){
        var node = new Node(label);
        vertices.putIfAbsent(label, node);
    }

    //Add edge
    public void addEdge(String from, String to) {
        var fromNode = vertices.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = vertices.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        fromNode.neighbours.add(toNode);  //For directed edge
        toNode.neighbours.add(fromNode);   //If edge is undirected
    }

    //BFS
    public void BFS(String source){
        var node= vertices.get(source);
        if (node==null)
            return;

        Queue<Node>queue=new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            var currentNode=queue.remove();
            currentNode.isVisited=true;
            System.out.println(currentNode+"    ");
            for (var neighbour:currentNode.neighbours){
                if (!neighbour.isVisited){    //If neighbour is not visited then add to queue
                    queue.add(neighbour);
                    neighbour.isVisited=true;
                }
            }
        }
    }


    public static void main(String[] args) {
        GraphByAdjList2  graph=new GraphByAdjList2();
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

        graph.BFS("A");
    }
}
