package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

//GFG_Largest_square_formed_in_a_matrix
// same problem


public class Maximal_Square_221 {
    // TC -> O(N * M)
    // SC -> O(N * M)
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int size = 0;

        for (int i = 0; i < m; i++)
        {
            dp[i][0] = matrix[i][0] - '0';
            size = Math.max(size, dp[i][0]);
        }
        for (int j = 0; j < n; j++) 
        {
            dp[0][j] = matrix[0][j] - '0';
            size = Math.max(size, dp[0][j]);
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (matrix[i][j] == '1')
                {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
                else dp[i][j] = 0;
                size = Math.max(size, dp[i][j]);
            }
        }

        return size * size;
        
    }

    // TC -> O(N * M)
    // SC -> O(M)
    public int maximalSquare_1(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n];

        int size = 0;

        for (int i = 1; i < m; i++)
        {
            int[] cur = new int[n];
            for (int j = 1; j < n; j++)
            {
                if (i == 0 || j == 0 || matrix[i][j] == '0')
                {
                    cur[j] = Math.min(prev[j-1], Math.min(cur[j-1], prev[j])) + 1;
                }
                else cur[j] = matrix[i][j] - '0';
                size = Math.max(size, cur[j]);
            }
            prev = cur;
        }

        return size * size;
    }

}
