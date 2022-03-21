import java.util.*;

public class ZeroOneKnapsack {
    //Top down
    public int knapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.knapsackAux(dp, profits, weights, capacity, 0);
    }

    private int knapsackAux(Integer[][] dp, int[] profits, int[] weights, int capacity, int currInd) {
        if (capacity <= 0 || currInd < 0 || currInd >= profits.length) //Base case
            return 0;

        if (dp[currInd][capacity] != null) // if we have already solved this problem, then return the result from memory
            return dp[currInd][capacity];

        int profit1 = 0;
        if (weights[currInd] <= capacity) // Taking current element
            profit1 = profits[currInd] + knapsackAux(dp, profits, weights, capacity - weights[currInd], currInd + 1);

        int profit2 = knapsackAux(dp, profits, weights, capacity, currInd + 1); // Not taking current element
        dp[currInd][capacity] = Math.max(profit1, profit2);
        return dp[currInd][capacity];
    }

    //Bottom up   TC:O(N*C)  || SC:O(N*C)
    public int solveKnapsackBU(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)  //Base case
            return 0;
        int numberOfRows = profits.length + 1;// adding a dummy row to avoid array index issues
        int[][] dp = new int[numberOfRows][capacity + 1];// Create a 2D Array to store all the results
        for (int i = 0; i < numberOfRows; i++) { // Insert 0 in 1st column as it is dummy column to avoid array index issues
            dp[i][0] = 0;
        }
        for (int i = 0; i <= capacity; i++) {// Insert 0 in last row as it is dummy column to avoid array index issues
            dp[numberOfRows - 1][i] = 0;
        }
        for (int row = numberOfRows - 2; row >= 0; row--) {
            for (int column = 1; column <= capacity; column++) {
                int profit1 = 0;
                if (weights[row] <= column) { // column represents current capacity
                    profit1 = profits[row] + dp[row + 1][column - weights[row]];  // Taking current element
                }
                int profit2 = dp[row + 1][column]; // Not taking current element
                dp[row][column] = Math.max(profit1, profit2);
            }
        }
        return dp[0][capacity];
    }

    //Bottom Up 2:
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] knapsackValues = new int[items.length + 1][capacity + 1];
        for (int i = 1; i < items.length + 1; i++) {
            int currentWeight = items[i - 1][1];  //second value of item array is weight
            int currentValue = items[i - 1][0];  //first value of item array is profit or value
            for (int c = 0; c < capacity + 1; c++) {
                if (currentWeight > c) {   //If weight of current item > current capacity then we don't include current item
                    knapsackValues[i][c] = knapsackValues[i - 1][c];   // Take value right above it
                } else {
                    knapsackValues[i][c] = Math.max(
                            knapsackValues[i - 1][c],
                            knapsackValues[i - 1][c - currentWeight] + currentValue);
                }
            }
        }
        return getKnapsackValues(knapsackValues, items, knapsackValues[items.length][capacity]);
    }

    private static List<List<Integer>> getKnapsackValues(int[][] knapsackValues, int[][] items, int maxLoot) {
        List<List<Integer>> sequence = new ArrayList<>();   //value at 1st idx will be total loot and value at 2nd idx is items seq.
        List<Integer> totalValue = new ArrayList<>();
        totalValue.add(maxLoot);
        sequence.add(totalValue);
        sequence.add(new ArrayList<>());  //List at second indices will contain indices of all included items
        int i = knapsackValues.length - 1;   //index of last row
        int c = knapsackValues[0].length - 1;  //index of last column
        while (i > 0) {
            if (knapsackValues[i][c] == knapsackValues[i - 1][c])
                i -= 1;      // We don't include current item ,if value right above this cell is same
            else {
                sequence.get(1).add(i - 1);  //we are adding indices of including items while backtracking
                c -= items[i - 1][1];  // since second element is weight in items
                i -= 1;
            }
            if (c == 0)
                break;
        }
        return sequence;
    }

    //gfg
    public static int knapsackProblem11(int[] weights, int[] values, int capacity) {
        int N = weights.length;
        int[][] knapsackValues = new int[N + 1][capacity + 1];
        for (int i = 1; i < N + 1; i++) {
            int currentValue = values[i - 1];
            int currentWeight= weights[i - 1];
            for (int c = 0; c < capacity + 1; c++) {
                if (currentWeight > c) {   //If weight of current item > current capacity then we don't include current item
                    knapsackValues[i][c] = knapsackValues[i - 1][c];   // Take value right above it
                } else {
                    knapsackValues[i][c] = Math.max(
                            knapsackValues[i - 1][c],
                            knapsackValues[i - 1][c - currentWeight] + currentValue);
                }
            }
        }
        return knapsackValues[N][capacity];
    }


    public static void main(String[] args) {
        ZeroOneKnapsack ks = new ZeroOneKnapsack();
        /*int[] profits = { 31, 26, 72, 17 };
        int[] weights = { 3, 1, 5, 2 };
        int[][]items={{31,3},{26,1},{72,5},{17,2}};
       *//* int maxProfit = ks.knapsack(profits, weights, 7);
        System.out.println(maxProfit);
        System.out.println(ks.solveKnapsackBU(profits,weights,7));*//*
        System.out.println(knapsackProblem(items, 7));*/
       /* Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int N=sc.nextInt();
            int W=sc.nextInt();
            int[]val=new int[N];
            for (int i=0;i<N;i++){
                val[i]=sc.nextInt();
            }
            int[]wt=new int[N];
            for (int i=0;i<N;i++){
                wt[i]=sc.nextInt();
            }

            System.out.println(knapsackProblem11(val,wt, N,W));
        }*/
    }
}
