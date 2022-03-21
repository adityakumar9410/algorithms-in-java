import java.util.Arrays;
public class CoinChange {
    //Given a value V , find min coin required to make changes . coins=[1,2,5,10,20]
    //TC:O(nlogN)
    public static int findMinCoinForChange(int[] coins, int value){
        Arrays.sort(coins);
        int index=coins.length-1;
        int minCoins=0;
        while (true){
            int coinValue=coins[index];
            index--;
            minCoins+=value/coinValue;
            int amountChangedByCurrentCoin=(value/coinValue)*coinValue;
            if (amountChangedByCurrentCoin>0)
                value-=amountChangedByCurrentCoin;
            if (value==0)
                return minCoins;
        }
    }
    public static void main(String[] args) {
        int[]coins={1,2,5,10,20,50,100};
        System.out.println(findMinCoinForChange(coins,121));
    }
}
