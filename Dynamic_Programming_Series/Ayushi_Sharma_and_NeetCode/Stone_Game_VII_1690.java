package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Stone_Game_VII_1690 {

    public static int solve(int s, int e, int sum, int[] stones, int[][] dp)
    {
        // base case
        if (s >= e) return 0;

        if (dp[s][e] != -1) return dp[s][e];

        int left = (sum - stones[s]) - solve(s+1, e, sum - stones[s], stones, dp);
        int right = (sum - stones[e]) - solve(s, e-1, sum - stones[e], stones, dp);
        return dp[s][e] = Math.max(left, right);
    }

    // memoization
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        int sum = 0;
        for (int x : stones) sum += x;
        return solve(0, n-1, sum, stones, dp);
    }

    // here tabulation has more time complexity than memoization -> based con leetcode TC
    // my understanding is everytime I need to calculate sum -> that's the main reson
    // tabulation
    public int stoneGameVII_1(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];

        // base case
        // for (int s = 0; s < n; s++)
        // {
        //     for (int e = 0; e < n; e++)
        //     {
        //         if (s >= e) dp[s][e] = 0;
        //     }
        // }

        for (int s = n-1; s >= 0; s--)
        {
            for (int e = 0; e < n; e++)
            {
                if (s < e)
                {
                    int sum = 0;
                    for (int i = s; i <= e; i++) sum += stones[i];

                    int left = 0, right = 0;
                    if (s + 1 < n) left = (sum - stones[s]) - dp[s+1][e];
                    if (e - 1 >= 0) right = (sum - stones[e]) - dp[s][e-1];
                    dp[s][e] = Math.max(left, right);
                }
            }
        }

        return dp[0][n-1];
    }

    public int stoneGameVII_2(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += stones[i];
        int[][][] dp = new int[n][n][sum + 1];

        for (int s = n-1; s >= 0; s--)
        {
            for (int e = 0; e < n; e++)
            {
                for (int k = 0; k <= sum; k++)
                {
                    if (s < e)
                    {    
                        int left = 0, right = 0;
                        if (s + 1 < n && k - stones[s] >= 0) left = (sum - stones[s]) - dp[s+1][e][k - stones[s]];
                        if (e - 1 >= 0 && k - stones[e] >= 0) right = (sum - stones[e]) - dp[s][e-1][k - stones[e]];
                        dp[s][e][k] = Math.max(left, right);
                    }
                }
            }
        }

        return dp[0][n-1][sum];
    }
}
