package Dynamic_Programming_Series.String;

public class Wildcard_Matching_44_CN_Wildcard_Pattern_Matching {
    
    public static boolean solve(int i, int j, String pattern, String text)
    {
        // base case
        if(i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) return false;
        if (j < 0 && i >= 0)
        {
            for (int ii = 0; ii <= i; ii++)
            {
                if (pattern.charAt(ii) != '*')
                {
                    return false;
                }
            }
            return true;
        }

        if (( pattern.charAt(i) == text.charAt(j) ) || ( pattern.charAt(i) == '?') )
        {
            return solve(i-1, j-1, pattern, text);
        }
        else if ( (pattern.charAt(i) == '*'))
        {
            return solve(i-1, j, pattern, text) | solve(i, j-1, pattern, text);
        }
        else
        {
            return false;
        }
    }
    
    // Recursion
    // TC -> Exponential
    // SC -> O(N + M) -> Auxilary Stack space
    public static boolean wildcardMatching_1(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        return solve(n-1, m-1, pattern, text);
	}

    public static boolean solve_1(int i, int j, String pattern, String text)
    {
        // base case
        if(i == 0 && j == 0) return true;
        if (i == 0 && j > 0) return false;
        if (j == 0 && i > 0)
        {
            for (int ii = 1; ii <= i; ii++)
            {
                if (pattern.charAt(ii-1) != '*')
                {
                    return false;
                }
            }
            return true;
        }

        if (( pattern.charAt(i-1) == text.charAt(j-1) ) || ( pattern.charAt(i-1) == '?') )
        {
            return solve_1(i-1, j-1, pattern, text);
        }
        else if ( (pattern.charAt(i-1) == '*'))
        {
            return solve_1(i-1, j, pattern, text) | solve_1(i, j-1, pattern, text);
        }
        else
        {
            return false;
        }
    }

    // Recursion (1 based indexing)
    // TC -> Exponential
    // SC -> O(N + M)
    public static boolean wildcardMatching_2(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        return solve_1(n, m, pattern, text);
	}

    public static int solve_2(int i, int j, String pattern, String text, int[][] dp)
    {
        // base case
        if(i == 0 && j == 0) return 1;
        if (i == 0 && j > 0) return 0;
        if (j == 0 && i > 0)
        {
            for (int ii = 1; ii <= i; ii++)
            {
                if (pattern.charAt(ii-1) != '*')
                {
                    return 0;
                }
            }
            return 1;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (( pattern.charAt(i-1) == text.charAt(j-1) ) || ( pattern.charAt(i-1) == '?') )
        {
            return dp[i][j] = solve_2(i-1, j-1, pattern, text, dp);
        }
        else if ( (pattern.charAt(i-1) == '*'))
        {
            return dp[i][j] = solve_2(i-1, j, pattern, text, dp) | solve_2(i, j-1, pattern, text, dp);
        }
        else
        {
            return 0;
        }
    }

    // Memoization
    // TC -> O(N * M)
    // SC ->  O(N * M) + O(N + M)
    public static boolean wildcardMatching_3(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++)
        {
            for (int j = 0; j < m+1; j++)
            {
                dp[i][j] = -1;
            }
        }
        return solve_2(n, m, pattern, text, dp) == 1 ? true : false;
	}

    // Tabulation
    // TC -> O(N * M)
    // SC -> O(N * M)
    public static boolean wildcardMatching_4(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        boolean[][] dp = new boolean[n+1][m+1];
        
        // base case
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) dp[0][j] = false;
        for (int i = 1; i <= n; i++)
        {
            boolean flag = true;
            for (int ii = 1; ii <= i; ii++)
            {
                if (pattern.charAt(ii-1) != '*')
                {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }


        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (( pattern.charAt(i-1) == text.charAt(j-1) ) || ( pattern.charAt(i-1) == '?') )
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if ( (pattern.charAt(i-1) == '*'))
                {
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                }
                else
                {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
	}

    // Space optimization
    // TC -> O(N * M)
    // SC -> O(M)
    public static boolean wildcardMatching_5(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        boolean[] prev = new boolean[m+1];
        
        // base case
        prev[0] = true;
        for (int j = 1; j <= m; j++) prev[j] = false;

        for (int i = 1; i <= n; i++)
        {
            boolean[] cur = new boolean[m+1];
            boolean flag = true;
            for (int ii = 1; ii <= i; ii++)
            {
                if (pattern.charAt(ii-1) != '*')
                {
                    flag = false;
                    break;
                }
            }
           cur[0] = flag;

            for (int j = 1; j <= m; j++)
            {
                if (( pattern.charAt(i-1) == text.charAt(j-1) ) || ( pattern.charAt(i-1) == '?') )
                {
                    cur[j] = prev[j-1];
                }
                else if ( (pattern.charAt(i-1) == '*'))
                {
                    cur[j] = prev[j] | cur[j-1];
                }
                else
                {
                    cur[j] = false;
                }
            }
            prev = cur;
        }

        return prev[m];
	}
}
