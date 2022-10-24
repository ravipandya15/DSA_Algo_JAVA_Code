package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    public void solve(int ind, int n, int k, List<Integer> ans, List<List<Integer>> result)
    {
        // base case
        if (k == 0)
        {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = ind; i <= n; i++)
        {
            ans.add(i);
            solve(i + 1, n, k - 1, ans, result);
            ans.remove(ans.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(1, n, k, ans, result);
        return result;
    }
}
