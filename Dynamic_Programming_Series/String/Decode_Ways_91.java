package Dynamic_Programming_Series.String;

public class Decode_Ways_91 {
    
    public static int solve(int ind, String s)
    {
        // base case
        if (ind == -1) return 1;
        if (ind == 0)
        {
            if (s.charAt(ind) == '0') return 0;
            else return 1;
        }

        int count = 0;
        if (s.charAt(ind) > '0')
        {
            count += solve(ind - 1, s);
        }
        if ((s.charAt(ind-1) == '1') || (s.charAt(ind-1) == '2' && s.charAt(ind) < '7'))
        {
            count += solve(ind - 2, s);
        }
        return count;
    }

    public int NumDecodings_1(String s) {
        int n = s.length();
        return solve(n - 1, s);
    }

    public static int solve1(int ind, String s)
    {
        // base case
        if (ind == 0) return 1;
        if (ind == 1)
        {
            if (s.charAt(ind-1) == '0') return 0;
            else return 1;
        }

        int count = 0;
        if (s.charAt(ind-1) > '0')
        {
            count += solve1(ind - 1, s);
        }
        if ((s.charAt(ind-2) == '1') || (s.charAt(ind-2) == '2' && s.charAt(ind -1) < '7'))
        {
            count += solve1(ind - 2, s);
        }
        return count;
    }

    // convert to 1 based indexing
    public int NumDecodings_2(String s) {
        int n = s.length();
        return solve1(n, s);
    }

    public static int solve2(int ind, String s, int[] dp)
    {
        // base case
        if (ind == 0) return dp[0] = 1;
        if (ind == 1)
        {
            if (s.charAt(ind-1) == '0') return dp[1] = 0;
            else return dp[1] = 1;
        }

        if (dp[ind] != -1) return dp[ind];

        int count = 0;
        if (s.charAt(ind-1) > '0')
        {
            count += solve2(ind - 1, s, dp);
        }
        if ((s.charAt(ind-2) == '1') || (s.charAt(ind-2) == '2' && s.charAt(ind-1) < '7'))
        {
            count += solve2(ind - 2, s, dp);
        }
        return dp[ind] = count;
    }

    // 1 based indexing
    // Memoization
    public int NumDecodings_3(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = -1;
        return solve2(n, s, dp);
    }

    // tabulation
    public int NumDecodings_4(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];


        // base case
        dp[0] = 1;
        if (s.charAt(0) == '0') dp[1] = 0;
        else dp[1] = 1;

        if (n == 1) return (int)dp[1];

        for (int ind = 2; ind <= n; ind++)
        {
            int count = 0;
            if (s.charAt(ind-1) > '0')
            {
                count += dp[ind - 1];
            }
            if ((s.charAt(ind-2) == '1') || (s.charAt(ind-2) == '2' && s.charAt(ind-1) < '7'))
            {
                count += dp[ind - 2];
            }
            dp[ind] = count;
        }

        return dp[n];
    }
}
