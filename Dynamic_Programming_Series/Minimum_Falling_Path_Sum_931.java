package Dynamic_Programming_Series;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum_931 {
    public static int solve1(int i, int j, int[][] matrix, int[][] dp)
    {
        // base cases
        if (j < 0 || j >= matrix[0].length) return (int)1e8;
        if (i == 0) return matrix[0][j];

        if (dp[i][j] != -1) return dp[i][j];

        int u = matrix[i][j] + solve1(i-1, j, matrix, dp);
        int ld = matrix[i][j] + solve1(i-1, j-1, matrix, dp);
        int rd = matrix[i][j] + solve1(i-1, j+1, matrix, dp);

        return dp[i][j] = Math.min(u, Math.min(ld, rd));
    }

    // Memoization
    // TC -> O(N * M)
    // SC -> O(N) + O(N * M)
    public int minFallingPathSum_1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int mini = (int)1e8;
        for (int j = 0; j < m; j++)
        {
            mini = Math.min(mini, solve1(n-1, j, matrix, dp));
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
                int u = matrix[i][j] + dp[i-1][j];
                int ld = matrix[i][j];
                if (j - 1 >= 0) ld += dp[i-1][j-1];
                else ld += (int)1e8;
                int rd = matrix[i][j];
                if (j+1 < m) rd += dp[i-1][j+1];
                else rd += (int)1e8;

                dp[i][j] = Math.min(u, Math.min(ld, rd));
            }
        }

        int mini = (int)1e8;
        for (int j = 0; j < m; j++)
        {
            mini = Math.min(mini, dp[n-1][j]);
        }

        return mini;
    }

    // Space Optimization
    // TC -> O(N * M)
    // SC -> O(N) + O(N * M)
    public int minFallingPathSum_3(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];

        // base case
        for (int i = 0; i < m; i++)
        {
            prev[i] = matrix[0][i]; 
        }

        for (int i = 1; i < n; i++)
        {
            int[] cur = new int[m];
            for (int j = 0; j < m; j++)
            {
                int u = matrix[i][j] + prev[j];
                int ld = matrix[i][j];
                if (j - 1 >= 0) ld += prev[j-1];
                else ld += (int)1e8;
                int rd = matrix[i][j];
                if (j+1 < m) rd += prev[j+1];
                else rd += (int)1e8;

                cur[j] = Math.min(u, Math.min(ld, rd));
            }
            // IMP
            prev = cur;
        }

        int mini = (int)1e8;
        for (int j = 0; j < m; j++)
        {
            mini = Math.min(mini, prev[j]);
        }

        return mini;
    }
}
