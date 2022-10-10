package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Stone_Game_III_1406 {
    public static int solve(int index, int[] stones, int n, int[] dp)
    {
        // base case
        if (index >= n) return 0;

        if (dp[index] != -1) return dp[index];

        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, stones[index] - solve(index + 1, stones, n, dp));
        if (index + 1 < n) ans = Math.max(ans, stones[index] + stones[index + 1] - 
                                                            solve(index + 2, stones, n, dp));
        if (index + 2 < n) ans = Math.max(ans, stones[index] + stones[index + 1] + stones[index + 2] - 
                                                            solve(index + 3, stones, n, dp));

        return dp[index] = ans;
    }

    // Memoization
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = solve(0, stoneValue, n, dp);
        if (ans > 0) return "Alice";
        else if (ans < 0) return "Bob";
        else return "Tie";
    }

    // Tabulation
    public String stoneGameIII_2(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];

        // need to write DP instead of solve


        for (int index = n-1; index >= 0; index--)
        {
            int ans = Integer.MIN_VALUE;
            ans = Math.max(ans, stoneValue[index] - dp[index + 1]);
            if (index + 1 < n) ans = Math.max(ans, stoneValue[index] + stoneValue[index + 1] - 
                                                                dp[index + 2]);
            if (index + 2 < n) ans = Math.max(ans, stoneValue[index] + stoneValue[index + 1] + stoneValue[index + 2] - 
                                                                dp[index + 3]);

            dp[index] = ans;
        }

        int finalAns = dp[0];
        if (finalAns > 0) return "Alice";
        else if (finalAns < 0) return "Bob";
        else return "Tie";
    }
}
