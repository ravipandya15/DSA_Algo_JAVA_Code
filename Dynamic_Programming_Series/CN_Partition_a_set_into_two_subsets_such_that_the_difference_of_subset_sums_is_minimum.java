package Dynamic_Programming_Series;

public class CN_Partition_a_set_into_two_subsets_such_that_the_difference_of_subset_sums_is_minimum {
    
    // pre - requisist - Subset sum equal to k


    // Tabulation
    // TC -> O(N) + O(N * totalSum) + O(totalSum / 2)
    // SC -> O(N * totalSum) 
    public static int minSubsetSumDifference1(int[] arr, int n) {
		int totalSum = 0;
        for (int i = 0; i < n; i++)
        {
            totalSum += arr[i];
        }
        int k = totalSum;

        boolean[][] dp = new boolean[n][k+1];

        // base cases
        for (int i = 0; i < n; i++)
        {
            dp[i][0] = true;
        }

        if (arr[0] <= k) dp[0][arr[0]] = true;

        for (int index = 1; index < n; index++)
        {
            for (int target = 1; target <= k; target++)
            {
                boolean notTake = dp[index -1][target];
                boolean take = false;
                if (target >= arr[index])
                    take = dp[index - 1][target - arr[index]];

                dp[index][target] = take || notTake;
            }
        }

        int mini = (int)1e9;
        for (int s1 = 0; s1 <= totalSum/2; s1++)
        {
            if (dp[n-1][s1] == true)
            {
                int s2 = k - s1;
                mini = Math.min(mini, Math.abs(s2 - s1));
            }
        }

        return mini;
	}

    // Space Optimization
    // TC -> O(N) + O(N * totalSum) + O(totalSum / 2)
    // SC -> O(totalSum)
    public static int minSubsetSumDifference2(int[] arr, int n) {
		int totalSum = 0;
        for (int i = 0; i < n; i++)
        {
            totalSum += arr[i];
        }
        int k = totalSum;

        boolean[] prev = new boolean[k+1];

        // base cases
        for (int i = 0; i < n; i++)
        {
            prev[0] = true;
        }

        if (arr[0] <= k) prev[arr[0]] = true;

        for (int index = 1; index < n; index++)
        {
            boolean[] cur = new boolean[k+1];
            cur[0] = true;
            for (int target = 1; target <= k; target++)
            {
                boolean notTake = prev[target];
                boolean take = false;
                if (target >= arr[index])
                    take = prev[target - arr[index]];

                cur[target] = take || notTake;
            }
            prev = cur;
        }

        int mini = (int)1e9;
        for (int s1 = 0; s1 <= totalSum/2; s1++)
        {
            if (prev[s1] == true)
            {
                int s2 = k - s1;
                mini = Math.min(mini, Math.abs(s2 - s1));
            }
        }

        return mini;
	}
}
