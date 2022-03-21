public class NumberFactor {
    //Find number of ways in which num n can be represented as a factor of n
    //Top Down TC : O(n) || SC : O(n)
    public int waysToGetN(int n) {
        int[] dp = new int[n + 1];
        return waysToGetN_TopDown(dp, n);
    }
    public int waysToGetN_TopDown(int[] dp, int n) {
        if ((n == 0) || (n == 1) || (n == 2)) // { }, {1}, {1,1}
            return 1;
        if (n == 3)
            return 2; // {1,1,1}, {3}
        if (dp[n] == 0) {
            int subtract1 = waysToGetN_TopDown(dp, n - 1);// if we subtract 1, we will be left with 'n-1'
            int subtract3 = waysToGetN_TopDown(dp, n - 3);// if we subtract 3, we will be left with 'n-3'
            int subtract4 = waysToGetN_TopDown(dp, n - 4);// if we subtract 4, we will be left with 'n-4'

            dp[n] = subtract1 + subtract3 + subtract4;
        }
        return dp[n];
    }

    //Bottom up
    public int waysToGetN_Bottom_Up(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = dp[2] = 1; // BaseCases
        dp[3] = 2; // BaseCases

        for (int i = 4; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];

        return dp[n];
    }
    public static void main(String[] args) {
        NumberFactor en = new NumberFactor();
        System.out.println(en.waysToGetN(6));
        System.out.println(en.waysToGetN_Bottom_Up(6));
    }

}
