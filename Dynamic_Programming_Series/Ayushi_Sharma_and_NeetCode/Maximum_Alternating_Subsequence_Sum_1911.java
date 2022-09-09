package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Maximum_Alternating_Subsequence_Sum_1911 {

    public static int solve(int ind, boolean flag, int[] nums, int n)
    {
        if (ind == n) return 0;

        //pick
        int pick = flag == true ? nums[ind] : -1 * nums[ind];
        pick += solve(ind + 1, !flag, nums, n);

        // non pick
        int notpick = solve(ind + 1, flag, nums, n);

        return Math.max(pick, notpick);
    }
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        return solve(0, true, nums, n);
    }


    public static long solve_1(int ind, int flag, int[] nums, int n, long[][] dp)
    {
        if (ind == n) return 0;

        if (dp[ind][flag] != -1) return dp[ind][flag];
        //pick
        long pick = (flag == 1) ? nums[ind] : -1 * nums[ind];
        pick += solve_1(ind + 1, 1 - flag, nums, n, dp);

        // non pick
        long notpick = solve_1(ind + 1, flag, nums, n, dp);

        return dp[ind][flag] = Math.max(pick, notpick);
    }
    public long maxAlternatingSum_1(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        for (long[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return solve_1(0, 1, nums, n, dp);
    }

    //tabulation
    public long maxAlternatingSum_2(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];

        for (int ind = n-1; ind >= 0; ind--)
        {
            for (int flag = 0; flag < 2; flag++)
            {
                //pick
                long pick = (flag == 1) ? nums[ind] : -1 * nums[ind];
                pick += dp[ind + 1][1 - flag];

                // non pick
                long notpick = dp[ind + 1][flag];

                dp[ind][flag] = Math.max(pick, notpick);
            }
        }
        return dp[0][1];
    }
}
