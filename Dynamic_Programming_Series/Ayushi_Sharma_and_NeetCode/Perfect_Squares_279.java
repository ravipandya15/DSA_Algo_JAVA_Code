package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Perfect_Squares_279 {
    public static int solve(int n, int[] dp)
    {
        // base case
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int ans = n;
        for (int i = 1; i < n; i++)
        {
            if ( i * i > n)
            {
                break;
            }
            ans = Math.min(ans, 1 + solve(n - i * i, dp));
        }
        return dp[n] = ans;
    }

    //Memoization
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    //Tabulation
    public int numSquares_1(int n) {
        int[] dp = new int[n + 1];

        for (int j = 0; j <= n; j++)
        {
            int ans = j;
            for (int i = 1; i < j; i++)
            {
                if ( i * i > j)
                {
                    break;
                }
                ans = Math.min(ans, 1 + dp[j - i * i]);
            }
            dp[j] = ans;
        }
        return dp[n];
    }
}
