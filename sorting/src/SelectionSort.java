public class SelectionSort {
    public static void selectionSort(int[] array) {
        if (array.length <= 1)
            return;

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {        // we need n-1 iteration because last unsorted array will contain biggest number
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            if (minIndex != i)     // If  ith element is min then to avoid swap fun calling
                swap(array, i, minIndex);
        }
    }

    private static void swap(int[] array, int l, int m) {
        int temp = array[l];
        array[l] = array[m];
        array[m] = temp;
    }

    /* Prints the array */
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + "    ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 6, 10, 16, 12, 9, 14};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
