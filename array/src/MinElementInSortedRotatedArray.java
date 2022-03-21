public class MinElementInSortedRotatedArray {

    //Iterative
    public static int findMinimumElementRotatedSortedArray(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = low + ((high - low) / 2);

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public int findMin2(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] <= nums[j])
                return nums[i];

            int m = (i + j) / 2;

            if (nums[m] >= nums[i]) {
                i = m + 1;
            } else {
                j = m;
            }
        }

        return -1;
    }

    //recursion
    public int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }

    public int findMin(int[] num, int left, int right) {
        if (left == right)
            return num[left];
        if ((right - left) == 1)
            return Math.min(num[left], num[right]);

        int middle = left + (right - left) / 2;

        // not rotated
        if (num[left] < num[right]) {
            return num[left];

            // go right side
        } else if (num[middle] > num[left]) {
            return findMin(num, middle, right);

            // go left side
        } else {
            return findMin(num, left, middle);
        }
    }


    // Driver Program
    public static void main(String[] args) {
        int arr1[] = {5, 6, 7, 2, 3, 4};

        System.out.println(findMinimumElementRotatedSortedArray(arr1));
    }
}
