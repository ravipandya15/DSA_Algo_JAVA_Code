package Dynamic_Programming_Series.String;

import java.util.Arrays;

public class Decode_Ways_II_639 {
    public int solve(int index, String s, int n, int mod, int[] dp)
    {
        // base case
        if (index == n) return 1;

        if (dp[index] != -1) return dp[index];

        if (s.charAt(index) == '0') return 0;
        int res = 0, mul = 1;

        // case 1
        if (s.charAt(index) == '*') mul = 9;

        res += mul * solve(index +1, s, n, mod, dp) % mod;

        // case 2

        if (index < n-1)
        {
            char next = s.charAt(index + 1);
            int option = 0;
            if (s.charAt(index) == '*')
            {
                if (next == '*') option = 15;
                else
                {
                    if (next <= '6') option = 2;
                    else option = 1;
                }
            }
            else if (s.charAt(index) < '3')
            {
                if (next == '*')
                {
                    if (s.charAt(index) == '1') option = 9;
                    else option = 6;
                }
            }

            if (option > 0) res += option * solve(index + 2, s, n, mod, dp) % mod;
        }

        return dp[index] =  res % mod;
    }

    public int numDecodings(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, s, n, mod, dp);
    }
}
