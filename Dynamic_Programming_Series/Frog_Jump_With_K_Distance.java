package Dynamic_Programming_Series;

import java.util.Arrays;
public class Frog_Jump_With_K_Distance {
    public static void main(String[] args) {
        
    }

    public static int solve1(int index, int[] heights, int k)
    {
        // base case
        if (index == 0) return 0;

        // int left = solve1(index - 1, heights) + Math.abs(heights[index] - heights[index - 1]);
        // int right = Integer.MAX_VALUE;
        // if (index > 1) right = solve1(index - 2, heights) + Math.abs(heights[index] - heights[index - 2]);

        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++)
        {
            if (index - j >= 0)
            {
                int jump = solve1(index - j, heights, k) + Math.abs(heights[index] - heights[index - j]);
                minSteps = Math.min(minSteps, jump);
            }
        }

        return minSteps;
    }

    // recursion
    public static int frogJump1(int n, int heights[], int k) {
        return solve1(n-1, heights, k);
    }

    public static int solve(int index, int[] heights, int[] dp, int k)
    {
        // base case
        if (index == 0) return 0;

        if (dp[index] != -1) return dp[index];

        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++)
        {
            if (index - j >= 0)
            {
                int jump = solve1(index - j, heights, k) + Math.abs(heights[index] - heights[index - j]);
                minSteps = Math.min(minSteps, jump);
            }
        }

        return dp[index] = minSteps;
    }

    // memoization
    // TC -> O(N)
    // SC -> O(N) + O(N)
    public static int frogJump2(int n, int heights[], int k) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n-1, heights, dp, k);
    }

    //tabulation
    // TC -> O(N)
    // SC -> O(N)
    public static int frogJump3(int n, int heights[], int k) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++)
        {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++)
            {
                if (i - j >= 0)
                {
                    int jump = dp[i-j] + Math.abs(heights[i] - heights[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }

            dp[i] = minSteps;
        }
        return dp[n-1];
    }
}
