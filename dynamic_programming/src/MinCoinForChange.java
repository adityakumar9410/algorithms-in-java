import java.util.Arrays;

public class MinCoinForChange {
    //Given a target amount  and denominations , find the min coin required for change
    //TC:O(n*d)  || SC:O(n)
    public static int findMinNumberOfCoinForChange(int target, int[] denoms){
        int[] numOfCoins=new int[target+1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0]=0;
        int toCompare;
        for (int denom:denoms){
            for (int amount=1;amount<numOfCoins.length;amount++)
                if (denom<=amount) {
                    if (numOfCoins[amount-denom]==Integer.MAX_VALUE)
                        toCompare=numOfCoins[amount-denom];
                    else
                        toCompare=1+numOfCoins[amount-denom];
                    numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
                }
        }
        return numOfCoins[target]!=Integer.MAX_VALUE?numOfCoins[target]:-1;
    }
    public static void main(String[] args) {
        int[]demoms={4,2,1};
        System.out.println(findMinNumberOfCoinForChange(6,demoms));
    }
}
