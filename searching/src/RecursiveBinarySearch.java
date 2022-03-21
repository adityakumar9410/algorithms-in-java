public class RecursiveBinarySearch {

    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, 0, array.length - 1, target);
    }

    public static int binarySearch(int[] array, int low, int high, int target) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (target == array[mid])
            return mid;
        else if (target < array[mid])
            return binarySearch(array, low, mid - 1, target);
        else
            return binarySearch(array, mid + 1, high, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 9, 13, 15, 23, 45, 56, 98};
        int index = binarySearch(arr, 8);
        System.out.println(index);
    }
}
