public class ExponentialSearch {
    //TC : O(i)   where  i is the index of target element
    public static int exponentialSearch(int[] array, int target) {
        int bound = 1;
        while (bound < array.length && array[bound] < target)
            bound *= 2;

        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);

        return binarySearch(array, left, right, target);
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
        int target = 23;
        int index = exponentialSearch(arr, target);
        System.out.println("Number " + target + "  is present at index  " + index);
    }
}
