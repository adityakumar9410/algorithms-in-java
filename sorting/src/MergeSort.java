public class MergeSort {
    public static void mergeSort(int[] array, int left, int right) {
        if (array.length <= 1)
            return;
        if (right > left) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        //when left=0, mid=0 and right=1
        int[] leftTempArray = new int[middle - left + 2];   //last cell will store max int value to avoid index out of bound while comparing

        // Array of size two will be created , one to store last  element and other to store max number
        int[] rightTempArray = new int[right - middle + 1];

        for (int i = 0; i < middle - left+1; i++) //Copy values from Array 'arr' to these tmp arrays
            leftTempArray[i] = arr[left + i];
        for (int i = 0; i < right - middle; i++)
            rightTempArray[i] = arr[middle + 1 + i];

        leftTempArray[middle - left + 1] = Integer.MAX_VALUE; // keep max number in last index of temp array so finally pointer will point to this max number
        rightTempArray[right - middle] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (leftTempArray[i] < rightTempArray[j]) {
                arr[k] = leftTempArray[i];
                i++;
            } else {
                arr[k] = rightTempArray[j];
                j++;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 11, 6, 3, 12, 1, 9};
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);

    }

}
