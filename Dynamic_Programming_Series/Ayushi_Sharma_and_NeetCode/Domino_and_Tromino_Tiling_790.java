package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

public class Domino_and_Tromino_Tiling_790 {
    public int numTilings(int n) {
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        if (n <= 3) return (int)dp[n];

        for (int i = 4; i <= n; i++)
        {
            dp[i] = 2 * dp[i-1] + dp[i-3];
            dp[i] = dp[i] % 1000000007;
        }
        return (int)dp[n];
    }
}
