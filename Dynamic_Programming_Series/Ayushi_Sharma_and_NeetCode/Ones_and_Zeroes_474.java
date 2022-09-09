package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Ones_and_Zeroes_474 {





    // can be improved 
    // no need for index 
    // 2D dp - dp[m][n]
















    public static int solve(int index, int m, int n, String[] strs, int[][][] dp)
    {
        // base case
        if (index < 0) return 0;
        if (m == 0 && n == 0) return 0;

        if (dp[index][m][n] != -1) return dp[index][m][n];

        int count = 0;

        // pick 
        int pick = 0;
        int zeros = 0, ones = 0;
        for (int i = 0; i < strs[index].length(); i++)
        { 
            if (strs[index].charAt(i) == '0') zeros++;
            else ones++;
        }
        if (m >= zeros && n >= ones)
        {
            pick = 1 + solve(index-1, m - zeros, n - ones, strs, dp);
        }

        // non pick
        int nonpick = solve(index - 1, m, n, strs, dp);

        count = Math.max(pick, nonpick);
        return dp[index][m][n] = count;
    }

    // Memoization
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[][][] dp = new int[N+1][m+1][n+1];

        for (int[][] r : dp)
        {
            for (int[] row : r) Arrays.fill(row, -1);
        }
        return solve(N-1, m, n, strs, dp);
    }

    public static int solve_1(int index, int m, int n, String[] strs, int[][][] dp)
    {
        // base case
        if (index == 0) return 0;
        if (m == 0 && n == 0) return 0;

        if (dp[index][m][n] != -1) return dp[index][m][n];

        int count = 0;

        // pick 
        int pick = 0;
        int zeros = 0, ones = 0;
        for (int i = 0; i < strs[index-1].length(); i++)
        { 
            if (strs[index-1].charAt(i) == '0') zeros++;
            else ones++;
        }
        if (m >= zeros && n >= ones)
        {
            pick = 1 + solve_1(index-1, m - zeros, n - ones, strs, dp);
        }

        // non pick
        int nonpick = solve_1(index - 1, m, n, strs, dp);

        count = Math.max(pick, nonpick);
        return dp[index][m][n] = count;
    }

    // Memoization
    // index from 0
    public int findMaxForm_1(String[] strs, int m, int n) {
        int N = strs.length;
        int[][][] dp = new int[N+1][m+1][n+1];

        for (int[][] r : dp)
        {
            for (int[] row : r) Arrays.fill(row, -1);
        }
        return solve_1(N, m, n, strs, dp);
    }

    //Tabulation
    public int findMaxForm_2(String[] strs, int m, int n) {
        int N = strs.length;
        int[][][] dp = new int[N+1][m+1][n+1];

        for (int index = 1; index <= N; index++)
        {
            for (int i = 0; i <= m; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    //if (i == 0 && j == 0) continue;
                    // pick 
                    int pick = 0;
                    int zeros = 0, ones = 0;
                    for (int k = 0; k < strs[index-1].length(); k++)
                    { 
                        if (strs[index-1].charAt(k) == '0') zeros++;
                        else ones++;
                    }
                    if (index-1 >= 0 && i >= zeros && j >= ones)
                    {
                        pick = 1 + dp[index-1][i - zeros][j - ones];
                    }

                    // non pick
                    int nonpick = 0;
                    if (index - 1 >= 0) nonpick = dp[index - 1][i][j];

                    dp[index][i][j] = Math.max(pick, nonpick);
                }
            }
        }

        return dp[N][m][n];
    }
}
