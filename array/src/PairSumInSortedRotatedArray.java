public class PairSumInSortedRotatedArray {

    //TC:O(logN) || SC:O(1)
    public static int pairsInSortedRotated(int[] arr, int targetSum) {
        if (arr.length == 0){
            return 0;
        }
        // Find the pivot element. Pivot element is largest element of array.
        int pivot=getIndexOfLargestElement(arr);

        int n=arr.length;
        // l is index of smallest element.
        int left = (pivot + 1) % n;

        // r is index of largest element.
        int right = pivot;

        // Variable to store count of number of pairs.
        int cnt = 0;

        // Find sum of pair formed by arr[l] and arr[r] and update l, r and cnt accordingly.
        while (left != right) {
            // If we find a pair with sum x, then increment cnt, move l and r to next element.
            if (arr[left] + arr[right] == targetSum) {
                cnt++;

                // This condition is required to be checked, otherwise l and r will cross each other and loop will never terminate.
                if (left == (right - 1 + n) % n) {
                    return cnt;
                }

                left = (left + 1) % n;
                right = (right - 1 + n) % n;
            }// If current pair sum is less, move to the higher sum side.
            else if (arr[left] + arr[right] < targetSum)
                left = (left + 1) % n;
                // If current pair sum  is greater, move to the lower sum side.
            else
                right = (n + right - 1) % n;
        }
        return cnt;
    }

    private static int getIndexOfLargestElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else if (nums[left] > nums[mid]) {
                right = mid - 1;
            } else {
                // subtility here if there are duplicate elements in the array.
                // shift the left linearly
                left = left + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //int[]arr={6,8,9,2,3,4,5};
        int[] arr = {11, 15, 6, 7, 9, 10};
        int sum = 16;
        System.out.println(pairsInSortedRotated(arr,sum));
    }

}
