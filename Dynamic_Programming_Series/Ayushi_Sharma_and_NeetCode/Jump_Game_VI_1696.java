package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Jump_Game_VI_1696 {

    // TC -> O(N)
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();
        q.offer(0); // or q.add(0);

        for (int i = 1; i < n; i++)
        {
            while (!q.isEmpty() && q.peekFirst() + k < i)
            {
                q.pollFirst();
            }

            nums[i] = nums[i] + nums[q.peek()];
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i])
            {
                q.pollLast();
            }
            q.addLast(i);
        }
        return nums[n-1];
    }

    public static int solve(int ind, int[] nums, int k, int n, int[] dp)
    {
        // base case
        //if (ind >= n) return Integer.MIN_VALUE;
        if (ind == n-1) return nums[ind];

        if (dp[ind] != -1) return dp[ind];

        int score = Integer.MIN_VALUE;
        for (int i = ind+1; i <= Math.min(ind + k, n-1); i++)
        {
            score = Math.max(score, nums[ind] + solve(i, nums, k, n, dp));
        }
        return dp[ind] = score;
    }

    // TC -> o(N * K)
    public int maxResult_1(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, nums, k, n, dp);
    }

}
