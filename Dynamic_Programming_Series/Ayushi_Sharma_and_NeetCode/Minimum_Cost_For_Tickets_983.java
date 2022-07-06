package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Minimum_Cost_For_Tickets_983 {

    public static int solve(int index, int n, int[] days, int[] cost)
    {
        // base case
        if (index >= n) return 0;

        int[] arr = new int[] {1, 7, 30};
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++)
        {
            int j = i;
            while (j < n && days[j] < days[index] + arr[i])
            {
                j++;
            }
            int tempAns = cost[i] + solve(j, n, days, cost);
            ans = Math.min(ans, tempAns);
        }
        return ans;
    }

    // recursion
    public int mincostTickets_1(int[] days, int[] costs) {
        int n = days.length;
        return solve(0, n, days, costs);
    }

    public static int solve_1(int index, int n, int[] days, int[] cost, int[] dp)
    {
        // base case
        if (index >= n) return 0;
        if (dp[index] != -1) return dp[index];

        int[] arr = new int[] {1, 7, 30};
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++)
        {
            int j = i;
            while (j < n && days[j] < days[index] + arr[i])
            {
                j++;
            }
            int tempAns = cost[i] + solve_1(j, n, days, cost, dp);
            ans = Math.min(ans, tempAns);
        }
        return dp[index] = ans;
    }

    // Memoization
    public int mincostTickets_2(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve_1(0, n, days, costs, dp);
    }

    // tabulation
    public int mincostTickets_3(int[] days, int[] costs) {
        int n = days.length;
        // why dp[n+2]?
        // Test case
        // days[] = {364}
        // costs[] = {3,3,1} was failing as int tempAns = costs[ii] + dp[j]; here for ii = 2, j = ii and dp[2] is out of bound
        int[] dp = new int[n+2];

        // base case
        dp[n] = 0;
        dp[n + 1] = 0;

        for (int i = n-1; i >= 0; i--)
        {
            int[] arr = new int[] {1, 7, 30};
            int ans = Integer.MAX_VALUE;

            for (int ii = 0; ii < 3; ii++)
            {
                int j = ii;
                while (j < n && days[j] < days[i] + arr[ii])
                {
                    j++;
                }
                int tempAns = costs[ii] + dp[j];
                ans = Math.min(ans, tempAns);
            }
            dp[i] = ans;
        }

        return dp[0];
    }
}
