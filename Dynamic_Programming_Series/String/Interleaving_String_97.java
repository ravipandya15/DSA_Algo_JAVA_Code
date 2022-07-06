package Dynamic_Programming_Series.String;

import java.util.Arrays;

public class Interleaving_String_97 {

    public static boolean solve(int id1, int id2, String s1, String s2, String s3, int n1, int n2)
    {
        if (id1 == n1 && id2 == n2) return true;

        if (id1 < n1 && s3.charAt(id1+id2) == s1.charAt(id1))
        {
            if (solve(id1+1, id2, s1, s2, s3, n1, n2) == true) return true;
        }
        if (id2 < n2 && s3.charAt(id1+id2) == s2.charAt(id2))
        {
            if (solve(id1, id2+1, s1, s2, s3, n1, n2) == true) return true;
        }
        return false;
    }

    // Recursion
    // TC -> 2^(N + M)
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (s3.length() != n1 + n2) return false;
        return solve(0,0, s1, s2, s3, n1, n2);
    }

    public static int solve_1(int id1, int id2, String s1, String s2, String s3, int n1, int n2, int[][] dp)
    {
        if (id1 == n1 && id2 == n2) return 1;
        if (dp[id1][id2] != -1) return dp[id1][id2];

        if (id1 < n1 && s3.charAt(id1+id2) == s1.charAt(id1))
        {
            if (solve_1(id1+1, id2, s1, s2, s3, n1, n2, dp) == 1) return 1;
        }
        if (id2 < n2 && s3.charAt(id1+id2) == s2.charAt(id2))
        {
            if (solve_1(id1, id2+1, s1, s2, s3, n1, n2, dp) == 1) return 1;
        }
        return dp[id1][id2] = 0;
    }

    // Memoization
    // TC -> O(N * M)
    public boolean isInterleave_2(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (s3.length() != n1 + n2) return false;
        int[][] dp = new int[n1+1][n2+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return (solve_1(0,0, s1, s2, s3, n1, n2,dp) == 1) ? true : false;
    }

    // Tabulation
    // TC -> O(N * M)
    public boolean isInterleave_3(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (s3.length() != n1 + n2) return false;
        int[][] dp = new int[n1+1][n2+1];

        // base case
        dp[n1][n2] = 1;

        for (int id1 = n1; id1 >= 0; id1--)
        {
            for (int id2 = n2; id2 >= 0; id2--)
            {
                if (id1 < n1 && s3.charAt(id1+id2) == s1.charAt(id1))
                {
                    if (dp[id1+1][id2] == 1) dp[id1][id2] = 1;
                }
                if (id2 < n2 && s3.charAt(id1+id2) == s2.charAt(id2))
                {
                    if (dp[id1][id2+1] == 1) dp[id1][id2] = 1;
                }
            }
        }

        return (dp[0][0] == 1) ? true : false;
    }

    // Space optimization
    // TC -> O(N * M)
    // Not working
    public boolean isInterleave_4(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (s3.length() != n1 + n2) return false;
        int[] next = new int[n2+1];

        // base case
        next[n2] = 1;

        for (int id1 = n1; id1 >= 0; id1--)
        {
            int[] cur = new int[n2+1];
            for (int id2 = n2; id2 >= 0; id2--)
            {
                if (id1 < n1 && s3.charAt(id1+id2) == s1.charAt(id1))
                {
                    if (next[id2] == 1) cur[id2] = 1;
                }
                if (id2 < n2 && s3.charAt(id1+id2) == s2.charAt(id2))
                {
                    if (cur[id2+1] == 1) cur[id2] = 1;
                }
                next = cur;
            }
        }

        return (next[0] == 1) ? true : false;
    }
}
