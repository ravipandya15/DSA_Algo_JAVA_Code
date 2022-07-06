package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;
import java.util.Arrays;

public class Stone_Game_II_1140 {
    public static int solve(int index, int M, int[] piles, int[][] dp)
    {
        if (index >= piles.length) return 0;

        if (dp[index][M] != -1) return dp[index][M];

        int stones = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < 2*M; i++)
        {
            if (index + i < piles.length) ans += piles[index + i];
            stones = Math.max(stones, ans - solve(index + i + 1, Math.max(M, i + 1), piles, dp));
        }
        return dp[index][M] = stones;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n+1][2 * (n+1)];
        for (int[] temp : dp)
        {
            Arrays.fill(temp, -1);
        }
        int ans = solve(0, 1, piles, dp);
        for (int i = 0; i < piles.length; i++)
        {
            ans += piles[i];
        }
        return ans/2;
    }
}
