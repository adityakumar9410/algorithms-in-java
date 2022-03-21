import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeByLinkedList {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    /* Inserting in binary tree  .Since in binary tree order of element does not matter  so insert at first vacant child in
    level order traversal.   TC :  O(n)  || SC : O(n)*/
    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        //Do a level order traversal and find the first blank space
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var currentNode = queue.remove();
            if (currentNode.left == null) {
                currentNode.left = node;
                break;
            } else if (currentNode.right == null) {
                currentNode.right = node;
                break;
            } else {
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
    }

    /*Searching in Binary tree
     * Do a level order traversal if value is found return true
     * TC: O(n)  ||  SC : O(n)  */
    public boolean search(int value) {
        if (root == null)
            return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var currentNode = queue.remove();
            if (currentNode.value == value)
                return true;
            else {
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }
        return false;
    }

    /*Delete node with given value
     * Find deepest node copy data from deepest node and add data to current node which is to be deleted
     * TC : O(n)  ||  SC :  O(n) */
    public void delete(int value) {
        if (root == null) {
            System.out.println("Tree is empty :  ");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var currentNode = queue.remove();
            if (currentNode.value == value) {
                currentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                return;
            } else {
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }

    }

    private void deleteDeepestNode() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node previousNode, currentNode = null;
        while (!queue.isEmpty()) {
            previousNode = currentNode;
            currentNode = queue.remove();
            if (currentNode.left == null && previousNode != null) {
                previousNode.right = null;
                return;
            } else if (currentNode.right == null) {
                currentNode.left = null;
                return;
            }
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }
    }

    private Node getDeepestNode() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node currentNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
        return currentNode;
    }

    /*DFS
     * 1.) Pre order traversal
     * TC : O(n) || SC : O(n) */

    public void traversePreorder() {

        traversePreorder(root);
    }

    private void traversePreorder(Node root) {

        if (root == null)
            return;

        System.out.print(root.value + "     ");
        traversePreorder(root.left);
        traversePreorder(root.right);

    }

    //In order traversal
    public void traverseInorder() {

        traverseInorder(root);
    }

    private void traverseInorder(Node root) {

        if (root == null)
            return;

        traverseInorder(root.left);
        System.out.print(root.value + "     ");
        traverseInorder(root.right);

    }

    //Post order traversal
    public void traversePostorder() {

        traversePostorder(root);
    }

    private void traversePostorder(Node root) {

        if (root == null)
            return;

        traversePostorder(root.left);
        traversePostorder(root.right);
        System.out.print(root.value + "     ");

    }

    //Level order traversal
    public void traverseLevelOrder() {

        if (root == null)
            System.out.println("Tree is empty");


        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var currentNode = queue.remove();
            System.out.print(currentNode.value + "     ");
            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
    }


    //Check whether tree is symmetric i.e left subtree and right subtree of root node is mirror image of each other
    //TC:O(N) || SC:O(logN)
    public boolean isSymmetricTree() {
        if (root == null)
            return true;

        return isSymmetricTreeHelper(root.left, root.right);
    }

    private boolean isSymmetricTreeHelper(Node leftSubtree, Node rightSubtree) {
        if (leftSubtree == null && rightSubtree == null)
            return true;

        if (leftSubtree != null && rightSubtree != null) {
            return leftSubtree.value == rightSubtree.value && isSymmetricTreeHelper(leftSubtree.right, rightSubtree.left) &&
                    isSymmetricTreeHelper(leftSubtree.left, rightSubtree.right);
        }

        return false;
    }

    //Find whether a path exist from root to any leaf node whose path sum is equal to given target value
    //TC:O(N) || SC:O(h)
    public boolean hasPathSum(int target){
       return hasPathSum(root, target);
    }

    private boolean hasPathSum(Node node, int target) {
        if (node==null)
            return false;

        boolean isLeafNode =node.left==null&&node.right==null;
        if (isLeafNode  && target-node.value==0)
            return true;

        return hasPathSum(node.left, target-node.value) ||hasPathSum(node.right, target-node.value);
    }





    //Delete binary tree
    public void deleteBinaryTree() {
        root = null;
        System.out.println("Deleted binary tree  successfully");
    }

    public static void main(String[] args) {
        BinaryTreeByLinkedList binaryTree = new BinaryTreeByLinkedList();

        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(4);
        binaryTree.insert(3);
        //binaryTree.delete(127);
        binaryTree.traverseLevelOrder();
        System.out.println();
        //System.out.println(binaryTree.search(127));

        System.out.println(binaryTree.isSymmetricTree());
    }


}
