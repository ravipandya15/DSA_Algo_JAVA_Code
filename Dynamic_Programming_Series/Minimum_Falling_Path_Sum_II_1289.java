package Dynamic_Programming_Series;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum_II_1289 {
    public static int solve1(int i, int j, int[][] matrix, int[][] dp, int m)
    {
        // base cases
        if (j < 0 || j >= matrix[0].length) return (int)1e8;
        if (i == 0) return matrix[0][j];

        if (dp[i][j] != -1) return dp[i][j];

        int data = 0, result = Integer.MAX_VALUE;
        for (int col = 0; col < m; col++)
        {
            if (col != j) 
            {
                data = matrix[i][j] + solve1(i-1, col, matrix, dp, m);
                result = Math.min(result, data);
            }
        }

        return dp[i][j] =  result;
    }

    // Memoization
    // TC -> O(N * M)
    // SC -> O(N) + O(N * M)
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int mini = (int)1e8;
        for (int j = 0; j < m; j++)
        {
            mini = Math.min(mini, solve1(n-1, j, matrix, dp, m));
        }

        return mini;
    }

    // Tabulation
    // TC -> O(N * M)
    // SC -> O(N) + O(N * M)
    public int minFallingPathSum_2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, 0);

        // base case
        for (int i = 0; i < m; i++)
        {
            dp[0][i] = matrix[0][i]; 
        }

        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                int data = 0, result = Integer.MAX_VALUE;
                for (int col = 0; col < m; col++)
                {
                    if (col != j) 
                    {
                        data = matrix[i][j] + dp[i-1][col];
                        result = Math.min(result, data);
                    }
                }
                dp[i][j] = result;
            }
        }

        int mini = (int)1e8;
        for (int j = 0; j < m; j++)
        {
            mini = Math.min(mini, dp[n-1][j]);
        }

        return mini;
    }
}
