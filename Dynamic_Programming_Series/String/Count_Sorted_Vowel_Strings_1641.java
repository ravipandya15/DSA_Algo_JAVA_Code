package Dynamic_Programming_Series.String;

import java.util.Arrays;

public class Count_Sorted_Vowel_Strings_1641 {

    public static int solve(int n, int ind, int[][] dp)
    {
        if (n == 0) return 1;

        if (dp[n][ind] != -1) return dp[n][ind];
        
        int count = 0;
        for (int i = ind; i < 5; i++)
        {
            count += solve(n-1, i, dp);
        }
        return dp[n][ind] = count;
    }
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];
        for (int[] temp : dp)
        {
            Arrays.fill(temp, -1);
        }
        
        return solve(n, 0, dp);
    }

    public int countVowelStrings_1(int n) {
        int[][] dp = new int[n+1][5];

        // base case
        for (int i = 0; i < 5; i++)
        {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int ind = 4; ind >= 0; ind--)
            {
                int count = 0;
                for (int j = ind; j < 5; j++)
                {
                    count += dp[i-1][j];
                }
                dp[i][ind] = count;
            }
        }

        return dp[n][0];
    }

    public int countVowelStrings_2(int n) {
        int[][] dp = new int[n+1][5];

        // base case
        for (int i = 0; i < 5; i++)
        {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int ind = 4; ind >= 0; ind--)
            {
                dp[i][ind] = dp[i-1][ind];
                if (ind + 1 < 5) dp[i][ind] += dp[i][ind+1];
            }
        }

        return dp[n][0];
    }

    public int countVowelStrings_3(int n) {
        int[] prev = new int[5];

        // base case
        for (int i = 0; i < 5; i++)
        {
            prev[i] = 1;
        }

        for (int i = 1; i <= n; i++)
        {
            int[] cur = new int[5];
            for (int ind = 4; ind >= 0; ind--)
            {
                cur[ind] = prev[ind];
                if (ind + 1 < 5) cur[ind] += cur[ind+1];
            }
            prev = cur;
        }

        return prev[0];
    }
}
