package Dynamic_Programming_Series;

public class CN_Partition_Equal_Subset_Sum {
    
    // Tabulation
    // TC -> O(N) + O(N * target)
    // SC -> O(N * target) 
    public static boolean subsetSumToK(int n, int k, int[] arr){
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
        return dp[n-1][k];
	}

    // same code as SubsetSum equal to K
    public static boolean canPartition(int[] arr, int n) {
		int totalSum = 0;
        for (int i = 0; i < n; i++)
        {
            totalSum += arr[i];
        }

        if (totalSum % 2 != 0) return false;
        int k = totalSum / 2;
        return subsetSumToK(n, k, arr);
	}
}

