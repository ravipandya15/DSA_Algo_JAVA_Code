package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Jump_Game_II_45 {

    public static int solve(int index, int[] nums)
    {
        if (index >= nums.length - 1)
        {
            return 0;
        }

        int jumps = 1000;
        for (int i = 1; i <= nums[index]; i++)
        {
            jumps = Math.min(jumps, solve(index + i, nums) + 1);
        }

        return jumps;
    }

    public int jump(int[] nums) {
        return solve(0, nums);
    }

    public static int solve_1(int index, int[] nums, int[] dp)
    {
        if (index >= nums.length - 1)
        {
            return 0;
        }

        if (dp[index] != -1) return dp[index];

        int jumps = 10000;
        for (int i = 1; i <= nums[index]; i++)
        {
            jumps = Math.min(jumps, solve_1(index + i, nums, dp) + 1);
        }

        return dp[index] = jumps;
    }

    public int jump_1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve_1(0, nums, dp);
    }

    public int jump_2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 0;

        for (int index = n-2; index >= 0; index--)
        {
            int jumps = 10000;
            for (int i = 1; i <= nums[index]; i++)
            {
                if (index + i < n)
                {
                    jumps = Math.min(jumps, dp[index + i] + 1);
                }
            }

            dp[index] = jumps;
        }

        return dp[0];
    }
}
