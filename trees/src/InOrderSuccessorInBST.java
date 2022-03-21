public class InOrderSuccessorInBST {
    private class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    //Inserting  TC:O(logN)
    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            node.parent=null;
            root = node;
            return;
        }
        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    node.parent=current;
                    break;
                }
                Node temp=current;
                current = current.left;
                current.parent=temp;
            } else {
                if (current.right == null) {
                    current.right = node;
                    node.parent=current;
                    break;
                }
                Node temp=current;
                current = current.right;
                current.parent=temp;
            }
        }

    }

     //Inorder successor of a node in tree
    //TC:O(h)  || SC:(1)

    public int successor(int  nodeVal){
        Node node=getNodeRef(nodeVal);
        if (node==null)
            throw new  IllegalArgumentException();

        Node  result=getSuccessor(node);

        return result!=null? result.value:Integer.MAX_VALUE;
    }

    private Node getSuccessor(Node node) {
        Node ptr=node;
        if (ptr.right!=null){
            ptr=ptr.right;
            while (ptr.left!=null){
                ptr=ptr.left;
            }
            return ptr;
        }

        while (ptr.parent!=null && ptr==ptr.parent.right){
            ptr=ptr.parent;
        }

        return ptr.parent;
    }

    private Node getNodeRef(int  val){
         var current = root;
         while (current != null) {
             if (val ==current.value)
                 return current;
             else if (val > current.value)
                 current = current.right;
             else
                 current=current.left;
         }
         return null;
    }

    public static void main(String[] args) {
        InOrderSuccessorInBST bst=new InOrderSuccessorInBST();
        bst.insert(6);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        System.out.println(bst.successor(7));

    }

}
