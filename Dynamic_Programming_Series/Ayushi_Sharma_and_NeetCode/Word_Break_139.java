package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;
import java.util.List;

public class Word_Break_139 {

    public static int solve(int index, String s, List<String> wordDict, int n)
    {
        if (index == n) return 1;

        boolean ans = false;

        for (int i = index; i < n; i++)
        {
            for (String word : wordDict)
            {
                if (s.substring(index, i+1).equals(word))
                {
                    boolean res = false;
                    if (solve(index + word.length(), s, wordDict, n) == 1) res = true;
                    ans = ans || res;
                }
            }
        }

        return ans == true ? 1 : 0;
    }

    // recursion
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        return solve(0, s, wordDict, n) == 1 ? true : false;
    }

    public static int solve_1(int index, String s, List<String> wordDict, int n, int[] dp)
    {
        if (index == n) return 1;
        if (dp[index] != -1) return dp[index];
        boolean ans = false;

        for (int i = index; i < n; i++)
        {
            for (String word : wordDict)
            {
                if (s.substring(index, i+1).equals(word))
                {
                    boolean res = false;
                    if (solve_1(index + word.length(), s, wordDict, n, dp) == 1) res = true;
                    ans = ans || res;
                }
            }
        }

        return dp[index] = (ans == true) ? 1 : 0;
    }

    // Memoization
    public boolean wordBreak_2(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve_1(0, s, wordDict, n, dp) == 1 ? true : false;
    }

    // Tabulation
    public boolean wordBreak_3(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n+1];

        // base case
        dp[n] = 1;

        for (int index = n-1; index >= 0; index--)
        {
            boolean ans = false;

            for (int i = index; i < n; i++)
            {
                for (String word : wordDict)
                {
                    if (s.substring(index, i+1).equals(word))
                    {
                        boolean res = false;
                        if (dp[index + word.length()] == 1) res = true;
                        ans = ans || res;
                    }
                }
            }
            dp[index] = (ans == true) ? 1 : 0;
        }


        return (dp[0] == 1) ? true : false;
    }

    // Improved Tabulation
    public boolean wordBreak_4(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n+1];

        // base case
        dp[n] = 1;

        for (int index = n-1; index >= 0; index--)
        {
            boolean ans = false;

            for (String word : wordDict)
            {
                if (index + word.length() <= n &&  s.substring(index, index + word.length()).equals(word))
                {
                    boolean res = false;
                    if (dp[index + word.length()] == 1) res = true;
                    ans = ans || res;
                }
            }
            dp[index] = (ans == true) ? 1 : 0;
        }


        return (dp[0] == 1) ? true : false;
    }
}
