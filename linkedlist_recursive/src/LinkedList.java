

class Node{
    int data;
    Node next;
}

class Linked{

    public Node insert(int value, Node node) {
        if(node==null)
            return getNewNode(value);
        else {
            node.next=insert(value, node.next);
        }

        return node;

    }

    private Node getNewNode(int value) {
        Node a = new Node();
        a.data=value;
        a.next=null;

        return a;
    }
}
public class LinkedList {


    public static void main(String[] args) {

        Node root=null;
        Linked a=new Linked();

        root=a.insert(12, root);
        root=a.insert(98, root);

    }


}
