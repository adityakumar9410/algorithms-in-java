import java.util.*;

public class WeightedGraph{
    private class Node implements Comparable<Node> {
        private String label;
        private Node parent;
        private int distance;
        private List<Node>neighbours=new ArrayList<>();
        private Map<Node,Integer>weightMap=new HashMap<>();

        public Node(String label) {
            this.label = label;
            distance=Integer.MAX_VALUE;
        }
        @Override
        public String toString() {
            return label;
        }
        @Override
        public int compareTo(Node o) {
            return this.distance-o.distance;
        }
    }

    Map<String, Node>vertices=new HashMap<>();

    //Adding Vertex
    public void addVertex(String label){
        var node=new Node(label);
        vertices.putIfAbsent(label, node);
    }

    //Adding edge
    public void addEdge(String from, String to  , int weight) {
        var fromNode = vertices.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = vertices.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        fromNode.neighbours.add(toNode);
        fromNode.weightMap.put(toNode, weight);
    }

    //Path print
    private static void pathPrint(Node node) {
        if(node.parent!=null) {
            pathPrint(node.parent);
            System.out.print("->"+node);
        }
        else
            System.out.print(node);
    }

    //Shortest path by Dijkstra  TC:O(V^2)   || SC :O(E)

    public void shortestPathByDijkstra(String  source, String destination){
        var sourceNode=vertices.get(source);
        sourceNode.distance=0;
        PriorityQueue<Node> queue = new PriorityQueue<>(vertices.values());
        while (!queue.isEmpty()){
            var currentNode=queue.remove();

            for (var neighbour:currentNode.neighbours){
                if (queue.contains(neighbour)){    // If neighbour is not visited
                    if (neighbour.distance>(currentNode.distance+currentNode.weightMap.get(neighbour))){
                        neighbour.distance=currentNode.distance+currentNode.weightMap.get(neighbour);
                        neighbour.parent=currentNode;
                        //Refresh Priority queue
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }

                }
            }
        }

       /* //print table of node with minimum distance and shortest path from source
        for(var nodeToCheck: vertices.values()) {
            System.out.print("Node "+nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }*/

        //shortest distance between two node
        var destNode=vertices.get(destination);
        System.out.println("Shortest path between "+source+ " and  "+destination+"  with distance "+destNode.distance);
        pathPrint(destNode);
    }

    public static void main(String[] args) {
        WeightedGraph graph=new WeightedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("E","B", 4);
        graph.addEdge("E","D", 2);
        graph.addEdge("D","B", 1);
        graph.addEdge("B","A", 3);
        graph.addEdge("D" ,"C", 1);
        graph.addEdge("A","D", 6);
        graph.addEdge("A","C", 6);
        graph.addEdge("C","D", 2);

        graph.shortestPathByDijkstra("E","A");


    }


}