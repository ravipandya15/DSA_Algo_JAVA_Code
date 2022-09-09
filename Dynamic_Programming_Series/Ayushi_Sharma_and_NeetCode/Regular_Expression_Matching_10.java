package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Regular_Expression_Matching_10 {

    public static int solve(int i, int j, String s, String p, int n, int m)
    {
        // base case
        if (i >= n && j >= m) return 1;
        if (j >= m) return 0;

        int match = 0;
        if (i < n && ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') ) match = 1;

        if (j + 1 < m && p.charAt(j + 1) == '*')
        {
            // use * -> before that current character should match then and only then we can use it repeatative.
            if ( (match == 1) && (solve(i + 1, j, s, p, n, m) == 1) )
            {
                return 1;
            }
            // not use *
            return solve(i, j + 2, s, p, n, m);
        }
        if (match == 1)
        {
            return solve(i + 1, j + 1, s, p, n, m);
        }
        return 0;
    }

    // Recursion
    // TC -> Exponential
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        int ans = solve(0, 0, s, p, n, m);
        return ans == 1 ? true : false;
    }

    public static int solve_1(int i, int j, String s, String p, int n, int m, int[][] dp)
    {
        // base case
        if (i >= n && j >= m) return 1;
        if (j >= m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int match = 0;
        if (i < n && ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') ) match = 1;

        if (j + 1 < m && p.charAt(j + 1) == '*')
        {
            // use * -> before that current character should match then and only then we can use it repeatative.
            if ( (match == 1) && (solve_1(i + 1, j, s, p, n, m, dp) == 1) )
            {
                return dp[i][j] = 1;
            }
            // not use *
            return dp[i][j] = solve_1(i, j + 2, s, p, n, m, dp);
        }
        if (match == 1)
        {
            return dp[i][j] = solve_1(i + 1, j + 1, s, p, n, m, dp);
        }
        return dp[i][j] = 0;
    }

    // memoization
    // TC -> O(N * M)
    // SC -> O(N * M) + O(N * M) [Recusive stack space]
    public boolean isMatch_1(String s, String p) {
        int n = s.length(), m = p.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        int ans = solve_1(0, 0, s, p, n, m, dp);
        return ans == 1 ? true : false;
    }
}
