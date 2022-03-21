public class TernarySearch {
    //TC = log3N  , although log3N is less than log2N of binary search but binary search
    //is faster  than ternary search due to less comparisons
    public static int ternarySearch(int[] arr, int target) {
        return ternarySearch(arr, 0, arr.length - 1, target);
    }

    private static int ternarySearch(int[] array, int left, int right, int target) {

        if (left > right)
            return -1;

        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;
        if (array[mid1] == target)
            return mid1;
        if (array[mid2] == target)
            return mid2;
        if (target < array[mid1])
            return ternarySearch(array, left, mid1 - 1, target);
        if (target > array[mid2])
            return ternarySearch(array, mid2 + 1, right, target);
        return ternarySearch(array, mid1 + 1, mid2 - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 9, 13, 15, 23, 45, 56, 98};
        int target = 23;
        int index = ternarySearch(arr, target);
        System.out.println("Number " + target + "  is present at index  " + index);
    }


}
