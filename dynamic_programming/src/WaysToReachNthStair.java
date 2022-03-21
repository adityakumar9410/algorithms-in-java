public class WaysToReachNthStair {
    //Find total number of ways to reach nth stair using steps 1,2,3.
    //TC:O(n) || SC:O(n)   Top Down
    public int waysToReachNthStair(int n){
        int[]dp=new int[n+1];
        return waysToReachNthStair(dp, n);
    }
    private int waysToReachNthStair(int[] dp, int n) {
        if (n==0||n==1)
            return 1;
        if (n==2)
            return 2;  // {1,1}, {2}
        if(dp[n]==0){
            int ways1=waysToReachNthStair(dp,n-1);
            int ways2=waysToReachNthStair(dp,n-2);
            int ways3=waysToReachNthStair(dp,n-3);
            dp[n]=ways1+ways2+ways3;
        }
        return dp[n];
    }
    //Bottom up
    public int waysToReachNthStairBU(int n){
        int[]dp=new int[n+1];
        dp[0]=dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];

        return dp[n];
    }
    public static void main(String[] args) {
        WaysToReachNthStair  numWays=new WaysToReachNthStair();
        System.out.println(numWays.waysToReachNthStair(5));
        System.out.println(numWays.waysToReachNthStairBU(5));
    }
}
