package Dynamic_Programming_Series;

import java.util.ArrayList;
import java.util.Arrays;

public class CN_Maximum_sum_of_non_adjacent_elements {
    
    public static int solve(int index, ArrayList<Integer> nums)
    {
        if (index == 0)
        {
            return nums.get(index);
        }
        if (index < 0)
        {
            return 0;
        }

        // pick
        int pick = nums.get(index) + solve(index - 2, nums);
        // non pick 
        int not_pick = solve(index - 1, nums);

        return Math.max(pick, not_pick);
    }

    // Recursion
    // TC -> O(2^n)
    // SC -> O(N)
    public static int maximumNonAdjacentSum1(ArrayList<Integer> nums) {
		// Write your code here.
        int n = nums.size();
        return solve(n-1, nums);
	}

    public static int solve1(int index, ArrayList<Integer> nums, int[] dp)
    {
        if (index == 0) return nums.get(index);
        if (index < 0) return 0;

        if (dp[index] != -1) return dp[index];

        // pick
        int pick = nums.get(index) + solve1(index - 2, nums, dp);
        // non pick 
        int not_pick = solve1(index - 1, nums, dp);

        return dp[index] = Math.max(pick, not_pick);
    }
    
    // Memoization
    // TC -> O(N)
    // SC -> O(N) + O(N)
    public static int maximumNonAdjacentSum2(ArrayList<Integer> nums) {
		// Write your code here.
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve1(n-1, nums, dp);
	}

    // tabulation
    // TC -> O(N)
    // SC -> O(N)
    public static int maximumNonAdjacentSum3(ArrayList<Integer> nums) {
		// Write your code here.
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums.get(0);

        for (int i = 1; i < n; i++)
        {
            int pick = nums.get(i);
            if (i -2 >= 0) pick += dp[i-2];

            int not_pick = dp[i - 1];

            dp[i] = Math.max(pick, not_pick);
        }

        return dp[n-1];
	}

    // space optimization
    // TC -> O(N)
    // SC -> O(1)
    public static int maximumNonAdjacentSum4(ArrayList<Integer> nums) {
		// Write your code here.
        int n = nums.size();
        int prev2 = 0;
        int prev = nums.get(0);

        for (int i = 1; i < n; i++)
        {
            int pick = nums.get(i);
            if (i -2 >= 0) pick += prev2;

            int not_pick = prev;

            int curi = Math.max(pick, not_pick);

            prev2 = prev;
            prev = curi;
        }

        return prev;
	}
    
}
