
public class RangeSumQuery {
    /*Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
     Implement the NumArray class:NumArray(int[] nums) Initializes the object with the integer array nums.
      int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j]
      inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))
      Input
      ["NumArray", "sumRange", "sumRange", "sumRange"]
      [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
      Output
      [null, 1, -1, -3]
      Explanation
       NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
      numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
      numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
      numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))*/

    //TC:O(N) || SC: O:(1)
    private int[] sum;

    public  RangeSumQuery(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        RangeSumQuery rangeSumQuery=new RangeSumQuery(arr);

       int sum= rangeSumQuery.sumRange(1,2);
        System.out.println(sum);
    }
}
