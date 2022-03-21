import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeByLinkedList {
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

    //Inserting  TC:O(logN)
    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }

    }

    //Deletion in BST
    public void deleteInBST(int value) {
        deleteInBST(root, value);
    }

    private Node deleteInBST(Node root, int value) {
        if (root == null) {
            System.out.println("Value not found in tree : ");
            return null;
        }
        if (value < root.value)
            root.left = deleteInBST(root.left, value);
        else if (value > root.value)
            root.right = deleteInBST(root.right, value);
        else {      //If current node to be deleted
            if (root.left != null && root.right != null) {    // If node to be deleted has both children
                Node minNodeFromRight = getMinNode(root.right);  //Finding min from right subtree
                root.value = minNodeFromRight.value;
                root.right = deleteInBST(root.right, minNodeFromRight.value);
            } else if (root.left != null)   //if node to be deleted has only left child
                root = root.left;
            else if (root.right != null)
                root = root.right;
            else
                root = null;   //if root is leaf node
        }
        return root;
    }

    private Node getMinNode(Node node) {
        if (node.left == null)
            return node;
        else
            return getMinNode(node.left);
    }


    //Searching
    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.left;
            else if (value > current.value)
                current = current.right;
            else
                return true;
        }
        return false;
    }

    //Pre order traversal
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

    //Level order traversal  BFS
    public void traverseLevelOrder() {

        if (root == null) {
            System.out.println("Tree is empty");
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var currentNode = queue.remove();
            System.out.print(currentNode.value + "    ");
            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);

        }
    }


    //Height  of tree
    public int height() {
        return height(root);
    }

    private int height(Node root) {

        if (root == null)
            return -1;

        if (isLeafNode(root))
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    private boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }

    //Minimum value in BT  TC: O(N)
    public int minBT() {
        return minBT(root);
    }

    private int minBT(Node root) {
        if (isLeafNode(root))
            return root.value;

        var left = minBT(root.left);
        var right = minBT(root.right);
        return Math.min(Math.min(left, right), root.value);
    }

    //Min in BST  TC:O(logN)
    public int minBST() {
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last.value;
    }

    //Max value in BST
    public int max() {
        if (root == null)
            throw new IllegalStateException();

        return max(root);
    }

    private int max(Node root) {
        if (root.right == null)
            return root.value;

        return max(root.right);
    }

    //Check equality
    public boolean equals(BinarySearchTreeByLinkedList other) {
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;
        if (first != null && second != null)
            return first.value == second.value &&
                    equals(first.left, second.left) &&
                    equals(first.right, second.right);
        return false;

    }

    //Validate BST
    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        return isBST(root.left, min, root.value - 1) && isBST(root.right, root.value + 1, max);
    }

    //swap left and right value
    public void swapRoot() {
        var temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


    //Nodes at k distance from root
    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (distance == 0) {
            list.add(root.value);
            return;
        }
        getNodesAtDistance(root.left, distance - 1, list);
        getNodesAtDistance(root.right, distance - 1, list);
    }

    //Size of tree
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;

        if (isLeafNode(root))
            return 1;

        return 1 + size(root.left) + size(root.right);
    }

    //Count leaves
    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (isLeafNode(root))
            return 1;

        return countLeaves(root.left) + countLeaves(root.right);
    }

    //Contains value
    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        return contains(root.left, value) || contains(root.right, value);
    }

    //Are siblings
    public boolean areSibling(int first, int second) {
        return areSibling(root, first, second);
    }

    private boolean areSibling(Node root, int first, int second) {
        if (root == null)
            return false;

        var areSibling = false;
        if (root.left != null && root.right != null) {
            areSibling = (root.left.value == first && root.right.value == second) ||
                    (root.right.value == first && root.left.value == second);
        }

        return areSibling ||
                areSibling(root.left, first, second) ||
                areSibling(root.right, first, second);
    }

    //Get ancestors
    public List<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, List<Integer> list) {
        // We should traverse the tree until we find the target value. If
        // find the target value, we return true without adding the current node to the list;
        // otherwise, if we ask for ancestors of 5, 5 will be also  added to the list.
        if (root == null)
            return false;
        if (root.value == value)
            return true;
        // If we find the target value in the left or right sub-trees, that means the current node (root) is one of the ancestors.
        // So we add it to the list.
        if (getAncestors(root.left, value, list) ||
                getAncestors(root.right, value, list)) {
            list.add(root.value);
            return true;
        }
        return false;
    }

    //Check for balanced binary tree . if tree height in left and right differ by 0 or 1
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if (root == null)
            return true;

        var balanceFactor = height(root.left) - height(root.right);

        return Math.abs(balanceFactor) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    //perfect tree
    public boolean isPerfect() {
        return size() == (Math.pow(2, height() + 1) - 1);
    }

    //Diameter of tree i.e largest path between any two  node in tree
    //TC:O(N)  since we are going to touch every node of tree
    //SC:O(h)  we are going deep as height of tree
    private static class ResultNode {
        int bestDiameter;
        int height;

        public ResultNode(int bestDiameter, int height) {
            this.bestDiameter = bestDiameter;
            this.height = height;
        }
    }

    public int diameter() {
        ResultNode finalAnswer = maxDiameter(root);
        return finalAnswer.bestDiameter;
    }

    private ResultNode maxDiameter(Node root) {
        if (root == null)
            return new ResultNode(0, 0);

        var leftResult = maxDiameter(root.left);
        var rightResult = maxDiameter(root.right);
        int maxOfLeftAndRightSubtree = Math.max(leftResult.bestDiameter, rightResult.bestDiameter);
        int bestDiam = Math.max(maxOfLeftAndRightSubtree, leftResult.height + rightResult.height);
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new ResultNode(bestDiam, height);
    }


    public static void main(String[] args) {
        BinarySearchTreeByLinkedList tree = new BinarySearchTreeByLinkedList();
        tree.insert(120);
        tree.insert(125);
        tree.insert(85);
        tree.insert(100);
        tree.insert(70);
        tree.insert(50);
        tree.insert(65);
        tree.insert(40);
        tree.insert(20);
        tree.insert(45);
        tree.insert(75);
        tree.insert(72);
        tree.insert(77);
        tree.insert(76);
        tree.insert(79);
        tree.insert(82);

        //tree.deleteInBST(20);
        tree.traverseLevelOrder();

        System.out.println();
        System.out.println(tree.diameter());


        //System.out.println(tree.isPerfect());

        // var list=tree.getAncestors(6);
        // System.out.println(list);


        //System.out.println(tree.areSibling(4,8));
        //System.out.println(tree.contains(69));

      /* var list= tree.getNodesAtDistance(1);
       for (var item:list)
           System.out.print(item+"   ");*/

        //tree.swapRoot();

        // System.out.println(tree.isBST());
       /* BinarySearchTreeByLinkedList tree2 = new BinarySearchTreeByLinkedList();

        tree2.insert(9);
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        //tree2.insert(10);

        System.out.println(tree.equals(tree2));*/

      /*  System.out.println("Traversing pre order");
        tree.traversePreorder();
        System.out.println();
        System.out.println("Traversing  In order ");
        tree.traverseInorder();
        System.out.println();
        System.out.println("Traversing post order");
        tree.traversePostorder();

        //System.out.println(tree.height());
        System.out.println();
        System.out.println("Traversing  level order ");
        tree.traverseLevelOrder();*/

    }
}
