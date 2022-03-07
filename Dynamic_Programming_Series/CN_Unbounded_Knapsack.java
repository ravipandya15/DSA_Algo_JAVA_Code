package Dynamic_Programming_Series;

import java.util.Arrays;

public class CN_Unbounded_Knapsack {
    
    

    // don't confise between w and W for tabulation, space optimization and Single arrat space optimization
    // w is total weight
    // W is variable



    public static int solve(int index, int w, int[] profit, int[] weight)
    {
        // base case
        if (index == 0)
        {
            return ((int)(w/weight[0])) * profit[0];
        }

        int notTake = 0 + solve(index-1, w, profit, weight);
        int take = Integer.MIN_VALUE;
        if (weight[index] <= w)
        {
            take = profit[index] + solve(index, w - weight[index], profit, weight);
        }

        return Math.max(notTake, take);
    }

    // Recursion
    // TC -> exponential
    // SC -> O(w)
    public static int unboundedKnapsack1(int n, int w, int[] profit, int[] weight) {
        return solve(n-1, w, profit, weight);
    }

    public static int solve1(int index, int w, int[] profit, int[] weight, int[][] dp)
    {
        // base case
        if (index == 0)
        {
            return ((int)(w/weight[0])) * profit[0];
        }

        if (dp[index][w] != -1) return dp[index][w];

        int notTake = 0 + solve1(index-1, w, profit, weight, dp);
        int take = Integer.MIN_VALUE;
        if (weight[index] <= w)
        {
            take = profit[index] + solve1(index, w - weight[index], profit, weight, dp);
        }

        return dp[index][w] = Math.max(notTake, take);
    }

    // Memoization
    // TC -> O(N * W)
    // SC -> O(N * W) + O(N)
    public static int unboundedKnapsack2(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for (int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return solve1(n-1, w, profit, weight, dp);
    }

    // Tabulation
    // TC -> O(N * W)
    // SC -> O(N * W)
    public static int unboundedKnapsack3(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];

        // base case
        for(int W = 0; W <= w; W++)
        {
            dp[0][W] = ((int)(W/weight[0])) * profit[0];
        }

        for (int index = 1; index < n; index++)
        {
            for (int W = 0; W <= w; W++)
            {
                int notTake = 0 + dp[index-1][W];
                int take = Integer.MIN_VALUE;
                if (weight[index] <= W)
                {
                    take = profit[index] + dp[index][W - weight[index]]; // W is variable for loop wala not w-> total capacity
                }

                dp[index][W] = Math.max(notTake, take);
            }
        }

        return dp[n-1][w];
    }

    // Space optimization
    // TC -> O(N * W)
    // SC -> O(W)
    public static int unboundedKnapsack4(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w+1];

        // base case
        for(int W = 0; W <= w; W++)
        {
            prev[W] = ((int)(W/weight[0])) * profit[0];
        }

        for (int index = 1; index < n; index++)
        {
            int[] cur = new int[w+1];
            for (int W = 0; W <= w; W++)
            {
                int notTake = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if (weight[index] <= W)
                {
                    take = profit[index] + cur[W - weight[index]]; // W is variable for loop wala not w-> total capacity
                }

                cur[W] = Math.max(notTake, take);
            }
            prev = cur;
        }

        return prev[w];
    }

    // Single Array Space optimized
    // TC -> O(N * W)
    // SC -> O(W)
    public static int unboundedKnapsack5(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w+1];

        // base case
        for(int W = 0; W <= w; W++)
        {
            prev[W] = ((int)(W/weight[0])) * profit[0];
        }

        for (int index = 1; index < n; index++)
        {
            for (int W = 0; W <= w; W++)
            {
                int notTake = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if (weight[index] <= W)
                {
                    take = profit[index] + prev[W - weight[index]]; // W is variable for loop wala not w-> total capacity
                }

                prev[W] = Math.max(notTake, take);
            }
        }

        return prev[w];
    }
}
