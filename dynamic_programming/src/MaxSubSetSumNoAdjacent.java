public class MaxSubSetSumNoAdjacent {
    //Find max sum in array by adding it's element with no adjacent element added
    //TC:O(n) || SC:O(n)
    public static int maxSubsetSumNoAdjacentElement(int[]nums){
        if (nums.length==0)
            return 0;
        else if (nums.length==1)
            return nums[0];

        int[] maxSums=nums.clone();
        maxSums[1]=Math.max(nums[0], nums[1]);
        for (int i=2;i<nums.length;i++)
            maxSums[i]=Math.max(maxSums[i-1], maxSums[i-2]+nums[i]);

        return maxSums[nums.length-1];
    }
    //method 2 :
    //TC:O(n) || SC:O(1)
    public static int maxSubsetSumNoAdjacent(int[] nums){
        if (nums.length==0)
            return 0;
        else if (nums.length==1)
            return nums[0];
        int second=nums[0];
        int first=Math.max(nums[0], nums[1]);
        for (int i=2;i<nums.length;i++){
            int current=Math.max(first, second+nums[i]);
            second=first;
            first=current;
        }
        return first;
    }
    public static void main(String[] args) {
        int[]arr={7,10,12,7,9,14};
        System.out.println(maxSubsetSumNoAdjacentElement(arr));
        System.out.println(maxSubsetSumNoAdjacent(arr));
    }
}
