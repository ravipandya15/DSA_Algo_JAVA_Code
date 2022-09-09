package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Arithmetic_Slices_413 {
    public static int solve(int index, int[] nums, int prev)
    {
        // base case
        if (index < 0) return 0;

        int count = 0;
        if (nums[index + 1] - nums[index] == nums[index + 2] - nums[index + 1])
        {
            count = prev + 1;
        }
        count += solve(index - 1, nums, count);
        return count;
    }
    
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n - 3, nums, 0);
    }
}
