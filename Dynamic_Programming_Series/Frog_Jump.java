package Dynamic_Programming_Series;

import java.util.Arrays;

public class Frog_Jump {
    
    public static void main(String[] args) {
        
    }

    public static int solve1(int index, int[] heights)
    {
        // base case
        if (index == 0) return 0;

        int left = solve1(index - 1, heights) + Math.abs(heights[index] - heights[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) right = solve1(index - 2, heights) + Math.abs(heights[index] - heights[index - 2]);

        return Math.min(left, right);
    }

    // recursion
    public static int frogJump1(int n, int heights[]) {
        return solve1(n-1, heights);
    }

    public static int solve(int index, int[] heights, int[] dp)
    {
        // base case
        if (index == 0) return 0;

        if (dp[index] != -1) return dp[index];

        int left = solve(index - 1, heights, dp) + Math.abs(heights[index] - heights[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) right = solve(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2]);

        return dp[index] = Math.min(left, right);
    }

    // memoization
    // TC -> O(N)
    // SC -> O(N) + O(N)
    public static int frogJump2(int n, int heights[]) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n-1, heights, dp);
    }

    //tabulation
    // TC -> O(N)
    // SC -> O(N)
    public static int frogJump3(int n, int heights[]) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++)
        {
            int left = dp[i-1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) right = dp[i-2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }

    // space optimazation
    public static int frogJump4(int n, int heights[]) {
        
        int prev = 0, prev2 = 0;

        for (int i = 1; i < n; i++)
        {
            int left = prev + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) right = prev2 + Math.abs(heights[i] - heights[i - 2]);

            int curi = Math.min(left, right);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}
