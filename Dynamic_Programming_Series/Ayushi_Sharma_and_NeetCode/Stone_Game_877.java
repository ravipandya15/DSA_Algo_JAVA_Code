package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Stone_Game_877 {
    public static int solve(int l, int r, int[] piles, int[][] dp)
    {
        if (l > r) return 0;

        if (dp[l][r] != -1) return dp[l][r];
        
        boolean flag = false;
        if (r - l % 2 != 0) flag = true;

        int left = 0;
        if (flag == true)
        {
            left += piles[l];
        }
        else
        {
            left -= piles[l];
        }

        int right = 0;
        if (flag == true)
        {
            right += piles[r];
        }
        else
        {
            right -= piles[r];
        }

        return dp[l][r] = Math.max(solve(l + 1, r, piles, dp) + left, solve(l, r - 1, piles, dp) + right);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n+1][n+1];
        for (int[] temp : dp)
        {
            Arrays.fill(temp, -1);
        }
        return solve(0, piles.length - 1, piles, dp) > 0 ? true : false;
    }
}
