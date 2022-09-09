package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Minimum_Number_of_Days_to_Eat_N_Oranges_1553 {

    public static int solve(int n, Map<Integer, Integer> dp)
    {
        if (dp.containsKey(n))
        {
            return dp.get(n);
        }
        int one = 1 + (n % 2) + solve(n / 2, dp);
        int two = 1 + (n % 3) + solve(n / 3, dp);
        dp.put(n, Math.min(one, two));
        return dp.get(n);
    }

    // Memoization
    // TC -> 2 * O(LogN) by 2
    public int minDays(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        return solve(n, dp);
    }

    public static int solve_1(int n, int[] dp)
    {
        if (n == 0 || n == 1) return n;

        if (dp[n] != -1) return dp[n];

        int one = 1 + (n % 2) + solve_1(n / 2, dp);
        int two = 1 + (n % 3) + solve_1(n / 3, dp);
        dp[n] = Math.min(one, two);
        return dp[n];
    }
    
    public int minDays_1(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve_1(n, dp);
    }

    // Tabulation
    // TC -> 2 * O(LogN) by 2
    public int minDays_2(int n) {
        int[] dp = new int[n+1];

        // base case
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            int one = i, two = i;
            one = 1 + (i % 2) + dp[i/2];

            if (i >= 3)
            {
                two = 1 + (i % 3) + dp[i/3];
            }
            dp[i] = Math.min(one, two);
        }
        return dp[n];
    }
}