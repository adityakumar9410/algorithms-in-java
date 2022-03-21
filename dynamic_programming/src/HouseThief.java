public class HouseThief {
    //Find maximum loot , thief can not loot adjacent house
    //Top Down
    public int maxMoney(int[] houseValues) {
        int[] dp = new int[houseValues.length];
        return maxMoney_TopDown(dp, houseValues, 0);
    }

    private int maxMoney_TopDown(int[] dp, int[] houseValues, int currIndex) {
        if (currIndex >= houseValues.length)
            return 0;

        if (dp[currIndex] == 0) {
            int stealCurrent = houseValues[currIndex] + maxMoney_TopDown(dp, houseValues, currIndex + 2);
            int skipCurrent = maxMoney_TopDown(dp, houseValues, currIndex + 1);
            dp[currIndex] = Math.max(stealCurrent, skipCurrent);
        }
        return dp[currIndex];
    }

    //Bottom up
    public int findMaxSteal(int[] nums) {

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
        HouseThief ht = new HouseThief();
        int[] houseNetWorth ;

        houseNetWorth = new int[]{20, 5, 1, 13, 6, 11, 40};
        System.out.println(ht.maxMoney(houseNetWorth));
        System.out.println(ht.findMaxSteal(houseNetWorth));
    }
}
