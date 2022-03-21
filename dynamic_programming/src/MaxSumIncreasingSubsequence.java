public class MaxSumIncreasingSubsequence {

    //Given an array , find max sum of increasing subsequence
    //Method : Bottom Up DP  TC:O(n^2) || SC:O(n)
    public int maxSumIncSubsequenceDP(int []array){
        int[] maxSumDP=new int[array.length];
        for (int i=0;i<array.length;i++)
            maxSumDP[i]=array[i];
        int maxSum=0;
        for (int i=1;i<maxSumDP.length;i++){
            for (int j=0;j<i;j++){
                if (array[i]>array[j] && array[i]+maxSumDP[j]>maxSumDP[i]){
                    maxSumDP[i]=array[i]+maxSumDP[j];
                    maxSum=Math.max(maxSum, maxSumDP[i]);
                }
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[]arr={7,1,4,8,11,2,14,3};
        MaxSumIncreasingSubsequence maxSum=new MaxSumIncreasingSubsequence();
        System.out.println(maxSum.maxSumIncSubsequenceDP(arr));

    }
}
