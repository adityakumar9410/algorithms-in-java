public class ReverseArray {
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    private static void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + "  ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {2, 7, 1, 9, 3, 5, 20};
        printArray(arr);
        reverseArray(arr);
        printArray(arr);
    }
}
