import java.util.*;

/*Check whether sum of any two number in array equal to given number*/
public class PairSumOfTwoNumber {
    // Method 1: Brute force. Time : O(n^2), Space = O(1)
    // Initialise with a[i] .Iterate through array and add with rest of number one
    // by one
    public static boolean checkSumOfTwoNumberBruteForce(int[] array, int sum) {
        if (array.length < 2)
            return false;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum)
                    return true;
            }
        }
        return false;
    }

    // Using sorting
    // Sort the array then add the beg and end . If beg +end > target then decrease
    // end otherwise increase start.
    // Time : O(nlog(n) Space : O(1)
    public static boolean checkPairSumBySorting(int[] array, int sum) {
        if (array.length < 2)
            return false;

        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int currentSum = array[start] + array[end];
            if (currentSum== sum)
                return true;
            else if (currentSum > sum)
                end--;
            else
                start++;
        }
        return false;
    }
    // Method 3 : Hashing
    // Initialise hashSet , iterate through array if set.contains(sum-array[i])
    // return true else add arr[i] to set
    // Time : O(n)
    // Space : O(n)

    public static boolean checkTwoNumberSumByHashing(int[] array, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(sum - array[i]))
                return true;
            else
                set.add(array[i]);
        }
        return false;
    }

    public static List<List<Integer>> pair_sum(int[] array, int sum) {
        Set<Integer> trackSet = new HashSet<>();
        List<List<Integer>> allPair = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int target = sum - array[i];
            if (trackSet.contains(target))
                allPair.add(Arrays.asList(Math.min(array[i], target), Math.max(array[i], target)));
            else
                trackSet.add(array[i]);
        }
        return allPair;
    }
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> trackSet = new HashSet<>();
        int[]result=new int[2];
        for (int i = 0; i < nums.length; i++) {
            int match = target - nums[i];
            if (trackSet.contains(match)) {
                result[0] = Math.min(nums[i], match);
                result[1] = Math.max(nums[i], match);
            } else
                trackSet.add(nums[i]);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,2};
        System.out.println(checkSumOfTwoNumberBruteForce(arr, 4));
        System.out.println(checkPairSumBySorting(arr, 4));
        System.out.println(checkTwoNumberSumByHashing(arr, 100));
        System.out.println(pair_sum(arr, 4));
    }
}
