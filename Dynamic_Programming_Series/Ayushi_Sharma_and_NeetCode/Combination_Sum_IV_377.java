package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Combination_Sum_IV_377 {

    // can also be done with index and target 
    // 2D dp
    public static int solve(int target, int[] nums, int n, int[] dp)
    {
        // base case
        if (target == 0) return 1;

        if (dp[target] != -1) return dp[target];

        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] <= target)
            {
                count += solve(target - nums[i], nums, n, dp);
            }
        }
        return dp[target] = count;
    }

    // memoization
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return solve(target, nums, n, dp);
    }

    // Tabulation
    public int combinationSum4_1(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];

        // base case
        dp[0] = 1;
        for (int t = 1; t <= target; t++)
        {
            int count = 0;
            for (int i = 0; i < n; i++)
            {
                if (nums[i] <= t)
                {
                    count += dp[t - nums[i]];
                }
            }
            dp[t] = count;
        }
        return dp[target];
    }
}
