package Dynamic_Programming_Series.String;

public class CN_Minimum_insertions_to_make_a_string_palindrome {
    
    // Tabulation
    // TC -> O(N * M)
    // SC -> O(N * M)
    public static int lcs4(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        // base case
        for (int j = 0; j <= m; j++) dp[0][j] = 0;

        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (s.charAt(i-1) == t.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int longestPalindromeSubsequence(String s) {
		StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return lcs4(s, sb.toString());
	}

    public static int minInsertion(String str) {
        return str.length() - longestPalindromeSubsequence(str);
    }
}
