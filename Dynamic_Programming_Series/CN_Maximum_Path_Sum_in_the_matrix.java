package Dynamic_Programming_Series;

import java.util.Arrays;

public class CN_Maximum_Path_Sum_in_the_matrix {
    
    public static int solve(int i, int j, int[][] matrix)
    {
        // base cases
        if (j < 0 || j >= matrix[0].length) return (int)-1e8;
        if (i == 0) return matrix[0][j];

        int u = matrix[i][j] + solve(i-1, j, matrix);
        int ld = matrix[i][j] + solve(i-1, j-1, matrix);
        int rd = matrix[i][j] + solve(i-1, j+1, matrix);

        return Math.max(u, Math.max(ld, rd));
    }

    // Recursion
    // TC -> O(3^(N))
    // SC -> O(N)
    public static int getMaxPathSum1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxi = (int)-1e8;
        for (int j = 0; j < m; j++)
        {
            maxi = Math.max(maxi, solve(n-1, j, matrix));
        }

        return maxi;
	}

    public static int solve1(int i, int j, int[][] matrix, int[][] dp)
    {
        // base cases
        if (j < 0 || j >= matrix[0].length) return (int)-1e8;
        if (i == 0) return matrix[0][j];

        if (dp[i][j] != -1) return dp[i][j];

        int u = matrix[i][j] + solve1(i-1, j, matrix, dp);
        int ld = matrix[i][j] + solve1(i-1, j-1, matrix, dp);
        int rd = matrix[i][j] + solve1(i-1, j+1, matrix, dp);

        return dp[i][j] = Math.max(u, Math.max(ld, rd));
    }
    
    // Memoization
    // TC -> O(N * M)
    // SC -> O(N) + O(N * M)
    public static int getMaxPathSum2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int maxi = (int)-1e8;
        for (int j = 0; j < m; j++)
        {
            maxi = Math.max(maxi, solve1(n-1, j, matrix, dp));
        }

        return maxi;
	}

    // Tabulation
    // TC -> O(N * M)
    // SC -> O(N) + O(N * M)
    public static int getMaxPathSum3(int[][] matrix) {
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
                else ld += (int)-1e8;
                int rd = matrix[i][j];
                if (j+1 < m) rd += dp[i-1][j+1];
                else rd += (int)-1e8;

                dp[i][j] = Math.max(u, Math.max(ld, rd));
            }
        }

        int maxi = (int)-1e8;
        for (int j = 0; j < m; j++)
        {
            maxi = Math.max(maxi, dp[n-1][j]);
        }

        return maxi;
	}

    // Space Optimization
    // TC -> O(N * M)
    // SC -> O(N) + O(N * M)
    public static int getMaxPathSum4(int[][] matrix) {
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
                else ld += (int)-1e8;
                int rd = matrix[i][j];
                if (j+1 < m) rd += prev[j+1];
                else rd += (int)-1e8;

                cur[j] = Math.max(u, Math.max(ld, rd));
            }
            // IMP
            prev = cur;
        }

        int maxi = (int)-1e8;
        for (int j = 0; j < m; j++)
        {
            maxi = Math.max(maxi, prev[j]);
        }

        return maxi;
	}
}
