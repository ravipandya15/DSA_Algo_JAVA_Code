package Dynamic_Programming_Series;

import java.util.Arrays;

public class CN_Minimum_Elements {

    // Minimum Coins

    public static int solve(int index, int T, int[] num)
    {
        // base case
        if (index == 0)
        {
            if (T % num[0] == 0) return T / num[0];
            return (int)1e9;
        }

        int notTake = 0 + solve(index - 1, T, num);
        int take = Integer.MAX_VALUE;
        if (num[index] <= T) take = 1 + solve(index, T - num[index], num);

        return Math.min(notTake, take);
    }

    // Recursion
    // TC -> >> O(2^N) -> Exponential
    // SC -> >> O(N) -> if min. coin is of 1 then O(Target)
    public static int minimumElements1(int num[], int x) {
        int n = num.length;
        int ans = solve(n-1, x, num);
        if (ans >= 1e9) return -1;
        return ans;
    }

    public static int solve1(int index, int T, int[] num, int[][] dp)
    {
        // base case
        if (index == 0)
        {
            if (T % num[0] == 0) return T / num[0];
            return (int)1e9;
        }

        if (dp[index][T] != -1) return dp[index][T];

        int notTake = 0 + solve1(index - 1, T, num, dp);
        int take = Integer.MAX_VALUE;
        if (num[index] <= T) take = 1 + solve1(index, T - num[index], num, dp);

        return dp[index][T] = Math.min(notTake, take);
    }

    // Memoization
    // TC -> >> O(n * x)
    // SC -> >> O(n * x) + O(N)
    public static int minimumElements2(int num[], int x) {
        int n = num.length;
        int[][] dp = new int[n][x+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int ans = solve1(n-1, x, num, dp);
        if (ans >= 1e9) return -1;
        return ans;
    }

    // Tabulation
    // TC -> >> O(n * x)
    // SC -> >> O(n * x)
    public static int minimumElements3(int num[], int x) {
        int n = num.length;
        int[][] dp = new int[n][x+1];

        // base case
        for (int T = 0; T <= x; T++)
        {
            if (T % num[0] == 0) dp[0][T] = T / num[0];
            else dp[0][T] = (int)1e9;
        }

        for (int index = 1; index < n; index++)
        {
            for (int T = 0; T <= x; T++)
            {
                int notTake = 0 + dp[index - 1][T];
                int take = Integer.MAX_VALUE;
                if (num[index] <= T) take = 1 + dp[index][T - num[index]];

                dp[index][T] = Math.min(notTake, take);
            }
        }

        int ans = dp[n-1][x];
        if (ans >= 1e9) return -1;
        return ans;
    }

    // Space Optimization
    // TC -> >> O(n * x)
    // SC -> >> O(x)
    public static int minimumElements4(int num[], int x) {
        int n = num.length;
        int[] prev = new int[x+1];

        // base case
        for (int T = 0; T <= x; T++)
        {
            if (T % num[0] == 0) prev[T] = T / num[0];
            else prev[T] = (int)1e9;
        }

        for (int index = 1; index < n; index++)
        {
            int[] cur = new int[x+1];
            for (int T = 0; T <= x; T++)
            {
                int notTake = 0 + prev[T];
                int take = Integer.MAX_VALUE;
                if (num[index] <= T) take = 1 + cur[T - num[index]];

                cur[T] = Math.min(notTake, take);
            }
            prev = cur;
        }

        int ans = prev[x];
        if (ans >= 1e9) return -1;
        return ans;
    }
}
