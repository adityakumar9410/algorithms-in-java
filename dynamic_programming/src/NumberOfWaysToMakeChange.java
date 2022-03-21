public class NumberOfWaysToMakeChange {
    //Given an amount and denominations , find number of ways to make change
    //TC:O(n*d)  || SC:(n)
    public static int numberOfWaysToMakeChange(int n, int[]denoms){
        int[]ways=new int[n+1];
        ways[0]=1;
        for (int denom:denoms){
            for (int amount=1;amount<n+1;amount++){
                if (denom<=amount)
                    ways[amount]+=ways[amount-denom];
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        int[]denoms={1,5,10,25};
        System.out.println(numberOfWaysToMakeChange(10, denoms));
    }
}
