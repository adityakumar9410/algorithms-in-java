public class RodCuttingMaxProfit {

    /*Given a rod of length n, and an array that contains the prices of all the pieces smaller than n,
     determine the maximum profit you could obtain from cutting up the rod and selling its pieces.
     Suppose that we have a rod of length 5, and an array containing the length(1,2,3 and 4 ) and price(2,5,7 and 8 ) of the pieces.*/

    //Method 1: Recursive TC:O(n^n) || SC:O(1)
    public static int findMaxPriceByCuttingRod(int[] prices, int n) {
        if (n <= 0)
            return 0;
        int max_val = Integer.MIN_VALUE;
        // Recursively cut the rod in different pieces and
        // compare different configurations
        for (int i = 0; i < n; i++)
            max_val = Math.max(max_val, prices[i] + findMaxPriceByCuttingRod(prices, n - i - 1));

        return max_val;
    }

    //Bottom UP DP TC:O() || SC:O(n)
    public static int findMaxPriceByCuttingRodDP_BU(int[] prices) {
        int n = prices.length;
        int[] maxProfit = new int[n + 1];
        maxProfit[0] = 0;

        // Built the table maxProfit[] in bottom up manner and return
        // the last entry from the table
        for (int length = 1; length <= n; length++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < length; j++)
                max_val = Math.max(max_val, prices[j] + maxProfit[length - j - 1]);
            maxProfit[length] = max_val;
        }
        return maxProfit[n];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " + findMaxPriceByCuttingRod(arr, size));
        System.out.println(findMaxPriceByCuttingRodDP_BU(arr));

    }

}
