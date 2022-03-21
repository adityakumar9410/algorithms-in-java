public class MaxStockProfit {
    /*Say you have an array prices for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit.
     Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
   Input: [7,1,5,3,6,4]
   Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
                             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.*/

    //Type 1:
    //You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
    //TC :O(n^n)  || SC:O(n)
    public static int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    private static int calculate(int[] prices, int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }

    //TC:O(n) || SC:O(1)
    public static int maxProfit2(int[] prices) {
        int i = 0;
        int valley;
        int peak;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    //TC:O(N) || SC:O(1)
    public static int maxProfit3(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    //Type 2:
    // you are only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock)
    //TC:O(n^2) ||SC:O(1)
    public static int maxProfitT2M1(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++)
                maxprofit = Math.max(maxprofit, prices[j] - prices[i]);
        }

        return maxprofit;
    }

    //TC:O(n) || SC:O(1)
    public static int maxProfitT2M2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int[] prices = {5, 11, 3, 50, 60, 90};
        /*System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));*/

        System.out.println(maxProfitT2M1(prices));
        System.out.println(maxProfitT2M2(prices));
    }
}
