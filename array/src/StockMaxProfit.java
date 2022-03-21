public class StockMaxProfit {
    //Trader can buy and sell only one stock in whole given days
    /*Method 1: Brute Force  T.C :O(n^2)  || S.C : O(1)
    We need to find out the maximum difference (which will be the maximum profit) between two numbers in the given array.
     Also, the second number (selling price) must be larger than the first one (buying price).
     In formal terms, we need to find max(prices[j]−prices[i]), for every i and j such that j >i.
*/
    public static int  maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
  //Method 2 :  T.C: O(n) || SC :O(1)
    public static int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice)
                minprice = price;
            else if (price - minprice > maxprofit)
                maxprofit = price - minprice;
        }
        return maxprofit;
    }


    public static void main(String[] args) {
        // int[] arr1 = {10, 5, 3};
        //  int[] arr2 = {1, 2, 5};
        int []arr={1,5,3,8,12};
        int[] arr3 = {7, 1, 5, 3, 6, 4};
        //System.out.println(findMaxProfit(arr1));
        //System.out.println(findMaxProfit(arr2));
        System.out.println(maxProfit(arr));
    }
}
