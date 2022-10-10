package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Stone_Game_IV_1510 {
    public static int solve(int n, int[] dp)
    {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        for (int i = 1; i * i <= n; i++)
        {
            // if 2nd player return false then first will win; 
            if (solve(n - i * i, dp) == 0) return dp[n] = 1;
        }
        return dp[n] = 0;
    }

    // Memoization
    public boolean winnerSquareGame(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp) == 1 ? true : false;
    }


    // Tabulation
    public boolean winnerSquareGame_2(int n) {
        int[] dp = new int[n+1];
        
        for (int index = 1; index <= n; index++)
        {
            for (int i = 1; i * i <= index; i++)
            {
                // if 2nd player return false then first will win; 
                if (dp[index - i * i] == 0)
                {
                    dp[index] = 1;
                    break;
                }
            }
        }
        return dp[n] == 1 ? true : false;
    }
}
