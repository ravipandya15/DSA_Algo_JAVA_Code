package Dynamic_Programming_Series.String;

public class CN_Min_Insertions_Deletions_To_Make_String_A_To_String_B {
    
    public static int canYouMake(String str, String ptr)
    {
        return str.length() + ptr.length() - 2 * lcs4(str, ptr);
    }

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

}
