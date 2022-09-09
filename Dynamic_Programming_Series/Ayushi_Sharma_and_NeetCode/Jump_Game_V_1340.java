package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Jump_Game_V_1340 {

    public static int solve(int ind, int[] arr, int d, int n, int[] dp)
    {
        int ans = 1;
        if (dp[ind] != -1) return dp[ind];
        for (int i = ind + 1; i <= Math.min(n-1, ind + d) && arr[i] < arr[ind]; i++)
        {
            ans = Math.max(ans, 1 + solve(i, arr, d, n, dp));
        }
        for (int i = ind - 1; i >= Math.max(0, ind - d) && arr[i] < arr[ind]; i--)
        {
            ans = Math.max(ans, 1 + solve(i, arr, d, n, dp));
        }
        return dp[ind] = ans;
    }

    // memoization
    public int maxJumps(int[] arr, int d) {
        int ans = 1;
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++)
        {
            ans = Math.max(ans, solve(i, arr, d, n, dp));
        }
        return ans;
    }
}
