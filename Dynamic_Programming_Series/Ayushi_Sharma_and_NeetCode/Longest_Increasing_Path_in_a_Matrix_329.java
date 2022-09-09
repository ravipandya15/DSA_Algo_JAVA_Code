package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Longest_Increasing_Path_in_a_Matrix_329 {
    public static int solve(int i, int j, int prevVal, int n, int m, int[][] matrix, int[][] dp)
    {
        // base case
        if ( i < 0 || i >= n 
            || j < 0 || j >= m
            || matrix[i][j] <= prevVal)
            {
                return 0;
            }
        
        if (dp[i][j] != -1) return dp[i][j];

        int res = 1;
        res = Math.max(res, 1 + solve(i + 1, j, matrix[i][j], n, m, matrix, dp));
        res = Math.max(res, 1 + solve(i - 1, j, matrix[i][j], n, m, matrix, dp));
        res = Math.max(res, 1 + solve(i, j + 1, matrix[i][j], n, m, matrix, dp));
        res = Math.max(res, 1 + solve(i, j - 1, matrix[i][j], n, m, matrix, dp));
        return dp[i][j] = res;
    }

    // memoization
    // TC -> O(N * M)
    // SC -> O(N * M) + O(N * M)
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ans = 1;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                ans = Math.max(ans, solve(i, j, -1, n, m, matrix, dp));
            }
        }
        return ans;
    }
}
