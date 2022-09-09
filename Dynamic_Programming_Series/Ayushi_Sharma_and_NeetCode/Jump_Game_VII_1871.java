package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Jump_Game_VII_1871 {

    public static int solve(int ind, String s, int min, int max, int n, int[] dp)
    {
        // base case
        if (ind == n-1) return 1;

        if (dp[ind] != -1) return dp[ind];

        for (int i = ind + min; i <= Math.min(ind + max, n-1); i++)
        {
            if (s.charAt(i) == '0')
            {
                if (solve(i, s, min, max, n, dp) == 1) return dp[ind] = 1;
            }
        }
        return dp[ind] = 0;
    }

    // Memoization
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = solve(0, s, minJump, maxJump, n, dp);
        return ans == 1 ? true : false;
    }

    // TC -> O(N)
    public boolean canReach_1(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int farthest = 0;

        while (!q.isEmpty())
        {
            int ind = q.peek();
            q.poll();

            for (int i = Math.max(ind + minJump, farthest + 1); i <= Math.min(ind + maxJump, n-1); i++)
            {
                if (s.charAt(i) == '0')
                {
                    if (i == n-1) return true;
                    q.add(i);
                }
            }
            farthest = ind + maxJump;
        }
        return false;
    }
}
