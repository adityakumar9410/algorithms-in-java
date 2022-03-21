public class MinJumpsToReachNthStair {
    //Find min step required to reach Nth stair using 1,2,3 steps
    //Top down   TC:O(n) ||
    public int minStepTD(int n){
        int[]dp=new int[n+1];
        return minStepTD(dp, n);
    }
    private int minStepTD(int[] dp, int n) {
        if (n==0)
            return 0;
        if (n==1||n==2||n==3)
            return 1;
        if (dp[n]==0) {
            int minStep1=minStepTD(n - 1);
            int minStep2=minStepTD(n - 2);
            int minStep3=minStepTD(n - 3);
            dp[n] = 1+ Math.min(minStep1, Math.min(minStep2, minStep3 ));
        }
        return dp[n];
    }

    //Bottom up
    public int minStepsBU(int n){
        int []dp=new int[n+1];
        dp[0]=0;
        dp[1]=dp[2]=dp[3]=1;
        for (int i=4;i<=n;i++)
            dp[i]=1+Math.min(dp[i-1], Math.min(dp[i-2],dp[i-3]));
        return dp[n];
    }

    public static void main(String[] args) {
        MinJumpsToReachNthStair  minSteps=new MinJumpsToReachNthStair();
        System.out.println(minSteps.minStepsBU(500));
    }
}
