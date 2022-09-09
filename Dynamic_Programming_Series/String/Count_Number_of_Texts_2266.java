package Dynamic_Programming_Series.String;

import java.util.Arrays;

public class Count_Number_of_Texts_2266 {
    public static long solve(int index, String s, int mod, int n,long[] dp)
    {
        if (index == n) return 1;

        if (dp[index] != -1) return dp[index];

        long count = 0;
        char ch = s.charAt(index);

        count = (count + solve(index + 1, s, mod, n, dp)) % mod;
        if (index + 1 < n && ch == s.charAt(index + 1))
        {
            count = (count + solve(index + 2, s, mod, n, dp)) % mod;
            if (index + 2 < n && ch == s.charAt(index + 2))
            {
                count = (count + solve(index + 3, s, mod, n, dp)) % mod;
                if ((ch == '7' || ch == '9') && index + 3 < n && ch == s.charAt(index + 3))
                {
                    count = (count + solve(index + 4, s, mod, n, dp)) % mod;
                }
            }
        }
        return dp[index] = count % mod;
    }

    // memoization
    public int countTexts(String s) {
        int mod = (int)1e9 + 7;
        int n = s.length();
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return (int)solve(0, s, mod, n, dp);
    }

    // tabulation
    public int countTexts_1(String s) {
        int mod = (int)1e9 + 7;
        int n = s.length();
        long[] dp = new long[n+1];
        dp[n] = 1;

        for (int index = n-1; index >= 0; index--)
        {
            long count = 0;
            char ch = s.charAt(index);

            count = (count + dp[index + 1]) % mod;
            if (index + 1 < n && ch == s.charAt(index + 1))
            {
                count = (count + dp[index + 2]) % mod;
                if (index + 2 < n && ch == s.charAt(index + 2))
                {
                    count = (count + dp[index + 3]) % mod;
                    if ((ch == '7' || ch == '9') && index + 3 < n && ch == s.charAt(index + 3))
                    {
                        count = (count + dp[index + 4]) % mod;
                    }
                }
            }
            dp[index] = count % mod;
        }
        return (int)dp[0];
    }
}
