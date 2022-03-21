public class CountingSort {
    public static void sortArray(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, arr[i]);

        countingSort(arr, max);
    }

    private static void countingSort(int[] array, int m) {
        int n = array.length;

        int[] output = new int[n];
        int[] count = new int[m + 1];

       // Below operation will count the number of occurrence of each element in original array
        for(int i=0;i<n;i++)
            count[array[i]]++;

        //Prefix-sum of count array , this gives how many number is less or equal to array[i] in original array
        for(int i=1;i<=m;i++)
            count[i]+=count[i-1];

        // Below for loop will place each number at correct position in output array
        for(int i=0;i<n;i++){
            int index=count[array[i]]-1;
            output[index]=array[i];
            count[array[i]]--;
        }
        //Copy value to original array
        for(int i=0;i<n;i++)
            array[i]=output[i];
    }

    /* Prints the array */
    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + "    ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[]arr={3,2,2,0,4,6,7,3,5,7, 3,2,0,788,9876};
        printArray(arr);
        sortArray(arr);
        printArray(arr);
    }
}
