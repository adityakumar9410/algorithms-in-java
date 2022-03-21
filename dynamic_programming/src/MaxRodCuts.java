
import java.util.Arrays;
public class MaxRodCuts {
    //TYPE 1 : Given a rod of length n, cut the rod in such that each piece is either a or b or c  , that gives max cuts
   // Method 1: TC:O(3^n) || SC:O(1)
    public static int findMaxCuts(int n, int a, int b, int c){
        if (n<0)
            return Integer.MIN_VALUE;
        if (n==0)
            return 0;
        return 1+Math.max(findMaxCuts(n-a,a,b,c),Math.max(findMaxCuts(n-b,a,b,c),findMaxCuts(n-c,a,b,c)));

    }

    //Method 2: DP  TC:O(N) || SC:O(N)
    public static int findMaxCutsDP_BU(int n, int a, int b, int c){
        int[]dp=new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=0;
        for (int i=1;i<=n;i++){
            if (i-a>=0 && dp[i]<1+dp[i-a])
                dp[i]=1+dp[i-a];
            if (i-b>=0 && dp[i]<1+dp[i-b])
                dp[i]=1+dp[i-b];
            if (i-c>=0 && dp[i]<1+dp[i-c])
                dp[i]=1+dp[i-c];
        }
        return dp[n];
    }
    public static int findMaxCutsDP_BU2(int n, int a, int b, int c){
        int[]dp=new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=0;
        for (int i=1;i<=n;i++){
            if (i-a>=0 )
                dp[i]=Math.max(dp[i], 1+dp[i-a]);
            if (i-b>=0 )
                dp[i]=Math.max(dp[i], 1+dp[i-b]);
            if (i-c>=0 )
                dp[i]=Math.max(dp[i], 1+dp[i-c]);
        }
        return dp[n];
    }

    public static void main(String[] args)  {
        int result= findMaxCutsDP_BU(25,11,12,13);
        System.out.println(result);
        System.out.println(findMaxCutsDP_BU2(25,11,12,13));
    }
}
