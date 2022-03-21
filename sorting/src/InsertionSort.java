public class InsertionSort {
    public static void insertionSort(int[] array) {
        int n = array.length;
        if (n < 1)
            System.out.println(" Empty array");

        for (int i = 1; i < n; i++) {
            int temp = array[i];   // take first element of unsorted array
            int j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];       // shifting number until get correct index in sorted array
                j--;
            }
            array[j] = temp;
        }
    }

    /* Prints the array */
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + "    ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 0};
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }
}
