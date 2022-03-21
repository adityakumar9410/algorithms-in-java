// Given an array , find  max sum of sub-array if size is k
public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumOfSubArrayOfSizeK(int[] array, int k) {
        if (array.length == 0 || k <= 0 || k > array.length)
            return -1;

        int window_sum = 0;
        for (int i = 0; i < k; i++)
            window_sum = window_sum + array[i];

        int max_sum = window_sum;
        int start = 0;
        for (int j = k; j < array.length; j++) {
            window_sum = window_sum + array[j] - array[start++];
            if (window_sum > max_sum)
                max_sum = window_sum;
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 4, 1};
        System.out.println(findMaxSumOfSubArrayOfSizeK(arr, 2));
    }
}
