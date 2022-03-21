public class MinCostToReachLastCell {
    //Top Down
    public int findMinCost(int[][] array, int row, int col) {
        int[][] dp = new int[row+1][col+1];
        return findMinCost_aux(dp, array, row, col);
    }
    public int findMinCost_aux(int[][] dp, int[][] array, int row, int col) {
        if (row == -1 || col == -1) { // BASE CASE
            return Integer.MAX_VALUE;
        }
        if (row == 0 && col == 0) { // BASE CASE: If we're at first cell (0, 0),then no need to recurse
            return array[0][0];
        }
        if(dp[row][col] == 0) {//If we have not solved this problem previously, only then solve it
            int minCost1 = findMinCost_aux(dp, array, row - 1, col);// Case#1: Get min cost if we go 'up' from current cell
            int minCost2 = findMinCost_aux(dp, array, row, col - 1);// Case#2: Get min cost if we go 'left' from current cell
            int minCost = Integer.min(minCost1, minCost2);
            int currentCellsCost = array[row][col];
            dp[row][col] = minCost + currentCellsCost;
        }
        return dp[row][col];
    }

    //Bottom Up
    public int findMinCostBU(int[][] grid, int row, int col) {
        int[][] dp = new int[row + 1][col + 1];//This 2D array will store all the results. This Array has 1 extra Row and 1 extra Col
        for(int i=0; i<=col; i++) {  //Initialize default value
            dp[0][i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<=row; i++) {  //Initialize default value
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][1] = 0; //This is done to make sure that first comparison goes through successfully
        for(int i=1; i<=row; i++) {
            for(int j=1; j<=col; j++) {
                dp[i][j] = Integer.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[row][col];
    }
    public static void main(String[] args) {
        int[][] array = {{ 4, 7, 8, 6, 4 }, { 6, 7, 3, 9, 2 }, { 3, 8, 1, 2, 4 }, { 7, 1, 7, 3, 7 }, { 2, 9, 8, 9, 3 }};
        MinCostToReachLastCell  mctrlc = new MinCostToReachLastCell();
        System.out.print("The minimum cost is " + mctrlc.findMinCostBU(array, array.length, array[0].length ));
    }
}
