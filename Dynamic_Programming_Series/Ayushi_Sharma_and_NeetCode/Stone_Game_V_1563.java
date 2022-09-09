package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;

public class Stone_Game_V_1563 {

    public static int solve(int start, int end, int sum, int[] stoneValue, int[][] dp)
    {
        // base case
        if (start >= end) return 0;

        if (dp[start][end] != -1) return dp[start][end];

        int score = 0;
        int leftSum = 0;
        for (int i = start; i < end; i++)
        {
            leftSum += stoneValue[i];
            int rightSum = sum - leftSum;
            int tempSum = 0;
            if (leftSum < rightSum)
            {
                tempSum += leftSum + solve(start, i, leftSum, stoneValue, dp);
            }
            else if (rightSum < leftSum)
            {
                tempSum += rightSum + solve(i+1, end, rightSum, stoneValue, dp);
            }
            else
            {
                tempSum = leftSum + Math.max(solve(start, i, leftSum, stoneValue, dp), solve(i+1, end, rightSum, stoneValue, dp));
            }
            score = Math.max(score, tempSum);
        }
        return dp[start][end] = score;
    }

    // Memoization
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        int sum = 0;
        for (int i : stoneValue)
        {
            sum += i;
        }
        return solve(0, n-1, sum, stoneValue, dp);
    }

    // Tabulation
    public int stoneGameV_2(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n][n];

        // base case
        for (int start = 0; start < n; start++)
        {
            for (int end = 0; end < n; end++)
            {
                if (start >= end) dp[start][end] = 0;
            }
        }

        for (int start = n-1; start >= 0; start--)
        {
            for (int end = 0; end < n; end++)
            {
                int sum = 0;
                for (int i = start; i <= end; i++)
                {
                    sum += stoneValue[i];
                }

                int score = 0;
                int leftSum = 0;
                for (int i = start; i < end; i++)
                {
                    leftSum += stoneValue[i];
                    int rightSum = sum - leftSum;
                    int tempSum = 0;
                    if (leftSum < rightSum)
                    {
                        tempSum += leftSum + dp[start][i];
                    }
                    else if (rightSum < leftSum)
                    {
                        tempSum += rightSum + dp[i+1][end];
                    }
                    else
                    {
                        tempSum = leftSum + Math.max(dp[start][i], dp[i+1][end]);
                    }
                    score = Math.max(score, tempSum);
                }
                dp[start][end] = score;
            }
        }
        return dp[0][n-1];
    }
}
