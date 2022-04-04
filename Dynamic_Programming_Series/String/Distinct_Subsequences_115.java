package Dynamic_Programming_Series.String;

import java.util.Arrays;

public class Distinct_Subsequences_115 {
    
    public int solve(int i, int j, String s, String t)
    {
        // base case
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (s.charAt(i) == t.charAt(j))
        {
            return solve(i-1, j-1, s, t) + solve(i-1, j, s, t);
        }
        else
        {
            return solve(i-1, j, s, t);
        }
    }

    // Recursion
    // TC -> Exponential (2^n * 2^m) -> n : len of string s1, m : len of string s2
    // SC -> O(N + M)
    public int numDistinct_1(String s, String t) {
        int n = s.length();
        int m = t.length();

        return solve(n-1, m-1, s, t);
    }

    public int solve_1(int i, int j, String s, String t)
    {
        // base case
        if (j == 0) return 1;
        if (i == 0) return 0;

        if (s.charAt(i-1) == t.charAt(j-1))
        {
            return solve_1(i-1, j-1, s, t) + solve_1(i-1, j, s, t);
        }
        else
        {
            return solve_1(i-1, j, s, t);
        }
    }

    // Recursion
    // TC -> Exponential (2^n * 2^m) -> n : len of string s1, m : len of string s2
    // SC -> O(N + M)
    public int numDistinct_2(String s, String t) {
        int n = s.length();
        int m = t.length();

        return solve_1(n, m, s, t);
    }

    public int solve_2(int i, int j, String s, String t, int[][] dp)
    {
        // base case
        if (j == 0) return 1;
        if (i == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i-1) == t.charAt(j-1))
        {
            return dp[i][j] = solve_2(i-1, j-1, s, t, dp) + solve_2(i-1, j, s, t, dp);
        }
        else
        {
            return dp[i][j] = solve_2(i-1, j, s, t, dp);
        }
    }

    // Memoization
    // TC -> O(N * M)
    // SC -> O(N * M) + O(N + M)
    public int numDistinct_3(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp)
        {
            Arrays.fill(row, -1);
        }

        return solve_2(n, m, s, t, dp);
    }

    // Tabulation
    // TC -> O(N * M)
    // SC -> O(N * M)
    public int numDistinct_4(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        // base case
        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= m; j++)
        {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (s.charAt(i-1) == t.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];    
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }

    // Space optimization
    // TC -> O(N * M)
    // SC -> O(M)
    public int numDistinct_5(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];

        // base case
        prev[0] = 1;

        for (int i = 1; i <= n; i++)
        {
            int[] cur = new int[m+1];
            cur[0] = 1;
            for (int j = 1; j <= m; j++)
            {
                if (s.charAt(i-1) == t.charAt(j-1))
                {
                    cur[j] = prev[j-1] + prev[j];                }
                else
                {
                   cur[j] = prev[j];
                }
            }
            prev = cur;
        }

        return prev[m];
    }

    // 1D array Space optimization - (Only 1D array is required)
    // TC -> O(N * M)
    // SC -> O(M)
    public int numDistinct_6(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];

        // base case
        prev[0] = 1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = m; j >= 1; j--)
            {
                if (s.charAt(i-1) == t.charAt(j-1))
                {
                    prev[j] = prev[j-1] + prev[j];                
                }
                // else
                // {
                //    prev[j] = prev[j];
                // }
            }

        }

        return prev[m];
    }
}
