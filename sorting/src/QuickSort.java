import java.util.Collections;
import java.util.Random;
public class QuickSort {
    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = randomizedPartition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }
    private static int randomizedPartition(int[] array, int start, int end) {
        Random rand=new Random();
        int pivotIndex= rand.nextInt((end-start)+1)+start;
        swap(array, pivotIndex, end);
        return partition(array, start,end);
    }
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int pIndex = low;      // This will give the index of pivot  after partitioning
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                if (pIndex != j)
                    swap(array, pIndex, j);
                pIndex++;
            }
        }
        swap(array, pIndex, high);
        return pIndex;
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "    ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 8, 1, 3, 7};
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

}
