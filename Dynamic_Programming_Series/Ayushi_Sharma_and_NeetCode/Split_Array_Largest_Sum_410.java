package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Split_Array_Largest_Sum_410 {

    public boolean canSplit(int largest, int n, int[] nums, int m)
    {
        int curSum = 0;
        int subArray = 1;
        for (int i = 0; i < n; i++)
        {
            curSum += nums[i];
            if (curSum > largest)
            {
                subArray++;
                if (subArray > m) return false;
                curSum = nums[i];
                // subArray++;
                // curSum = nums[i];
            }
        }
        //return subArray <= m;
        return true;
    }

    // SOLUTION - 1
    // BINARY SEARCH - SAME LIKE BOOK ALLOCATION AND PAINTER'S PARTITION
    // TC -> O(Log(S))*O(N), where S is sum of nums array
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int l = 0, r = 0;
        for (int i = 0; i < n; i++)
        {
            l = Math.max(l, nums[i]);
            r += nums[i];
        }

        int ans = r;

        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            if (canSplit(mid, n, nums, m))
            {
                ans = mid;
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }

        return ans;
    }


    // SOLUTION - 2 - Actual DP problem
    // working fine
    // DP solution
    // can work it with Tabulation too
    // TC -> O(N * M) * O(N)
    // SC -> O(N * M) + O(N * M)
    public int splitArray_2(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve_1(0, m, nums, n, dp);
    }

    public static int solve_1(int start, int m, int[] nums, int n, int[][] dp)
    {
        // base case
        if (m == 1)
        {
            //return sum;
            int sum = 0;
            for (int i = start; i < n; i++)
            {
                sum += nums[i];
            }
            return sum;
        }

        if (dp[start][m] != -1) return dp[start][m];
        int left = 0;
        int mini = Integer.MAX_VALUE;
        for (int i = start; i < n - 1; i++)
        {
            left += nums[i];
            int right = solve_1(i + 1, m - 1, nums, n, dp);
            int largest = Math.max(left, right);
            mini = Math.min(mini, largest);
        }
        return dp[start][m] = mini;
    }

    // SOLUTION - 3 - my own logic (working fine)
    // DP solution
    // can work it with Memoization and Tabulation
    public int splitArray_1(int[] nums, int m) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            sum += nums[i];
        }
        if (m == 1) return sum;
        int[][][] dp = new int[n+1][m+1][sum+1];
        for (int[][] i : dp)
        {
            for (int[] row : i) Arrays.fill(row, -1);
        }
        return solve(0, sum, m, nums, n, dp);
    }

    public static int solve(int start, int sum, int m, int[] nums, int n, int[][][] dp)
    {
        // base case
        if (m == 1)
        {
            return sum;
        }

        if (dp[start][m][sum] != -1) return dp[start][m][sum];
        int left = 0;
        int mini = Integer.MAX_VALUE;
        int curSum = sum;
        for (int i = start; i < n - 1; i++)
        {
            left += nums[i];
            curSum -= nums[i];
            int right = solve(i + 1, curSum, m - 1, nums, n, dp);
            int largest = Math.max(left, right);
            mini = Math.min(mini, largest);
        }
        return dp[start][m][sum] = mini;
    }
}
