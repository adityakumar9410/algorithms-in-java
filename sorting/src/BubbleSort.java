public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {    // for n number we need just n-1 to bubble out
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    private static void swap(int[] array, int l, int m) {
        int temp = array[l];
        array[l] = array[m];
        array[m] = temp;
    }
    /* Prints the array */
    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + "    ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = {2, 7, 78, 4, 34, 23, 97, 1, 100};
        printArray(A);
        bubbleSort(A);
        printArray(A);
    }
}
