package Dynamic_Programming_Series.String;

public class CN_Shortest_Supersequence {
    
    public static String shortestSupersequence(String s, String t) {
        // lcs Code
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

        StringBuilder sb = new StringBuilder();
        int i = n, j = m;

        while (i > 0 && j > 0)
        {
            if (s.charAt(i-1) == t.charAt(j-1))
            {
                sb.append(s.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i-1][j] > dp[i][j-1])
            {
                sb.append(s.charAt(i-1));
                i--;
            }
            else
            {
                sb.append(t.charAt(j-1));
                j--;
            }
        }

        while (i > 0)
        {
            sb.append(s.charAt(i-1));
            i--;
        }
        while (j > 0)
        {
            sb.append(t.charAt(j-1));
            j--;
        }

        sb.reverse();

        return sb.toString();
    }
}
