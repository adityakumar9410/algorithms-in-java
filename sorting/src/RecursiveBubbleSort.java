public class RecursiveBubbleSort {
   public static void bubbleSort(int[] arr, int n) {
        // Base case
        if (n == 1)
            return;
        // After one pass, the largest element is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i + 1]) {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        // Largest element is fixed,recur for remaining array
        bubbleSort(arr, n-1);
   }
    /* Prints the array */
    private static void printArray(int[] arr) {
        for (int i : arr)
            System.out.println(arr[i] + "   ");
    }
    public static void main(String[] args) {
        int[] A= {2, 7, 78, 4, 34, 23, 97, 1, 100};
        printArray(A);
        bubbleSort(A, A.length);
        printArray(A);
    }

}
