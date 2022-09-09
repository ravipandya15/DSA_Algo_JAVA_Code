package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Integer_Break_343 {

    public static int solve(int num, int[] dp, int n)
    {
        // base case
        if (num == 1) return num;

        if (dp[num] != -1) return dp[num];

        int res = num;
        if (num == n)
        {
            res = 0;
        }
        int val = 0;
        for (int i = 1; i <= num/2; i++)
        {
            val = solve(i, dp, n) * solve(num - i, dp, n);
            res = Math.max(val, res);
        }
        return dp[num] = res;
    }

    //Memoization
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp, n);
    }

    //Tabulation
    public int integerBreak_1(int n) {
        int[] dp = new int[n + 1];
        // base case
        dp[1] = 1;

        for (int num = 2; num <= n; num++)
        {
            int res = num;
            if (num == n)
            {
                res = 0;
            }
            int val = 0;
            for (int i = 1; i <= num/2; i++)
            {
                val = dp[i] * dp[num - i];
                res = Math.max(val, res);
            }
            dp[num] = res;
        }


        return dp[n];
    }
}
