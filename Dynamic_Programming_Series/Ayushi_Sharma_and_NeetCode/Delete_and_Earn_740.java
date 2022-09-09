package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

public class Delete_and_Earn_740 {

    // taken code from house robber
    // CN_Maximum_sum_of_non_adjacent_elements

    public int deleteAndEarn_1(int[] nums) {
        int n = 10001;
        int[] freq = new int[10001];

        for (int num : nums) freq[num] += num;

        int[] dp = new int[n];
        dp[0] = freq[0];

        for (int i = 1; i < n; i++)
        {
            int pick = freq[i];
            if (i -2 >= 0) pick += dp[i-2];

            int not_pick = dp[i - 1];

            dp[i] = Math.max(pick, not_pick);
        }

        return dp[n-1];
    }

    public int deleteAndEarn(int[] nums) {
        int n = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            n = Math.max(n, nums[i]);
        }
        n = n+1;
        int[] freq = new int[n];

        for (int num : nums) freq[num] += num;

        int[] dp = new int[n];
        dp[0] = freq[0];

        for (int i = 1; i < n; i++)
        {
            int pick = freq[i];
            if (i -2 >= 0) pick += dp[i-2];

            int not_pick = dp[i - 1];

            dp[i] = Math.max(pick, not_pick);
        }

        return dp[n-1];
    }
}
