// Find largest sum sub-array , sub array can be of any size
public class LargestSubArraySum {

    public static int largestContinuousSum(int[] arr) {
        if (arr.length == 0)
            return 0;

        int max_sum, current_sum;
        max_sum = current_sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            current_sum = Math.max(current_sum + arr[i], arr[i]);
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -1, 3, 4, 10, 10, -10, -1};
        System.out.println(largestContinuousSum(arr));
    }
}
