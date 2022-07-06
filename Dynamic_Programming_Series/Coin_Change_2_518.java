package Dynamic_Programming_Series;

import java.util.Arrays;

public class Coin_Change_2_518 {

    public static int solve(int index, int amount, int[] coins)
    {
        // base case
        if (index == 0)
        {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }
        int notTake = solve(index - 1, amount, coins);
        int take = 0;
        if (amount >= coins[index])
        {
            take = solve(index, amount - coins[index], coins);
        }
        return take + notTake;
    }
    public int Change(int amount, int[] coins) {
        int n = coins.length;
        return solve(n-1, amount, coins);
    }

    public static int solve_1(int index, int amount, int[] coins, int[][] dp)
    {
        // base case
        if (index == 0)
        {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }

        if (dp[index][amount] != -1) return dp[index][amount];

        int notTake = solve_1(index - 1, amount, coins, dp);
        int take = 0;
        if (amount >= coins[index])
        {
            take = solve_1(index, amount - coins[index], coins, dp);
        }
        return dp[index][amount] = take + notTake;
    }

    public int Change_2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return solve_1(n-1, amount, coins, dp);
    }


    // Tabulation
    // TC -> >> O(n * value)
    // SC -> >> O(n * value)
    public static int Change_3(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // base case
        for (int T = 0; T <= amount; T++)
        {
            if (T  % coins[0] == 0)
            {
                dp[0][T] = 1;
            }           
        }

        for (int index = 1; index < n; index++)
        {
            for (int T = 0; T <= amount; T++)
            {
                int notTake = dp[index-1][T];
                int take = 0;
                if (coins[index] <= T)
                    take = dp[index][T-coins[index]];

                dp[index][T] = notTake + take;
            }
        }

        return dp[n-1][amount];
	}

    // Space Optimization
    // TC -> >> O(n * value)
    // SC -> >> O(value)
    public static int Change_4(int coins[], int amount){
        int n = coins.length;
        int[] prev = new int[amount + 1];

        // base case
        for (int T = 0; T <= amount; T++)
        {
            if (T  % coins[0] == 0)
            {
                prev[T] = 1;
            }           
        }

        for (int index = 1; index < n; index++)
        {
            int[] cur = new int[amount + 1];
            for (int T = 0; T <= amount; T++)
            {
                int notTake = prev[T];
                int take = 0;
                if (coins[index] <= T)
                    take = cur[T-coins[index]];

                cur[T] = notTake + take;
            }
            prev = cur;
        }

        return prev[amount];
	}
}
