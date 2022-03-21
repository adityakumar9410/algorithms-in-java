public class MinCostClimbingStair {
    /*On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
    Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
     and you can either start from the step with index 0, or the step with index 1.*/
    //TC:O(N)
    public static int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length+1];

        minCost[0] = 0;
        minCost[1] = 0;

        for(int i = 2; i < minCost.length; i++) {
            minCost[i] = Math.min(minCost[i-1] + cost[i-1],
                    minCost[i-2] + cost[i-2]);
        }

        return minCost[cost.length];
    }

    public static void main(String[] args) {
        int[]cost={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
