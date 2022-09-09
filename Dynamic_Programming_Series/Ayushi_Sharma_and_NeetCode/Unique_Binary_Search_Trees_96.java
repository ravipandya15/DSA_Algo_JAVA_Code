package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Unique_Binary_Search_Trees_96 {

    public static int solve(int ind, int[] dp)
    {
        // base cases
        if (ind == 0 || ind == 1) return 1;

        if (dp[ind] != -1) return dp[ind];
        int count = 0;

        for (int i = 1; i <= ind; i++)
        {
            count += solve(i-1, dp) * solve(ind-i, dp);
        }

        //above one is better for tabulation

        // for (int i = 0; i < ind; i++)
        // {
        //     int left = i;
        //     int right = ind - 1 - left;
        //     count += solve(left, dp) * solve(right, dp);
        // }
        return dp[ind] = count;
    }

    // Memoization
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    // Tabulation
    public int numTrees_1(int n) {
        int[] dp = new int[n+1];

        // base case
        dp[0] = 1;
        dp[1] = 1;

        for (int ind = 2; ind <= n; ind++)
        {
            int count = 0;
            for (int i = 1; i <= ind; i++)
            {
                count += dp[i-1] * dp[ind-i];
            }
            dp[ind] = count;
        }
        return dp[n];
    }
}
