package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Number_of_Ways_to_Rearrange_Sticks_With_K_Sticks_Visible_1866 {

    public static int solve(int n, int k, int[][] dp)
    {
        int mod = (int)1e9 + 7;
        if (n == k) return 1;
        if (n == 0 || k == 0) return 0;

        if (dp[n][k] != -1) return dp[n][k];

        dp[n][k] = (int)((1L * solve(n-1, k-1, dp) + (n-1) * (1L * solve(n-1, k, dp))) % mod);
        return dp[n][k];
    }

    // Memoization
    public int rearrangeSticks(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(n, k, dp);
    }



    // NOT WORKING - TABULATION




    //tabulation
    public int rearrangeSticks_1(int n, int k) {
        int mod = (int)1e9 + 7;
        long[][] dp = new long[n+1][k+1];

        // base case
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= k; j++)
            {
                if (i == j) dp[i][j] = 1;
            }
        }

        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= k; j++)
            {
                if (i == 0 || j == 0) continue;
                dp[i][j] = (dp[i-1][j-1] % mod) + ((i-1) * dp[i-1][j] % mod) % mod;
            }
        }
        return (int)dp[n][k];
    }
}
