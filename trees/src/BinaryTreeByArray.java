public class BinaryTreeByArray {
    int [] arr;
    int lastUsedIndex;
    //Constructor for blank Tree
    public BinaryTreeByArray(int size) {
        arr = new int[size+1];
        this.lastUsedIndex = 0;   //  At  index=0, we don't put  any value
        System.out.println("Blank Tree of size " +size+ " has been created !\n");
    }

    //To check whether tree is full
    private   boolean isTreeFull(){
        return arr.length - 1 == lastUsedIndex;
    }

    //Inserting   TC: O(1)  || SC :  O(1)
    public void insert(int value){
        if(!isTreeFull()) {
            arr[lastUsedIndex+1] = value;
            lastUsedIndex++;
        }else {
            System.out.println("Could not insert value in the Tree as it is full !");
        }
    }

    //Searching a value  TC:O(n)  ||  SC : O(1)
    // Do a linear search on the array
    public int search(int value) {
        for (int i = 0; i <= lastUsedIndex; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }
    //All DFS traversing algo takes TC:O(n)  ||  SC : O(n)
    // Pre-Order traversal of binary tree
    public void preOrder(){
        preOrder(1);
    }
    private void preOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    // In-Order Traversal of binary tree
    public void inOrder(){
        inOrder(1);
    }
    private   void inOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        inOrder(index * 2);
        System.out.print(arr[index] + " ");
        inOrder(index * 2 + 1);
    }

    // Post-Order Traversal of binary tree
    public void postOrder(){
        postOrder(1);
    }
    private void postOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        postOrder(index * 2);
        postOrder(index * 2 + 1);
        System.out.print(arr[index] + " ");
    }

    //BFS :  Level order
    //TC : O(n)   ||  SC :  O(1)
    public void levelOrder() {
        for(int i=1;i<=lastUsedIndex;i++ ) {
            System.out.print(arr[i]+" ");
        }
    }

    // Delete operation of binary tree  TC : O(N)  || SC :O(1)
    public void delete(int value) {
        int location = search(value);
        //If Value does not exists in Array
        if (location == -1) {
            return;
        }else {
            //insert last element of the Tree into current location
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
        }
    }
   //Delete whole tree  TC:O(1)  || SC :O(1)
    public void deleteTree(){
        try {
            arr = null;
            System.out.println("Tree has been deleted successfully !");
        }catch(Exception e){
            System.out.println("There was an error deleting the tree.");
        }
    }

    public static void main(String[] args) {

        BinaryTreeByArray btByArray=new BinaryTreeByArray(10);
        btByArray.insert(23);
        btByArray.insert(87);
        btByArray.insert(45);
        btByArray.insert(92);
        //Level order Traverse
        System.out.println("\nLevel-order Traversal:");
        btByArray.levelOrder();
        //Pre order Traverse
        System.out.println("\n\nPre-order Traversal:");
        btByArray.preOrder();
        //Post order Traverse
        System.out.println("\n\nPost-order Traversal:");
        btByArray.postOrder();
        //In order Traverse
        System.out.println("\n\nIn-order Traversal:");
        btByArray.inOrder();

    }
}
