package Dynamic_Programming_Series.String;

public class CN_Edit_Distance {
    
    public static int solve(int i, int j, String str1, String str2)
    {
        // base case
        if (i < 0) return j+1;
        if (j < 0) return i+1;

        if (str1.charAt(i) == str2.charAt(j))
        {
            return 0 + solve(i-1, j-1, str1, str2);
        }
        else
        {
            return Math.min(1 + solve(i, j-1, str1, str2), 
                            Math.min(1 + solve(i-1, j, str1, str2), 
                                     1 + solve(i-1, j-1, str1, str2)));
        }
    }

    // Recursion
    // TC -> Exponential -> O(3^n * 3^m)
    // SC -> O(N + M)
    public static int editDistance_1(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        return solve(n-1, m-1, str1, str2);
    }

    public static int solve_2(int i, int j, String str1, String str2)
    {
        // base case
        if (i == 0) return j;
        if (j == 0) return i;

        if (str1.charAt(i-1) == str2.charAt(j-1))
        {
            return 0 + solve_2(i-1, j-1, str1, str2);
        }
        else
        {
            return Math.min(1 + solve_2(i, j-1, str1, str2), 
                            Math.min(1 + solve_2(i-1, j, str1, str2), 
                                     1 + solve_2(i-1, j-1, str1, str2)));
        }
    }

    // Recursion
    // TC -> Exponential -> O(3^n * 3^m)
    // SC -> O(N + M)
    public static int editDistance_2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        return solve_2(n, m, str1, str2);
    }

    public static int solve_3(int i, int j, String str1, String str2, int[][] dp)
    {
        // base case
        if (i == 0) return j;
        if (j == 0) return i;

        if (dp[i][j] != -1) return dp[i][j];
        if (str1.charAt(i-1) == str2.charAt(j-1))
        {
            return dp[i][j] = 0 + solve_3(i-1, j-1, str1, str2, dp);
        }
        else
        {
            return dp[i][j] = Math.min(1 + solve_3(i, j-1, str1, str2, dp), 
                              Math.min(1 + solve_3(i-1, j, str1, str2, dp), 
                                       1 + solve_3(i-1, j-1, str1, str2, dp)));
        }
    }

    // Memoization
    // TC -> O(N * M)
    // SC -> O(N * M) + O(N + M)
    public static int editDistance_3(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                dp[i][j] = -1;
            }
        }

        return solve_3(n, m, str1, str2, dp);
    }

    // Tabulation
    // TC -> O(N * M)
    // SC -> O(N * M)
    public static int editDistance_4(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        // base case
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;
        

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (str1.charAt(i-1) == str2.charAt(j-1))
                {
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.min(1 + dp[i][j-1], 
                                    Math.min(1 + dp[i-1][j], 
                                            1 + dp[i-1][j-1]));
                }
            }
        }

        return dp[n][m];
    }

    // Space optimization
    // TC -> O(N * M)
    // SC -> O(M)
    public static int editDistance_5(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[] prev = new int[m+1];

        // base case
        for (int j = 0; j <= m; j++) prev[j] = j;
        
        for (int i = 1; i <= n; i++)
        {
            int[] cur = new int[m+1];
            cur[0] = i;
            for (int j = 1; j <= m; j++)
            {
                if (str1.charAt(i-1) == str2.charAt(j-1))
                {
                    cur[j] = 0 + prev[j-1];
                }
                else
                {
                    cur[j] = Math.min(1 + cur[j-1], 
                                    Math.min(1 + prev[j], 
                                            1 + prev[j-1]));
                }
            }
            prev = cur;
        }

        return prev[m];
    }
}
