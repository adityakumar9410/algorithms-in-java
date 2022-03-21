public class BinarySearch {
    public static int binarySearch(int[] array, int target) {   // time complexity = O(logn)
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target > array[mid]) {
                low = mid + 1;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 9, 13, 15, 23, 45, 56, 98};
        int target=23;
        int index = binarySearch(arr, target);
        System.out.println("Number " +target+"  is present at index  "+index);
    }
}
