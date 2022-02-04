package Dynamic_Programming_Series;

public class CN_Subset_Sum_Equal_To_K {
    
    public static boolean solve(int index, int target, int[] arr)
    {
        // base cases
        if (target == 0) return true;
        if (index == 0) return (arr[index] == target);

        // explore possiblities of that index
        boolean notTake = solve(index -1, target, arr);
        boolean take = false;
        if (target >= arr[index])
            take = solve(index - 1, target - arr[index], arr);

        return notTake || take;
    }

    // Recursion
    // TC -> O(2^n)
    // SC -> O(N)
    public static boolean subsetSumToK1(int n, int k, int[] arr){
        return solve(n-1, k, arr);
	}

    public static int solve1(int index, int target, int[] arr, int[][] dp)
    {
        // base cases
        if (target == 0) return 1;
        if (index == 0) return (arr[index] == target) ? 1 : 0;

        if (dp[index][target] != -1)  return dp[index][target];
        // explore possiblities of that index
        int notTake = solve1(index -1, target, arr, dp);
        int take = 0;
        if (target >= arr[index])
            take = solve1(index - 1, target - arr[index], arr, dp);

        if (take == 1 || notTake == 1) 
        {
            return dp[index][target] = 1;
        }
        else
        {
            return dp[index][target] = 0;
        }
    }

    // Memoization
    // TC -> O(N * target)
    // SC -> O(N) + O(N * target)
    public static boolean subsetSumToK2(int n, int k, int[] arr){
        int[][] dp = new int[n][k+1];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < k+1; j++)
            {
                dp[i][j] = -1;
            }
        }
        
        if(solve1(n-1, k, arr, dp) == 1)
            return true;
        else return false;
	}

    // Tabulation
    // TC -> O(N * target)
    // SC -> O(N * target) 
    public static boolean subsetSumToK3(int n, int k, int[] arr){
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

    // Space optimization
    // TC -> O(N * target)
    // SC -> O(target) 
    public static boolean subsetSumToK4(int n, int k, int[] arr){
        boolean[] prev = new boolean[k+1];

        // base cases
        prev[0] = true;
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
        return prev[k];
	}
}
