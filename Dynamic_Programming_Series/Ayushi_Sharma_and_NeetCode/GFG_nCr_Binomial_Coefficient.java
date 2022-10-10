package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

public class GFG_nCr_Binomial_Coefficient {
    public static int nCr(int n, int r){
        // base cases
        if (r > n) return 0;
        if (n-r < r) r = n - r; // or (r > n - r) r = n - r;

        int[] dp = new int[r+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = Math.min(r, i); j> 0; j--)
            {
                dp[j] = (dp[j] + dp[j-1]) % 1000000007;
            }
        }
        return dp[r];
    }
}
