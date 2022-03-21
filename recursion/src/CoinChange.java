import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    //Given a target value and a list of coins . find min number of coin required for change

    public static int findMinCoin(int target, List<Integer> coins) {
        int minCoin = target;
        for (Integer num : coins) {
            if (target == num)
                return 1;
        }

        //Create a new list of coins whose values are less than equal to target
        List<Integer> myCoins = new ArrayList<>();
        for (Integer c : coins) {
            if (c <= target)
                myCoins.add(c);
        }

        for (Integer i : myCoins) {
            int numCoin = 1 + findMinCoin(target - i, coins);

            if (numCoin < minCoin)
                minCoin = numCoin;
        }
        return minCoin;
    }

    public static void main(String[] args) {
        System.out.println(findMinCoin(5, Arrays.asList(1,5,10)));
    }
}
